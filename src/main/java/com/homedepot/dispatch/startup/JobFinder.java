package com.homedepot.dispatch.startup;

import com.homedepot.dispatch.job.BasicJob;
import com.homedepot.dispatch.event.publisher.JobPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Created by dnl0rot on 5/19/17.
 */
@Component
public class JobFinder implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    JobPublisher publisher;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("finding jobs......");

        System.out.println("found new job! creating event");
        publisher.publish(new BasicJob("1", 3000L, "http://localhost:8080/test"));
    }
}
