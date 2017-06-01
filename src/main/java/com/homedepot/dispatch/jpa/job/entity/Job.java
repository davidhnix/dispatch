package com.homedepot.dispatch.jpa.job.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by dnl0rot on 5/19/17.
 */
@Entity
public class Job {

    @Id
    @GenericGenerator(name = "nextUp", strategy = "increment")
    @GeneratedValue(generator = "nextUp")
    Integer jobId;
    String jobName;
    String cronExpression;
    String target;

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
}