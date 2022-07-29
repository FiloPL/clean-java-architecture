package ttsw.filopl.cleanjavaarchitecture.dto;

import ttsw.filopl.cleanjavaarchitecture.entity.Task;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

public class TaskDto {

    private int id;
    @NotNull
    private String description;
    private boolean done;
    private ZonedDateTime deadline;
    private String additionalComment;

    public TaskDto() {
    }

    public TaskDto(Task source) {
        id = source.getId();
        description = source.getDescription();
        done = source.isDone();
        deadline = source.getDeadline();
        additionalComment = source.getAdditionalComment();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAdditionalComment() {
        return additionalComment;
    }

    void setAdditionalComment(String additionalComment) {
        this.additionalComment = additionalComment;
    }
}
