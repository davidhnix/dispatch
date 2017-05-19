package com.homedepot.dispatch.executor;

import com.homedepot.dispatch.executor.exception.ExecutionException;
import com.homedepot.dispatch.job.Job;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by dnl0rot on 5/19/17.
 */
@Component
@Scope("prototype")
public class BasicExecutor implements Executor {

    Timestamp lastRunTime;

    @Override
    public void manage(Job job) {

        while (true) {

            if (job.schedule().isTimeToRun(currentTime(), getLastRunTime())) {
                System.out.println("excecuting Job -->  " + job.id());

                try {
                    job.execute();
                } catch (Exception e) {
                    //TODO: actual log this somewhere
                    e.printStackTrace();
                }

                setLastRunTime(currentTime());
                System.out.println("....job's done.");
            }


            hangOut(1000L);
        }

    }

    private Timestamp getLastRunTime() {

        if (lastRunTime == null) {
            setLastRunTime(currentTime());
        }

        return lastRunTime;
    }

    public void setLastRunTime(Timestamp lastRunTime) {
        this.lastRunTime = lastRunTime;
    }

    private Timestamp currentTime() {return new Timestamp(System.currentTimeMillis());}

    private void hangOut(Long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            fail("Excecution Interrupted", e);
        }
    }

    private void fail(String message, Exception e) {
        throw new ExecutionException(message, e);
    }
}
