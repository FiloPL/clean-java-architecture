package ttsw.filopl.cleanjavaarchitecture.task;

import org.springframework.data.repository.Repository;
import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskDto;
import ttsw.filopl.cleanjavaarchitecture.task.dto.TaskWithChangesQueryDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by T. Filo Zegarlicki on 01.08.2022
 **/

public interface TaskQueryRepository extends Repository<Task, Integer> {
    int count();

    Optional<TaskDto> findDtoById(Integer id);

    boolean existsByDoneIsFalseAndProject_Id(int id);

    List<TaskWithChangesQueryDto> findAllWithChangesBy();

    List<TaskDto> findAllBy();

    <T> Set<T> findBy(Class<T> type);
}

