package ttsw.filopl.cleanjavaarchitecture.task.vo;

/**
 * Created by T. Filo Zegarlicki on 11.08.2022
 **/

public class TaskSourceId {

    private String id;

    protected TaskSourceId() {
    }

    public TaskSourceId(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
