package ttsw.filopl.cleanjavaarchitecture.project;

import java.util.Set;

/**
 * Created by T. Filo Zegarlicki on 29.07.2022
 **/

class ProjectInitializer {
    private final ProjectRepository projectRepository;
    private final ProjectQueryRepository projectQueryRepository;

    ProjectInitializer(final ProjectRepository projectRepository, final ProjectQueryRepository projectQueryRepository) {
        this.projectRepository = projectRepository;
        this.projectQueryRepository = projectQueryRepository;
    }

    void init() {
        if (projectQueryRepository.count() == 0) {
            projectRepository.save(Project.restore(new ProjectSnapshot(
                    0,
                    "ExampleProject",
                    Set.of(
                            new ProjectStepSnapshot(0, "First", -3),
                            new ProjectStepSnapshot(0, "Second", -2),
                            new ProjectStepSnapshot(0, "Third", 0)
                    )
            )));
        }
    }
}
