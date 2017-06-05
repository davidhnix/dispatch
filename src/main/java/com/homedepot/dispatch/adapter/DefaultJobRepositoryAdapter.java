package com.homedepot.dispatch.adapter;

import com.homedepot.dispatch.job.BasicJob;
import com.homedepot.dispatch.job.DefaultUrlTargetter;
import com.homedepot.dispatch.job.JobFactory;
import com.homedepot.dispatch.jpa.job.entity.Job;
import com.homedepot.dispatch.jpa.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

/**
 * Created by davidnix on 6/2/17.
 */
@Component
public class DefaultJobRepositoryAdapter implements JobRepositoryAdapter {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    JobFactory jobFactory;

    @Override
    public List<BasicJob> allJobs() {
        return jobRepository.findAll()
                .stream()
                .map(job -> makeJob(job))
                .collect(Collectors.toList());
    }

    private BasicJob makeJob(Job job) {
        return jobFactory.chooseImplementation(
                new BasicJob(
                        job.getJobName()
                        , job.getCronExpression()
                        , new DefaultUrlTargetter(job.getTarget())
                        , TimeZone.getTimeZone(job.getTimezone())
                        , job.getDcNumber()));
    }

    @Override
    public BasicJob find(String name) {

        return makeJob(jobRepository.findByJobName(name));
    }
}
