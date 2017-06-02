package com.homedepot.dispatch.controller;

import com.homedepot.dispatch.sync.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dnl0rot on 6/1/17.
 */
@RestController
public class TestController {

    @Autowired
    Publisher publisher;

    @GetMapping("/test")
    public ResponseEntity testMe(){
        System.out.println("/test was called");
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/kill")
    public void kill(@RequestParam("jobName") String jobName){
        System.out.println("killing " + jobName);

        publisher.stop(jobName);
    }

}
