package com.homedepot.dispatch.controller;

import com.homedepot.dispatch.job.BasicJob;
import com.homedepot.dispatch.event.publisher.JobPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dnl0rot on 5/19/17.
 */
@Controller
public class JobController {

    @Autowired
    JobPublisher jobPublisher;

    @GetMapping("/job")
    public ResponseEntity createJob(@RequestParam String jobName){

        jobPublisher.publish(new BasicJob(String.valueOf(System.currentTimeMillis()), 10000L, "http://localhost:8080/test"));

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity testMe(){
        System.out.println("/test was called");
        return new ResponseEntity(HttpStatus.OK);
    }
}
