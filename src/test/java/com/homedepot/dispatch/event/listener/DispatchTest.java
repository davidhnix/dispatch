package com.homedepot.dispatch.event.listener;

import com.homedepot.dispatch.event.listener.exception.JobCreationException;
import com.homedepot.dispatch.event.publisher.JobCreatedEvent;
import com.homedepot.dispatch.executor.BasicExecutor;
import com.homedepot.dispatch.job.BasicJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by dnl0rot on 5/19/17.
 */
@SpringBootTest(classes = {Dispatch.class, BasicExecutor.class})
@RunWith(SpringRunner.class)
public class DispatchTest {

    @Autowired
    Dispatch dispatch;

    @Test(expected = JobCreationException.class)
    public void invalidSource() {
        JobCreatedEvent jobCreatedEvent = new JobCreatedEvent("david");

        dispatch.onApplicationEvent(jobCreatedEvent);
    }


    @Test
    public void basicJobCreated() {
        JobCreatedEvent jobCreatedEvent = new JobCreatedEvent(new BasicJob());

        dispatch.onApplicationEvent(jobCreatedEvent);
    }

}