package ttsw.filopl.cleanjavaarchitecture.task.dto;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

public interface TaskWithChangesQueryDto {
    int getId();

    @NotNull
    String getDescription();

    boolean isDone();

    ZonedDateTime getDeadline();

    int getChangesCount();
}
