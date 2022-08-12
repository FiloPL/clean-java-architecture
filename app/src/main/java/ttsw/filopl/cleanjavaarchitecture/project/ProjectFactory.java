package ttsw.filopl.cleanjavaarchitecture.project;

import ttsw.filopl.cleanjavaarchitecture.project.dto.ProjectDto;

import java.util.stream.Collectors;

/**
 * Created by T. Filo Zegarlicki on 02.08.2022
 **/

class ProjectFactory {
    Project from(ProjectDto source) {
        return Project.restore(new ProjectSnapshot(
                source.getId(),
                source.getName(),
                source.getSteps().stream()
                        .map(stepDto -> new ProjectStepSnapshot(
                                        stepDto.getId(),
                                        stepDto.getDescription(),
                                        stepDto.getDaysToProjectDeadline(),
                                        false,
                                        false
                                )
                        ).collect(Collectors.toSet())
        ));
    }
}
