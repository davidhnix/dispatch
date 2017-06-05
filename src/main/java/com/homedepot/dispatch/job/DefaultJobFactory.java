package com.homedepot.dispatch.job;

/**
 * Created by davidnix on 6/2/17.
 */
public class DefaultJobFactory implements JobFactory {

    public BasicJob chooseImplementation(BasicJob job){

        return job;
    }
}
