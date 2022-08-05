package ttsw.filopl.cleanjavaarchitecture.task;

import ttsw.filopl.cleanjavaarchitecture.project.SqlSimpleProject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by T. Filo Zegarlicki on 05.08.2022
 **/

@Entity
@Table(name = "tasks")
class SqlTask {
    static SqlTask fromTask(Task source) {
        var result = new SqlTask();
        result.id = source.getId();
        result.description = source.getDescription();
        result.done = source.isDone();
        result.deadline = source.getDeadline();
        result.changesCount = source.getChangesCount();
        result.additionalComment = source.getAdditionalComment();
        result.project = source.getProject() == null ? null : SqlSimpleProject.fromProject(source.getProject());
        return result;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;
    @NotNull
    private String description;
    private boolean done;
    private ZonedDateTime deadline;
    private int changesCount;
    private String additionalComment;
    @ManyToOne
    @JoinColumn(name = "source_id")
    private SqlSimpleProject project;

    public SqlTask() {
    }

    Task toTask() {
        var result = new Task(description, deadline, project == null ? null : project.toProject());
        result.setId(id);
        result.setDone(done);
        result.setChangesCount(changesCount);
        result.setAdditionalComment(additionalComment);
        return result;
    }
}

