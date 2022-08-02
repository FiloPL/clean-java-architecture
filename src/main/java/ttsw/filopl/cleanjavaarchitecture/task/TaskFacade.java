package ttsw.filopl.cleanjavaarchitecture.task;

import org.springframework.stereotype.Service;
import ttsw.filopl.cleanjavaarchitecture.project.dto.SimpleProjectQueryEntity;
import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskDto;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

@Service
public class TaskFacade {
    private final TaskFactory taskFactory;
    private final TaskRepository taskRepository;

    TaskFacade(final TaskFactory taskFactory, final TaskRepository taskRepository) {
        this.taskFactory = taskFactory;
        this.taskRepository = taskRepository;
    }

    public List<TaskDto> saveAll(Collection<TaskDto> tasks, SimpleProjectQueryEntity project) {
        return taskRepository.saveAll(
                        tasks.stream()
                                .map(dto -> taskFactory.from(dto, project))
                                .collect(toList())
                ).stream().map(Task::toDto)
                .collect(toList());
    }

    TaskDto save(TaskDto toSave) {
        return taskRepository.save(
                taskRepository.findById(toSave.getId()).map(existingTask -> {
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
        ).toDto();
    }

    void delete(int id) {
        taskRepository.deleteById(id);
    }
}