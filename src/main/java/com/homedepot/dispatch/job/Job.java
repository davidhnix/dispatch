package com.homedepot.dispatch.job;

/**
 * Created by dnl0rot on 5/19/17.
 */
public interface Job {

    String id();

    JobSchedule schedule();

    void execute() throws Exception;
}
