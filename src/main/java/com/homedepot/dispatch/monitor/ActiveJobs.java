package com.homedepot.dispatch.monitor;

import com.homedepot.dispatch.job.BasicJob;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by davidnix on 6/2/17.
 */
@Component
public class ActiveJobs {


    private HashMap<String, ActiveJob> catalog = new HashMap<>();

    public void add(BasicJob job, ScheduledFuture<?> schedule) {

        catalog.put(job.getName(), new ActiveJob(schedule, job));
    }

    public ActiveJob find(String jobName) {

        return catalog.get(jobName);
    }

    public boolean isActive(String jobName){

        return catalog.containsKey(jobName);
    }


    public void remove(String jobName) {

        catalog.remove(jobName);
    }

    public Collection<ActiveJob> all() {
        return catalog.values();
    }

    public static class ActiveJob {
        private ScheduledFuture<?> schedule;
        private BasicJob job;

        public ActiveJob(ScheduledFuture<?> schedule, BasicJob job) {
            this.schedule = schedule;

            this.job = job;
        }

        public void stop() {

            schedule.cancel(true);
        }

        public BasicJob getJob() {
            return job;
        }
    }
}
