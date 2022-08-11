package ttsw.filopl.cleanjavaarchitecture.project;

/**
 * Created by T. Filo Zegarlicki on 10.08.2022
 **/

class ProjectStepSnapshot {
    private int id;
    private String description;
    private int daysToProjectDeadline;

    public ProjectStepSnapshot() {
    }

    ProjectStepSnapshot(final int id, final String description, final int daysToProjectDeadline) {
        this.id = id;
        this.description = description;
        this.daysToProjectDeadline = daysToProjectDeadline;
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
}

