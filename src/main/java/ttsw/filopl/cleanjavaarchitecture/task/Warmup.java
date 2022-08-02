package ttsw.filopl.cleanjavaarchitecture.task;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
/**
 * Created by T. Filo Zegarlicki on 29.07.2022
 **/

@Component("taskWarmup")
class Warmup implements ApplicationListener<ContextRefreshedEvent> {
    private final TaskRepository taskRepository;
    private final TaskQueryRepository taskQueryRepository;

    Warmup(final TaskRepository taskRepository, final TaskQueryRepository taskQueryRepository) {
        this.taskRepository = taskRepository;
        this.taskQueryRepository = taskQueryRepository;
    }

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (taskQueryRepository.count() == 0) {
            var task = new Task("Example task", ZonedDateTime.now(), null);
            taskRepository.save(task);
        }
    }
}
