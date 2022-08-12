package ttsw.filopl.cleanjavaarchitecture.task;

import ttsw.filopl.cleanjavaarchitecture.task.vo.TaskSourceId;

import java.time.ZonedDateTime;

/**
 * Created by T. Filo Zegarlicki on 10.08.2022
 **/

class TaskSnapshot {
    private int id;
    private String description;
    private boolean done;
    private ZonedDateTime deadline;
    private int changesCount;
    private String additionalComment;
    private TaskSourceId sourceId;

    protected TaskSnapshot() {
    }

    TaskSnapshot(
            final int id, String description,
            final boolean done,
            final ZonedDateTime deadline,
            final int changesCount,
            final String additionalComment,
            final TaskSourceId sourceId
    ) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.deadline = deadline;
        this.changesCount = changesCount;
        this.additionalComment = additionalComment;
        this.sourceId = sourceId;
    }

    int getId() {
        return this.id;
    }

    String getDescription() {
        return this.description;
    }

    boolean getDone() {
        return this.done;
    }

    ZonedDateTime getDeadline() {
        return this.deadline;
    }

    int getChangesCount() {
        return this.changesCount;
    }

    String getAdditionalComment() {
        return this.additionalComment;
    }

    TaskSourceId getSourceId() {
        return sourceId;
    }
}