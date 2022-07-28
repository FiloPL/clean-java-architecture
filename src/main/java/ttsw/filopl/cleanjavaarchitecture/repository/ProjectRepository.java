package ttsw.filopl.cleanjavaarchitecture.repository;

import ttsw.filopl.cleanjavaarchitecture.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
