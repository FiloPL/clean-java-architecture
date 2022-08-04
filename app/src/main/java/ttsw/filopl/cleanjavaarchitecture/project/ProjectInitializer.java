package ttsw.filopl.cleanjavaarchitecture.project;

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
            var project = new Project();
            project.setName("Example project");
            project.addStep(new ProjectStep("First", -3, project));
            project.addStep(new ProjectStep("Second", -2, project));
            project.addStep(new ProjectStep("Third", 0, project));
            projectRepository.save(project);
        }
    }
}
