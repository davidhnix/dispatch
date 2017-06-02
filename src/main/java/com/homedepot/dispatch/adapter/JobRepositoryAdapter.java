package com.homedepot.dispatch.adapter;

import com.homedepot.dispatch.job.BasicJob;
import com.homedepot.dispatch.jpa.job.entity.Job;

import java.util.List;

/**
 * Created by davidnix on 6/2/17.
 */
public interface JobRepositoryAdapter {

    List<BasicJob> allJobs();

    BasicJob findJob(String name);
}
