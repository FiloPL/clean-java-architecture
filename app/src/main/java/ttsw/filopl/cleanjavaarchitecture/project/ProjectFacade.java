package ttsw.filopl.cleanjavaarchitecture.project;

import ttsw.filopl.cleanjavaarchitecture.project.dto.ProjectDto;
import ttsw.filopl.cleanjavaarchitecture.project.dto.ProjectStepDto;
import ttsw.filopl.cleanjavaarchitecture.task.TaskFacade;
import ttsw.filopl.cleanjavaarchitecture.task.TaskQueryRepository;
import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskDto;
import ttsw.filopl.cleanjavaarchitecture.task.vo.TaskCreator;
import ttsw.filopl.cleanjavaarchitecture.task.vo.TaskEvent;
import ttsw.filopl.cleanjavaarchitecture.task.vo.TaskSourceId;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;


/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

public class ProjectFacade {
    private final ProjectFactory projectFactory;
    private final ProjectRepository projectRepository;
    private final TaskFacade taskFacade;

    ProjectFacade(final ProjectFactory projectFactory, final ProjectRepository projectRepository, final TaskFacade taskFacade) {
        this.projectFactory = projectFactory;
        this.projectRepository = projectRepository;
        this.taskFacade = taskFacade;
    }

    public void handle(TaskEvent event) {
        event.getSourceId()
                .map(TaskSourceId::getId)
                .map(Integer::parseInt)
                .ifPresent(stepId -> {
                            switch (event.getState()) {
                                case DONE:
                                case DELETED:
                                    updateStep(stepId, true);
                                    break;
                                case UNDONE:
                                    updateStep(stepId, false);
                                    break;
                                case UPDATED:
                                default:
                                    break;
                            }
                        }
                );
    }

    void updateStep(int stepId, boolean done) {
        projectRepository.findByNestedStepId(stepId)
                .ifPresent(project -> {
                    project.updateStep(stepId, done);
                    projectRepository.save(project);
                });
    }

    public ProjectDto save(ProjectDto dtoToSave) {
        if (dtoToSave.getId() != 0) {
            return toDto(saveWithId(dtoToSave));
        }
        if (dtoToSave.getSteps().stream().anyMatch(step -> step.getId() != 0)) {
            throw new IllegalStateException("Cannot add project with existing steps");
        }
        return toDto(projectRepository.save(projectFactory.from(dtoToSave)));
    }

    private Project saveWithId(ProjectDto dtoToSave) {
        return projectRepository.findById(dtoToSave.getId()).map(existingProject -> {
            Project toSave = projectFactory.from(dtoToSave);
            Set<Project.Step> removedSteps = existingProject.modifySteps(toSave.getSnapshot().getSteps());
            projectRepository.save(existingProject);
            removedSteps.forEach(projectRepository::delete);
            return existingProject;
        }).orElseGet(() -> projectRepository.save(projectFactory.from(dtoToSave)));
    }

    List<TaskDto> createTasks(int projectId, ZonedDateTime projectDeadline) {
        return projectRepository.findById(projectId).map(project -> {
            Set<TaskCreator> taskSources = project.convertToTasks(projectDeadline);
            projectRepository.save(project);
            return taskFacade.createTasks(taskSources);
        }).orElseThrow(() -> new IllegalArgumentException("No project found with id: " + projectId));
    }

    private ProjectDto toDto(Project project) {
        var snap = project.getSnapshot();
        return ProjectDto.create(snap.getId(), snap.getName(), snap.getSteps().stream().map(this::toDto).collect(toList()));
    }

    private ProjectStepDto toDto(ProjectStepSnapshot step) {
        return ProjectStepDto.create(step.getId(), step.getDescription(), step.getDaysToProjectDeadline());
    }
}