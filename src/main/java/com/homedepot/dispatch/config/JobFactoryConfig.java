package com.homedepot.dispatch.config;

import com.homedepot.dispatch.job.DefaultJobFactory;
import com.homedepot.dispatch.job.JobFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by davidnix on 6/2/17.
 */
@Configuration
public class JobFactoryConfig {

    @Bean
    public JobFactory defaultJobFactory(){
        return new DefaultJobFactory();
    }
}
