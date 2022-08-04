package ttsw.filopl.cleanjavaarchitecture.project;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by T. Filo Zegarlicki on 29.07.2022
 **/

@Component("projectWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {

    private final ProjectRepository projectRepository;
    private final ProjectQueryRepository projectQueryRepository;

    Warmup(final ProjectRepository projectRepository, final ProjectQueryRepository projectQueryRepository) {
        this.projectRepository = projectRepository;
        this.projectQueryRepository = projectQueryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (projectQueryRepository.count() == 0) {
            var project = new Project();
            project.setName("Example project");
            project.addStep(new ProjectStep("First", -3, project));
            project.addStep(new ProjectStep("Second", -2, project));
            project.addStep(new ProjectStep("Third", 0, project));
            projectRepository.save(project);
        }
    }
}