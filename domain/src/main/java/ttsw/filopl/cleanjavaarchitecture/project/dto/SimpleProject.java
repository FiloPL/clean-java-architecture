package ttsw.filopl.cleanjavaarchitecture.project.dto;

/**
 * Created by T. Filo Zegarlicki on 05.08.2022
 **/

public class SimpleProject {
    public static SimpleProject restore(final SimpleProjectSnapshot snapshot) {
        return new SimpleProject(snapshot.getId(), snapshot.getName());
    }

    private final int id;
    private final String name;

    private SimpleProject(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    public SimpleProjectSnapshot getSnapshot() {
        return new SimpleProjectSnapshot(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
