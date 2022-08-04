package ttsw.filopl.cleanjavaarchitecture.task;

import ttsw.filopl.cleanjavaarchitecture.project.dto.SimpleProjectQueryEntity;
import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskDto;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

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
                ).stream().map(this::toDto)
                .collect(toList());
    }

    TaskDto save(TaskDto toSave) {
        return toDto(taskRepository.save(
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
        ));
    }

    void delete(int id) {
        taskRepository.deleteById(id);
    }

    private TaskDto toDto(Task task) {
        return TaskDto.builder()
                .withId(task.getId())
                .withDescription(task.getDescription())
                .withDone(task.isDone())
                .withDeadline(task.getDeadline())
                .withAdditionalComment(task.getAdditionalComment())
                .build();
    }
}