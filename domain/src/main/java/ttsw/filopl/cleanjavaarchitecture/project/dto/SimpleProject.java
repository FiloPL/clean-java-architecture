package ttsw.filopl.cleanjavaarchitecture.project.dto;

/**
 * Created by T. Filo Zegarlicki on 05.08.2022
 **/

public class SimpleProject {
    private final int id;
    private final String name;

    public SimpleProject(int id, String name) {
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
