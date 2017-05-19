package com.homedepot.dispatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DispatchApplication {


	public static void main(String[] args) {

	    SpringApplication.run(DispatchApplication.class, args);
	}
}
