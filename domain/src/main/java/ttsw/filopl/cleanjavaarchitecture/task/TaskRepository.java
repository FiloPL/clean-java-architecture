package ttsw.filopl.cleanjavaarchitecture.task;

import java.util.List;
import java.util.Optional;

/**
 * Created by T. Filo Zegarlicki on 29.07.2022
 **/

interface TaskRepository {
    Optional<Task> findById(Integer id);

    Task save(Task entity);

    List<Task> saveAll(Iterable<Task> entities);

    void deleteById(Integer id);
}