package com.homedepot.dispatch.event.listener;

import com.homedepot.dispatch.event.listener.exception.JobCreationException;
import com.homedepot.dispatch.event.publisher.JobCreatedEvent;
import com.homedepot.dispatch.executor.Executor;
import com.homedepot.dispatch.job.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Created by dnl0rot on 5/19/17.
 */
@Component
public class Dispatch implements ApplicationListener<JobCreatedEvent> {

    ApplicationContext context;

    @Autowired
    public Dispatch(ApplicationContext context) {

        this.context = context;
    }

    @Override
    @Async
    public void onApplicationEvent(JobCreatedEvent event) {
        if (!(event.getSource() instanceof Job))
            reject(event);

        System.out.println("Job was created, starting dispatch");

        Executor executor = context.getBean(Executor.class);

        executor.manage((Job) event.getSource());
    }

    private void reject(JobCreatedEvent event) {
        throw new JobCreationException("Job Created Events expect a source of Job, cannot handle source of " + event.getSource().getClass());
    }
}
