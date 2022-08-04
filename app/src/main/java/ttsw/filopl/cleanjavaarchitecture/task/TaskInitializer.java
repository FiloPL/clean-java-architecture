package ttsw.filopl.cleanjavaarchitecture.task;

import java.time.ZonedDateTime;
/**
 * Created by T. Filo Zegarlicki on 29.07.2022
 **/

class TaskInitializer {
    private final TaskRepository taskRepository;
    private final TaskQueryRepository taskQueryRepository;

    TaskInitializer(final TaskRepository taskRepository, final TaskQueryRepository taskQueryRepository) {
        this.taskRepository = taskRepository;
        this.taskQueryRepository = taskQueryRepository;
    }

    void init() {
        if (taskQueryRepository.count() == 0) {
            var task = new Task("Example task", ZonedDateTime.now(), null);
            taskRepository.save(task);
        }
    }
}
