package com.homedepot.dispatch.adapter;

import com.homedepot.dispatch.job.BasicJob;
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
public class Jobs implements JobRepositoryAdapter {

    @Autowired
    JobRepository jobRepository;


    @Override
    public List<BasicJob> allJobs() {
        return jobRepository.findAll()
                .stream()
                .map(job -> new BasicJob(job.getJobName(), job.getCronExpression(), job.getTarget(), TimeZone.getTimeZone(job.getTimezone())))
                .collect(Collectors.toList());
    }

    @Override
    public BasicJob findJob(String name) {
        Job job = jobRepository.findByJobName(name);
        return new BasicJob(job.getJobName(), job.getCronExpression(), job.getTarget(), TimeZone.getTimeZone(job.getTimezone()));
    }
}
