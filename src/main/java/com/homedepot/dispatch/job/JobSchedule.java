package com.homedepot.dispatch.job;

import java.sql.Timestamp;

/**
 * Created by dnl0rot on 5/19/17.
 */
public interface JobSchedule {

    boolean isTimeToRun(Timestamp currentTime, Timestamp lastRunTime);
}
