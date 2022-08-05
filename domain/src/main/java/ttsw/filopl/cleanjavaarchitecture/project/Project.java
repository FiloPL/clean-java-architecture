package ttsw.filopl.cleanjavaarchitecture.project;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

class Project {
    private int id;
    private String name;
    private final Set<ProjectStep> steps = new HashSet<>();

    public int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public Set<ProjectStep> getSteps() {
        return steps;
    }

    void addStep(ProjectStep step) {
        if (steps.contains(step)) {
            return;
        }
        steps.add(step);
        step.setProject(this);
    }

    void removeStep(ProjectStep step) {
        if (!steps.contains(step)) {
            return;
        }
        steps.remove(step);
        step.setProject(null);
    }
}
