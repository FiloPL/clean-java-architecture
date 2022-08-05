package ttsw.filopl.cleanjavaarchitecture.task;

import org.springframework.data.repository.Repository;

/**
 * Created by T. Filo Zegarlicki on 04.08.2022
 **/

interface SqlTaskQueryRepository extends TaskQueryRepository, Repository<SqlTask, Integer> {
}
