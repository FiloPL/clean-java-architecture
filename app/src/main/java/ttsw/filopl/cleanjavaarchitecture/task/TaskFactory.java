package ttsw.filopl.cleanjavaarchitecture.task;

import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskDto;

/**
 * Created by T. Filo Zegarlicki on 01.08.2022
 **/

class TaskFactory {
    Task from(final TaskDto source) {
        return Task.restore(new TaskSnapshot(
                source.getId(),
                source.getDescription(),
                source.isDone(),
                source.getDeadline(),
                0,
                source.getAdditionalComment(),
                null
        ));
    }
}
