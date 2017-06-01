package com.homedepot.dispatch.config;

import com.homedepot.dispatch.jpa.job.entity.Job;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Created by dnl0rot on 6/1/17.
 */
@Configuration
public class RestRepositoryConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Job.class);
    }
}
