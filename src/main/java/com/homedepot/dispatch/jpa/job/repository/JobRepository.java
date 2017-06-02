package com.homedepot.dispatch.jpa.job.repository;

import com.homedepot.dispatch.jpa.job.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by dnl0rot on 5/19/17.
 */
public interface JobRepository extends JpaRepository<Job, Integer>{

    Job findByJobName(@Param("jobName") String jobName);
}
