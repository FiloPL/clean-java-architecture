package ttsw.filopl.cleanjavaarchitecture.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

@Entity
@Table(name = "project_steps")
public class ProjectStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String description;
    private int daysToProjectDeadline;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @PersistenceConstructor
    public ProjectStep() {
    }

    public ProjectStep(String description, int daysToProjectDeadline, Project project) {
        this.description = description;
        this.daysToProjectDeadline = daysToProjectDeadline;
        this.project = project;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDaysToProjectDeadline() {
        return daysToProjectDeadline;
    }

    public void setDaysToProjectDeadline(int daysToProjectDeadline) {
        this.daysToProjectDeadline = daysToProjectDeadline;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}