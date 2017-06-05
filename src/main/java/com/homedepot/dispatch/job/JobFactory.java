package com.homedepot.dispatch.job;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;

/**
 * Created by davidnix on 6/2/17.
 */
public interface JobFactory {

    BasicJob chooseImplementation(BasicJob job);
}
