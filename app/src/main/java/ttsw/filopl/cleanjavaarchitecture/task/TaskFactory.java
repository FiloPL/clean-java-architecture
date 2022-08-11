package ttsw.filopl.cleanjavaarchitecture.task;

import ttsw.filopl.cleanjavaarchitecture.project.dto.SimpleProject;
import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskDto;

/**
 * Created by T. Filo Zegarlicki on 01.08.2022
 **/

class TaskFactory {
    Task from(final TaskDto source, final SimpleProject project) {
        return Task.restore(new TaskSnapshot(
                source.getId(),
                source.getDescription(),
                source.isDone(),
                source.getDeadline(),
                0,
                source.getAdditionalComment(),
                project != null ? project.getSnapshot() : null
        ));
    }
}
