package ttsw.filopl.cleanjavaarchitecture.task;

import org.springframework.stereotype.Service;
import ttsw.filopl.cleanjavaarchitecture.project.dto.SimpleProjectQueryEntity;
import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskDto;

/**
 * Created by T. Filo Zegarlicki on 01.08.2022
 **/

@Service
class TaskFactory {
    Task from(final TaskDto source, final SimpleProjectQueryEntity project) {
        var result = new Task(source.getDescription(), source.getDeadline(), project);
        result.setId(source.getId());
        result.setAdditionalComment(source.getAdditionalComment());
        result.setDone(source.isDone());
        return result;
    }
}
