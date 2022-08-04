package ttsw.filopl.cleanjavaarchitecture.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by T. Filo Zegarlicki on 04.08.2022
 **/

@Configuration
class TaskConfiguration {

    @Bean
    TaskFacade taskFacade(TaskRepository taskRepository) {
        return new TaskFacade(new TaskFactory(), taskRepository);
    }
}
