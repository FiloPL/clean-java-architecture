package ttsw.filopl.cleanjavaarchitecture.project;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import ttsw.filopl.cleanjavaarchitecture.task.vo.TaskEvent;

/**
 * Created by T. Filo Zegarlicki on 11.08.2022
 **/


@Service
class ProjectEventListener {

    private final ProjectFacade facade;

    ProjectEventListener(final ProjectFacade facade) {
        this.facade = facade;
    }

    @EventListener
    // warning: must be synchronous in current design
    public void on(TaskEvent event) {
        facade.handle(event);
    }
}
