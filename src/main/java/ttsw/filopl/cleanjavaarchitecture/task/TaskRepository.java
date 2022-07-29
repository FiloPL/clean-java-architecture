package ttsw.filopl.cleanjavaarchitecture.task;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by T. Filo Zegarlicki on 29.07.2022
 **/

public interface TaskRepository extends Repository<Task, Integer> {

    int count();

    Optional<Task> findById(Integer id);

    List<Task> findAllByProject_Id(int id);

    List<Task> findAll();

    <S extends Task> S save(S entity);

    <S extends Task> List<S> saveAll(Iterable<S> entities);

    void deleteById(Integer id);
}