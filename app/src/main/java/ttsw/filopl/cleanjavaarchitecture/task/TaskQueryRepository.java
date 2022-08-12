package ttsw.filopl.cleanjavaarchitecture.task;

import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskDto;

import java.util.Optional;
import java.util.Set;

/**
 * Created by T. Filo Zegarlicki on 01.08.2022
 **/

public interface TaskQueryRepository {
    int count();

    Optional<TaskDto> findDtoById(Integer id);

    <T> Set<T> findBy(Class<T> type);
}
