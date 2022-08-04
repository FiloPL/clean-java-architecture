package ttsw.filopl.cleanjavaarchitecture.project;

import ttsw.filopl.cleanjavaarchitecture.project.dto.ProjectDto;

import java.util.Optional;
import java.util.Set;

/**
 * Created by T. Filo Zegarlicki on 02.08.2022
 **/

public interface ProjectQueryRepository {
    Optional<ProjectDto> findDtoById(Integer id);

    <T> Set<T> findBy(Class<T> type);

    long count();
}
