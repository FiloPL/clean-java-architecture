package ttsw.filopl.cleanjavaarchitecture.project;

import org.springframework.stereotype.Service;
import ttsw.filopl.cleanjavaarchitecture.project.dto.ProjectDto;

/**
 * Created by T. Filo Zegarlicki on 02.08.2022
 **/

@Service
class ProjectFactory {
    Project from(ProjectDto source) {
        var result = new Project();
        result.setId(source.getId());
        result.setName(source.getName());
        source.getSteps().forEach(stepSource -> {
            var step = new ProjectStep(stepSource.getDescription(), stepSource.getDaysToProjectDeadline(), result);
            step.setId(stepSource.getId());
            result.addStep(step);
        });
        return result;
    }
}
