package ttsw.filopl.cleanjavaarchitecture.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ttsw.filopl.cleanjavaarchitecture.project.Project;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

@Entity
@Table(name = "project_steps")
class ProjectStep {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @NotNull
    private String description;
    private int daysToProjectDeadline;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    //@PersistenceConstructor
    public ProjectStep() {
    }

    ProjectStep(@NotNull String description, int daysToProjectDeadline, Project project) {
        this.description = description;
        this.daysToProjectDeadline = daysToProjectDeadline;
        this.project = project;
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

    public int getDaysToProjectDeadline() {
        return daysToProjectDeadline;
    }

    void setDaysToProjectDeadline(int daysToProjectDeadline) {
        this.daysToProjectDeadline = daysToProjectDeadline;
    }

    public Project getProject() {
        return project;
    }

    void setProject(Project project) {
        this.project = project;
    }
}