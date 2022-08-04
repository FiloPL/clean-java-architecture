package ttsw.filopl.cleanjavaarchitecture.task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskDto;
import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskWithChangesQueryDto;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

@RestController
@RequestMapping("/tasks")
class TaskController {
    private final TaskFacade taskFacade;
    private final TaskQueryRepository taskQueryRepository;

    TaskController(final TaskFacade taskFacade, final TaskQueryRepository taskQueryRepository) {
        this.taskFacade = taskFacade;
        this.taskQueryRepository = taskQueryRepository;
    }

    @GetMapping
    List<TaskDto> list() {
        return new ArrayList<>(taskQueryRepository.findBy(TaskDto.class));
    }

    @GetMapping(params = "changes")
    List<TaskWithChangesQueryDto> listWithChanges() {
        return new ArrayList<>(taskQueryRepository.findBy(TaskWithChangesQueryDto.class));
    }

    @GetMapping("/{id}")
    ResponseEntity<TaskDto> get(@PathVariable int id) {
        return taskQueryRepository.findDtoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    ResponseEntity<TaskDto> update(@PathVariable int id, @RequestBody TaskDto toUpdate) {
        if (id != toUpdate.getId() && toUpdate.getId() != 0) {
            throw new IllegalStateException("Id in URL is different than in body: " + id + " and " + toUpdate.getId());
        }
        taskFacade.save(toUpdate.withId(id));
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    ResponseEntity<TaskDto> create(@RequestBody TaskDto toCreate) {
        TaskDto result = taskFacade.save(toCreate);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<TaskDto> delete(@PathVariable int id) {
        taskFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}