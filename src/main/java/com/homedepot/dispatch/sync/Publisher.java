package com.homedepot.dispatch.sync;

import com.homedepot.dispatch.monitor.ActiveJobs;
import com.homedepot.dispatch.job.BasicJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import static com.homedepot.dispatch.monitor.ActiveJobs.*;

/**
 * Created by dnl0rot on 5/19/17.
 */
@Component
public class Publisher {

    ApplicationContext context;
    private TaskScheduler taskscheduler;
    private ActiveJobs activeJobs;

    @Autowired
    public Publisher(ApplicationContext context, TaskScheduler taskscheduler, ActiveJobs activeJobs) {

        this.context = context;
        this.taskscheduler = taskscheduler;
        this.activeJobs = activeJobs;
    }

    public void publish(BasicJob job) {

        activeJobs.add(job,
                taskscheduler.schedule(
                        job
                        , new CronTrigger(job.getCronExpression(), job.getTimezone())));
        System.out.println("published " + job);
    }

    public void stop(String jobName){
        System.out.println("attempting to stop job ..." + jobName);

        if(activeJobs.isActive(jobName)) {

            ActiveJob activeJob = activeJobs.find(jobName);
            activeJob.stop();
            activeJobs.remove(jobName);
            System.out.println(jobName + " stopped.");
        } else {
            System.out.println(jobName + " already stopped! ");
        }
    }

}
