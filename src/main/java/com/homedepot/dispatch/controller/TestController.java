package com.homedepot.dispatch.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dnl0rot on 6/1/17.
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public ResponseEntity testMe(){
        System.out.println("/test was called");
        return new ResponseEntity(HttpStatus.OK);
    }
}
