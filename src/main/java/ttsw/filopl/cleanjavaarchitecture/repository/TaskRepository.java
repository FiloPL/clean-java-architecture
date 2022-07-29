package ttsw.filopl.cleanjavaarchitecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ttsw.filopl.cleanjavaarchitecture.entity.Task;

import java.util.List;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByProject_Id(int id);
}
