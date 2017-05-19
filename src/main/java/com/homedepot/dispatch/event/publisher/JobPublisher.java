package com.homedepot.dispatch.event.publisher;

import com.homedepot.dispatch.job.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * Created by dnl0rot on 5/19/17.
 */
@Component
public class JobPublisher {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    public void publish(Job job) {
        applicationEventPublisher.publishEvent(new JobCreatedEvent(job));
    }
}
