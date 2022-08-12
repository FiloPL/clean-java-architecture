package ttsw.filopl.cleanjavaarchitecture;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * Created by T. Filo Zegarlicki on 11.08.2022
 **/

@Service
public class SpringDomainEventPublisher implements DomainEventPublisher {

    private final ApplicationEventPublisher innerPublisher;

    public SpringDomainEventPublisher(final ApplicationEventPublisher innerPublisher) {
        this.innerPublisher = innerPublisher;
    }

    @Override
    public void publish(final DomainEvent event) {
        innerPublisher.publishEvent(event);
    }
}
