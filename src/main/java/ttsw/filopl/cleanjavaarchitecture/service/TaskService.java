package ttsw.filopl.cleanjavaarchitecture.service;

import org.springframework.stereotype.Service;
import ttsw.filopl.cleanjavaarchitecture.dto.TaskDto;
import ttsw.filopl.cleanjavaarchitecture.dto.TaskWithChangesDto;
import ttsw.filopl.cleanjavaarchitecture.entity.Task;
import ttsw.filopl.cleanjavaarchitecture.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDto save(TaskDto toSave) {
        return new TaskDto(
                taskRepository.save(
                        taskRepository.findById(toSave.getId())
                                .map(existingTask -> {
                                    if (existingTask.isDone() != toSave.isDone()) {
                                        existingTask.setChangesCount(existingTask.getChangesCount() + 1);
                                        existingTask.setDone(toSave.isDone());
                                    }
                                    existingTask.setAdditionalComment(toSave.getAdditionalComment());
                                    existingTask.setDeadline(toSave.getDeadline());
                                    existingTask.setDescription(toSave.getDescription());
                                    return existingTask;
                                }).orElseGet(() -> {
                                    var result = new Task(toSave.getDescription(), toSave.getDeadline(), null);
                                    result.setAdditionalComment(toSave.getAdditionalComment());
                                    return result;
                                })
                )
        );
    }

    public List<TaskDto> list() {
        return taskRepository.findAll().stream()
                .map(TaskDto::new)
                .collect(toList());
    }

    public List<TaskWithChangesDto> listWithChanges() {
        return taskRepository.findAll().stream()
                .map(TaskWithChangesDto::new)
                .collect(toList());
    }

    public Optional<TaskDto> get(int id) {
        return taskRepository.findById(id).map(TaskDto::new);
    }

    public void delete(int id) {
        taskRepository.deleteById(id);
    }
}
