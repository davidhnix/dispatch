package com.homedepot.dispatch.job;

import org.springframework.web.client.RestTemplate;

/**
 * Created by dnl0rot on 5/19/17.
 */
public class BasicJob implements Job {

    String id;
    JobSchedule jobSchedule;
    private String target;

    public BasicJob(String id, Long jobFrequency, String target) {
        this.id = id;
        this.jobSchedule = new BasicJobSchedule(jobFrequency);
        this.target = target;
    }


    @Override
    public String id() {
        return id;
    }

    @Override
    public JobSchedule schedule() {
        return jobSchedule;
    }

    @Override
    public void execute() throws Exception {

        new RestTemplate().getForEntity(target, String.class);

        System.out.println("JOB EXCECUTED: " + id);
    }
}
