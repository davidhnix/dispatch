package com.homedepot.dispatch.event.publisher;

import org.springframework.context.ApplicationEvent;

/**
 * Created by dnl0rot on 5/19/17.
 */
public class JobCreatedEvent extends ApplicationEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public JobCreatedEvent(Object source) {
        super(source);
    }
}
