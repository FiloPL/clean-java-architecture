package ttsw.filopl.cleanjavaarchitecture.project;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by T. Filo Zegarlicki on 04.08.2022
 **/

@Component
public class ProjectWarmup implements ApplicationListener<ContextRefreshedEvent> {

    private final ProjectInitializer initializer;

    ProjectWarmup(final ProjectRepository projectRepository, final ProjectQueryRepository projectQueryRepository) {
        this.initializer = new ProjectInitializer(projectRepository, projectQueryRepository);
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        initializer.init();
    }
}
