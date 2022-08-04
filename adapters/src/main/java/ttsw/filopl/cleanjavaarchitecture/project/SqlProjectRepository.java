package ttsw.filopl.cleanjavaarchitecture.project;

import org.springframework.data.repository.Repository;

/**
 * Created by T. Filo Zegarlicki on 04.08.2022
 **/

interface SqlProjectRepository extends ProjectRepository, Repository<Project, Integer> {
}

