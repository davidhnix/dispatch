package com.homedepot.dispatch.monitor;

import com.homedepot.dispatch.monitor.ActiveJobs.ActiveJob;
import com.homedepot.dispatch.sync.Publisher;
import com.homedepot.dispatch.job.BasicJob;
import com.homedepot.dispatch.adapter.JobRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by dnl0rot on 5/19/17.
 */
@Component
public class Synchronizer {

    @Autowired
    Publisher publisher;

    @Autowired
    ActiveJobs activeJobs;

    @Autowired
    JobRepositoryAdapter jobRepository;

    @Scheduled(cron = "0/5 * * * * *")
    public void syncWithRepository(){

        for (BasicJob job : jobRepository.allJobs()) {
            if(!activeJobs.isActive(job.getName()))
                start(job);
        }
    }

    @Scheduled(cron = "0/5 * * * * *")
    public void decomissionRemovedJobs(){

        for (ActiveJob activeJob : activeJobs.all()) {
            if(jobRepository.find(activeJob.getJob().getName()) == null) {

                publisher.stop(activeJob.getJob().getName());
            }
        }

    }

    private void start(BasicJob job) {

        publisher.publish(job);
    }

}
