package com.homedepot.dispatch.job;

import com.homedepot.dispatch.jpa.job.entity.Job;
import org.springframework.web.client.RestTemplate;

import java.lang.annotation.Target;
import java.util.TimeZone;

/**
 * Created by dnl0rot on 5/19/17.
 */
public class BasicJob implements Runnable {

    String name;
    private String cronExpression;
    private TargetUrl target;
    private TimeZone timezone;
    private String dcNumber;

    public BasicJob(){

    }

    public BasicJob(String name, String cronExpression, TargetUrl target, TimeZone timezone, String dcNumber) {
        this.name = name;
        this.cronExpression = cronExpression;
        this.target = target;
        this.timezone = timezone;
        this.dcNumber = dcNumber;
    }


    public String id() {
        return name;
    }

    @Override
    public void run() {
        new RestTemplate().getForEntity(target.getFullUrl(), String.class);

        System.out.println("JOB EXCECUTED: " + name);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TargetUrl getTarget() {
        return target;
    }

    public void setTarget(TargetUrl target) {
        this.target = target;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public TimeZone getTimezone() {
        return timezone;
    }

    public void setTimezone(TimeZone timezone) {
        this.timezone = timezone;
    }

    public String getDcNumber() {
        return dcNumber;
    }

    public void setDcNumber(String dcNumber) {
        this.dcNumber = dcNumber;
    }

    @Override
    public String toString() {
        return name;
    }

}
