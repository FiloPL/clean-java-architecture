package ttsw.filopl.cleanjavaarchitecture.project;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by T. Filo Zegarlicki on 05.08.2022
 **/

@Entity
@Table(name = "project_steps")
class SqlProjectStep {
    static SqlProjectStep fromStep(ProjectStep source, SqlProject mappedProject) {
        var result = new SqlProjectStep();
        result.id = source.getId();
        result.description = source.getDescription();
        result.daysToProjectDeadline = source.getDaysToProjectDeadline();
        result.project = mappedProject;
        return result;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @NotNull
    private String description;
    private int daysToProjectDeadline;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private SqlProject project;

    ProjectStep toStep(Project originalProject) {
        var result = new ProjectStep(description, daysToProjectDeadline, originalProject);
        result.setId(id);
        return result;
    }
}
