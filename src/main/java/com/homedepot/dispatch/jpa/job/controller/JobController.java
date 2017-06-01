package com.homedepot.dispatch.jpa.job.controller;

import com.homedepot.dispatch.jpa.job.entity.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by dnl0rot on 5/19/17.
 */
public class JobController {

    public ResponseEntity jobs(@RequestBody Job job){

        return new ResponseEntity(job, HttpStatus.CREATED);
    }
}
