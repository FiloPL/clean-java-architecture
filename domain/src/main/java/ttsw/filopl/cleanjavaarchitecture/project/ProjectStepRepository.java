package ttsw.filopl.cleanjavaarchitecture.project;

import org.springframework.data.repository.Repository;

/**
 * Created by T. Filo Zegarlicki on 29.07.2022
 **/

interface ProjectStepRepository extends Repository<ProjectStep, Integer> {
    void delete(ProjectStep entity);
}
