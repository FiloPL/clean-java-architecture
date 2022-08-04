package ttsw.filopl.cleanjavaarchitecture.project;

import org.springframework.data.repository.Repository;
import ttsw.filopl.cleanjavaarchitecture.project.dto.ProjectDto;

import java.util.List;
import java.util.Optional;

/**
 * Created by T. Filo Zegarlicki on 02.08.2022
 **/

public interface ProjectQueryRepository extends Repository<Project, Integer> {
    Optional<ProjectDto> findDtoById(Integer id);

    List<ProjectDto> findBy();

    long count();
}
