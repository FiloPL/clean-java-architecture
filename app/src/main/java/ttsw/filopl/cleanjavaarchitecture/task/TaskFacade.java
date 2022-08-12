package ttsw.filopl.cleanjavaarchitecture.task;

import ttsw.filopl.cleanjavaarchitecture.DomainEventPublisher;
import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskDto;
import ttsw.filopl.cleanjavaarchitecture.task.vo.TaskCreator;
import ttsw.filopl.cleanjavaarchitecture.task.vo.TaskEvent;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

public class TaskFacade {
    private final TaskFactory taskFactory;
    private final TaskRepository taskRepository;
    private final DomainEventPublisher publisher;

    TaskFacade(final TaskFactory taskFactory, final TaskRepository taskRepository, final DomainEventPublisher publisher) {
        this.taskFactory = taskFactory;
        this.taskRepository = taskRepository;
        this.publisher = publisher;
    }

    public List<TaskDto> createTasks(Collection<TaskCreator> sources) {
        return taskRepository.saveAll(sources.stream()
                        .map(Task::createFrom)
                        .collect(toList())
                ).stream().map(this::toDto)
                .collect(toList());
    }

    TaskDto save(TaskDto toSave) {
        return toDto(taskRepository.save(
                taskRepository.findById(toSave.getId()).map(existingTask -> {
                    if (existingTask.getSnapshot().getDone() != toSave.isDone()) {
                        publisher.publish(existingTask.toggle());
                    }
                    publisher.publish(existingTask.updateInfo(
                            toSave.getDescription(),
                            toSave.getDeadline(),
                            toSave.getAdditionalComment()
                    ));
                    return existingTask;
                }).orElseGet(() -> taskFactory.from(toSave))
        ));
    }

    void delete(int id) {
        taskRepository.findById(id)
                .ifPresent(task -> {
                    taskRepository.deleteById(id);
                    publisher.publish(new TaskEvent(
                            task.getSnapshot().getSourceId(),
                            TaskEvent.State.DELETED,
                            null
                    ));
                });
    }

    private TaskDto toDto(Task task) {
        var snap = task.getSnapshot();
        return TaskDto.builder()
                .withId(snap.getId())
                .withDescription(snap.getDescription())
                .withDone(snap.getDone())
                .withDeadline(snap.getDeadline())
                .withAdditionalComment(snap.getAdditionalComment())
                .build();
    }
}