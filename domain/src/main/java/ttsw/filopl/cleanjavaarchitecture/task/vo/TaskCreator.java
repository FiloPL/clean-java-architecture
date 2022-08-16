package ttsw.filopl.cleanjavaarchitecture.task.vo;

import java.time.ZonedDateTime;

/**
 * Created by T. Filo Zegarlicki on 11.08.2022
 **/

public class TaskCreator {
    private final TaskSourceId id;
    private final String description;
    private final ZonedDateTime deadline;

    public TaskCreator(final TaskSourceId id, final String description, final ZonedDateTime deadline) {
        this.id = id;
        this.description = description;
        this.deadline = deadline;
    }

    public TaskSourceId getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public ZonedDateTime getDeadline() {
        return deadline;
    }
}