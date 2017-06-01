package com.homedepot.dispatch.event.publisher;

import com.homedepot.dispatch.job.BasicJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

/**
 * Created by dnl0rot on 5/19/17.
 */
@Component
public class JobPublisher {

    ApplicationContext context;
    private TaskScheduler taskscheduler;

    @Autowired
    public JobPublisher(ApplicationContext context, TaskScheduler taskscheduler) {

        this.context = context;
        this.taskscheduler = taskscheduler;
    }

    public void publish(BasicJob job) {
        System.out.println("Job was created, starting dispatch");

        taskscheduler.schedule(job, new CronTrigger(job.getCronExpression()));

    }

}
