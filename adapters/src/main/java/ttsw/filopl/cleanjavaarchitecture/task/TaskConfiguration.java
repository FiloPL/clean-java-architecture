package ttsw.filopl.cleanjavaarchitecture.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ttsw.filopl.cleanjavaarchitecture.DomainEventPublisher;

/**
 * Created by T. Filo Zegarlicki on 04.08.2022
 **/

@Configuration
class TaskConfiguration {
    @Bean
    TaskFacade taskFacade(final TaskRepository taskRepository, final DomainEventPublisher publisher) {
        return new TaskFacade(new TaskFactory(), taskRepository, publisher);
    }
}