package ttsw.filopl.cleanjavaarchitecture.task;

/**
 * Created by T. Filo Zegarlicki on 11.08.2022
 **/

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}

