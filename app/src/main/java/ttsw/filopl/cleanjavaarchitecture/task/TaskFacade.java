package ttsw.filopl.cleanjavaarchitecture.task;

import ttsw.filopl.cleanjavaarchitecture.project.dto.SimpleProject;
import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskDto;

import java.util.Collection;
import java.util.List;

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

    public List<TaskDto> saveAll(Collection<TaskDto> tasks, SimpleProject project) {
        return taskRepository.saveAll(
                        tasks.stream().map(dto -> taskFactory.from(dto, project))
                                .toList()
                ).stream().map(this::toDto)
                .toList();
    }

    TaskDto save(TaskDto toSave) {
        return toDto(taskRepository.save(
                taskRepository.findById(toSave.getId()).map(existingTask -> {
                    if (existingTask.getSnapshot().getDone() != toSave.isDone()) {
                        existingTask.toggle();
                    }
                    existingTask.updateInfo(
                            toSave.getDescription(),
                            toSave.getDeadline(),
                            toSave.getAdditionalComment()
                    );
                    return existingTask;
                }).orElseGet(() -> taskFactory.from(toSave, null))
        ));
    }

    void delete(int id) {
        taskRepository.deleteById(id);
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