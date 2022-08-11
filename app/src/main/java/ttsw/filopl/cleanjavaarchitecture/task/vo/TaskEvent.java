package ttsw.filopl.cleanjavaarchitecture.task.vo;

import ttsw.filopl.cleanjavaarchitecture.task.DomainEvent;

import java.time.Instant;

/**
 * Created by T. Filo Zegarlicki on 11.08.2022
 **/

public class TaskEvent implements DomainEvent {

    @Override
    public Instant getOccurredOn() {
        return null;
    }
}
