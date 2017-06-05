package com.homedepot.dispatch.job;

/**
 * Created by davidnix on 6/2/17.
 */
public class DefaultUrlTargetter implements TargetUrl{

    String url;

    public DefaultUrlTargetter(String url) {
        this.url = url;
    }


    @Override
    public String getFullUrl() {
        return url;
    }
}
