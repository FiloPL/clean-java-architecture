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

    Warmup(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (taskRepository.count() == 0) {
            var task = new Task("Example task", ZonedDateTime.now(), null);
            taskRepository.save(task);
        }
    }
}
