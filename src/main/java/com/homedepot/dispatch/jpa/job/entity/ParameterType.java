package com.homedepot.dispatch.jpa.job.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by davidnix on 6/2/17.
 */
@Entity
@Table(name="PARAM_TYPE")
public class ParameterType {

    @Id
    @GenericGenerator(name = "nextUp", strategy = "increment")
    @GeneratedValue(generator = "nextUp")
    Integer paramTypeId;
    String paramTypeDescription;

    public Integer getParamTypeId() {
        return paramTypeId;
    }

    public void setParamTypeId(Integer paramTypeId) {
        this.paramTypeId = paramTypeId;
    }

    public String getParamTypeDescription() {
        return paramTypeDescription;
    }

    public void setParamTypeDescription(String paramTypeDescription) {
        this.paramTypeDescription = paramTypeDescription;
    }
}
