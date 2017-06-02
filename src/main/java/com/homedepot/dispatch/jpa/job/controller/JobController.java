package com.homedepot.dispatch.jpa.job.controller;

import com.homedepot.dispatch.jpa.job.entity.Job;
import com.homedepot.dispatch.jpa.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dnl0rot on 5/19/17.
 */
@Controller
public class JobController {

    @Autowired
    JobRepository jobRepository;

    @RequestMapping(value = "/jobs", method = RequestMethod.POST)
    public ResponseEntity jobs(@RequestBody Job job){

        jobRepository.save(job);

        return new ResponseEntity(job, HttpStatus.CREATED);
    }

    @GetMapping("/jobs")
    public ResponseEntity getJobs(){
        return new ResponseEntity(jobRepository.findAll(), HttpStatus.OK);
    }
}
