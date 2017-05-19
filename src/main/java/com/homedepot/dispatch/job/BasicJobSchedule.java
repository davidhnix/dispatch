package com.homedepot.dispatch.job;

import java.sql.Timestamp;

/**
 * Created by dnl0rot on 5/19/17.
 */
public class BasicJobSchedule implements JobSchedule {

    private Long jobFrequency;

    public BasicJobSchedule(Long jobFrequency) {

        this.jobFrequency = jobFrequency;
    }

    @Override
    public boolean isTimeToRun(Timestamp currentTime, Timestamp lastRunTime) {
        long diff = currentTime.getTime() - lastRunTime.getTime();
        return diff > jobFrequency;
    }
}
