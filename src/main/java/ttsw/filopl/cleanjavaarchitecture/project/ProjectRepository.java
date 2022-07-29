package ttsw.filopl.cleanjavaarchitecture.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by T. Filo Zegarlicki on 29.07.2022
 **/

interface ProjectRepository extends JpaRepository<Project, Integer> {
    <S extends Project> S save(S entity);

    Optional<Project> findById(Integer id);

    List<Project> findAll();

    long count();
}
