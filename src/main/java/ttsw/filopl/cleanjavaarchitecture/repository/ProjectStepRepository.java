package ttsw.filopl.cleanjavaarchitecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ttsw.filopl.cleanjavaarchitecture.entity.ProjectStep;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

public interface ProjectStepRepository extends JpaRepository<ProjectStep, Integer> {
}
