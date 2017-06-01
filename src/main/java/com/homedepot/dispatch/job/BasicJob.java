package com.homedepot.dispatch.job;

import org.springframework.web.client.RestTemplate;

/**
 * Created by dnl0rot on 5/19/17.
 */
public class BasicJob implements Runnable {

    String name;
    private String cronExpression;
    private String target;

    public BasicJob(){

    }

    public BasicJob(String name, String cronExpression, String target) {
        this.name = name;
        this.cronExpression = cronExpression;
        this.target = target;
    }


    public String id() {
        return name;
    }

    @Override
    public void run() {
        new RestTemplate().getForEntity(target, String.class);

        System.out.println("JOB EXCECUTED: " + name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }
}
