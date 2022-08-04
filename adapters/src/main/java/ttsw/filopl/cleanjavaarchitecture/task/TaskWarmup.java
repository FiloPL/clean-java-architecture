package ttsw.filopl.cleanjavaarchitecture.task;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by T. Filo Zegarlicki on 04.08.2022
 **/

@Component
class TaskWarmup implements ApplicationListener<ContextRefreshedEvent> {
    private final TaskInitializer initializer;

    TaskWarmup(final TaskRepository taskRepository, final TaskQueryRepository taskQueryRepository) {
        this.initializer = new TaskInitializer(taskRepository, taskQueryRepository);
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        initializer.init();
    }
}
