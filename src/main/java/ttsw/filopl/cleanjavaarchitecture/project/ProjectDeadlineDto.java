package ttsw.filopl.cleanjavaarchitecture.project;

import java.time.ZonedDateTime;

/**
 * Created by T. Filo Zegarlicki on 28.07.2022
 **/

class ProjectDeadlineDto {
    private ZonedDateTime deadline;

    ZonedDateTime getDeadline() {
        return deadline;
    }

    void setDeadline(ZonedDateTime deadline) {
        this.deadline = deadline;
    }
}
