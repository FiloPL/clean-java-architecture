package ttsw.filopl.cleanjavaarchitecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import ttsw.filopl.cleanjavaarchitecture.entity.Project;
import ttsw.filopl.cleanjavaarchitecture.entity.ProjectStep;
import ttsw.filopl.cleanjavaarchitecture.entity.Task;
import ttsw.filopl.cleanjavaarchitecture.repository.ProjectRepository;
import ttsw.filopl.cleanjavaarchitecture.repository.TaskRepository;

import java.time.ZonedDateTime;

@SpringBootApplication
public class CleanJavaArchitectureApplication implements ApplicationListener<ContextRefreshedEvent> {

    public static void main(String[] args) {
        SpringApplication.run(CleanJavaArchitectureApplication.class, args);
    }

    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public CleanJavaArchitectureApplication(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (projectRepository.count() == 0) {
            var project = new Project();
            project.setName("Example project");
            project.addStep(new ProjectStep("First", -3, project));
            project.addStep(new ProjectStep("Second", -2, project));
            project.addStep(new ProjectStep("Third", 0, project));
            projectRepository.save(project);
        }
        if (taskRepository.count() == 0) {
            var task = new Task("Example task", ZonedDateTime.now(), null);
            taskRepository.save(task);
        }
    }
}
