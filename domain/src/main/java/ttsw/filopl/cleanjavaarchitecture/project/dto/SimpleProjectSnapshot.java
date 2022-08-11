package ttsw.filopl.cleanjavaarchitecture.project.dto;

/**
 * Created by T. Filo Zegarlicki on 10.08.2022
 **/

public class SimpleProjectSnapshot {
    private int id;
    private String name;

    public SimpleProjectSnapshot() {
    }

    public SimpleProjectSnapshot(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
