package ttsw.filopl.cleanjavaarchitecture.project;

import java.util.Optional;

/**
 * Created by T. Filo Zegarlicki on 29.07.2022
 **/

interface ProjectRepository {
    Project save(Project entity);

    Optional<Project> findById(Integer id);

    void delete(Project.Step entity);
}
