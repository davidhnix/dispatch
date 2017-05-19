package com.homedepot.dispatch.executor;

import com.homedepot.dispatch.job.Job;

/**
 * Created by dnl0rot on 5/19/17.
 */
public interface Executor {

    public void manage(Job source);
}
