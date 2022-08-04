package ttsw.filopl.cleanjavaarchitecture.project;

import java.util.Optional;

/**
 * Created by T. Filo Zegarlicki on 29.07.2022
 **/

interface ProjectRepository {
    <S extends Project> S save(S entity);

    Optional<Project> findById(Integer id);

}
