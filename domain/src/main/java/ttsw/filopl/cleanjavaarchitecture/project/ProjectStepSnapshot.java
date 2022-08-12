package ttsw.filopl.cleanjavaarchitecture.project;

/**
 * Created by T. Filo Zegarlicki on 10.08.2022
 **/

class ProjectStepSnapshot {
    private int id;
    private String description;
    private int daysToProjectDeadline;
    private boolean hasCorrespondingTask;
    private boolean correspondingTaskDone;

    public ProjectStepSnapshot() {
    }

    ProjectStepSnapshot(final int id, final String description, final int daysToProjectDeadline) {
        this(id, description, daysToProjectDeadline, false, false);
    }

    ProjectStepSnapshot(final int id, final String description, final int daysToProjectDeadline, final boolean hasCorrespondingTask, final boolean correspondingTaskDone) {
        this.id = id;
        this.description = description;
        this.daysToProjectDeadline = daysToProjectDeadline;
        this.hasCorrespondingTask = hasCorrespondingTask;
        this.correspondingTaskDone = correspondingTaskDone;
    }

    int getId() {
        return this.id;
    }

    String getDescription() {
        return this.description;
    }

    int getDaysToProjectDeadline() {
        return this.daysToProjectDeadline;
    }

    boolean hasCorrespondingTask() {
        return hasCorrespondingTask;
    }

    boolean isCorrespondingTaskDone() {
        return correspondingTaskDone;
    }
}

