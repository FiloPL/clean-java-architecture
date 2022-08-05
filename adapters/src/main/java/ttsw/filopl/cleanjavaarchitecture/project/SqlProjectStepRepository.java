package ttsw.filopl.cleanjavaarchitecture.project;

import org.springframework.data.repository.Repository;

/**
 * Created by T. Filo Zegarlicki on 04.08.2022
 **/

interface SqlProjectStepRepository extends Repository<SqlProjectStep, Integer> {
    void deleteById(int id);
}

@org.springframework.stereotype.Repository
class ProjectStepRepositoryImpl implements ProjectStepRepository {
    private final SqlProjectStepRepository repository;

    ProjectStepRepositoryImpl(final SqlProjectStepRepository repository) {
        this.repository = repository;
    }

    @Override
    public void delete(final ProjectStep entity) {
        repository.deleteById(entity.getId());
    }
}