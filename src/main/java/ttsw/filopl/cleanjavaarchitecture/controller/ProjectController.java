package ttsw.filopl.cleanjavaarchitecture.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttsw.filopl.cleanjavaarchitecture.dto.ProjectDeadlineDto;
import ttsw.filopl.cleanjavaarchitecture.dto.TaskDto;
import ttsw.filopl.cleanjavaarchitecture.entity.Project;
import ttsw.filopl.cleanjavaarchitecture.service.ProjectService;

import java.net.URI;
import java.util.List;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> get(@PathVariable int id) {
        return projectService.get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> update(@PathVariable int id, @RequestBody Project toUpdate) {
        if (id != toUpdate.getId() && toUpdate.getId() != 0) {
            throw new IllegalStateException("Id in URL is different than in body: " + id + " and " + toUpdate.getId());
        }
        toUpdate.setId(id);
        projectService.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Project> create(@RequestBody Project toCreate) {
        Project result = projectService.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @PostMapping("/{id}/tasks")
    public List<TaskDto> createTasks(@PathVariable int id, @RequestBody ProjectDeadlineDto deadlineDto) {
        return projectService.createTasks(id, deadlineDto.getDeadline());
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleClientError(IllegalStateException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
