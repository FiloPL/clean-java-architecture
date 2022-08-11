package ttsw.filopl.cleanjavaarchitecture.project;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ttsw.filopl.cleanjavaarchitecture.task.TaskFacade;
import ttsw.filopl.cleanjavaarchitecture.task.TaskQueryRepository;

/**
 * Created by T. Filo Zegarlicki on 04.08.2022
 **/

@Configuration
class ProjectConfiguration {
    @Bean
    ProjectFacade projectFacade(
            ProjectRepository projectRepository,
            TaskFacade taskFacade,
            TaskQueryRepository taskQueryRepository
    ) {
        return new ProjectFacade(
                new ProjectFactory(),
                projectRepository,
                taskFacade,
                taskQueryRepository
        );
    }
}