package ttsw.filopl.cleanjavaarchitecture;

import java.time.Instant;

/**
 * Created by T. Filo Zegarlicki on 11.08.2022
 **/

public interface DomainEvent {
    Instant getOccurredOn();
}
