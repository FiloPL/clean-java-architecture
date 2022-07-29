package ttsw.filopl.cleanjavaarchitecture.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttsw.filopl.cleanjavaarchitecture.dto.TaskDto;
import ttsw.filopl.cleanjavaarchitecture.dto.TaskWithChangesDto;
import ttsw.filopl.cleanjavaarchitecture.service.TaskService;

import java.net.URI;
import java.util.List;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDto> list() {
        return taskService.list();
    }

    @GetMapping(params = "changes")
    public List<TaskWithChangesDto> listWithChanges() {
        return taskService.listWithChanges();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> get(@PathVariable int id) {
        return taskService.get(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> update(@PathVariable int id, @RequestBody TaskDto toUpdate) {
        if (id != toUpdate.getId() && toUpdate.getId() != 0) {
            throw new IllegalStateException("Id in URL is different than in body: " + id + " and " + toUpdate.getId());
        }
        toUpdate.setId(id);
        taskService.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<TaskDto> create(@RequestBody TaskDto toCreate) {
        TaskDto result = taskService.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDto> delete(@PathVariable int id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}