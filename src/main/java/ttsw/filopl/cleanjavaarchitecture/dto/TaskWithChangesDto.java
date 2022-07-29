package ttsw.filopl.cleanjavaarchitecture.dto;

import ttsw.filopl.cleanjavaarchitecture.entity.Task;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

public class TaskWithChangesDto {

    private int id;
    @NotNull
    private String description;
    private boolean done;
    private ZonedDateTime deadline;
    private int changesCount;

    public TaskWithChangesDto(Task source) {
        id = source.getId();
        description = source.getDescription();
        done = source.isDone();
        deadline = source.getDeadline();
        changesCount = source.getChangesCount();
    }

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    void setDone(boolean done) {
        this.done = done;
    }

    public ZonedDateTime getDeadline() {
        return deadline;
    }

    void setDeadline(ZonedDateTime deadline) {
        this.deadline = deadline;
    }

    public int getChangesCount() {
        return changesCount;
    }

    void setChangesCount(int changesCount) {
        this.changesCount = changesCount;
    }
}
