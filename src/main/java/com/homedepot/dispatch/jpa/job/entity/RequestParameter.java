package com.homedepot.dispatch.jpa.job.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by davidnix on 6/2/17.
 */
@Entity
@Table(name="REQUEST_PARAM")
public class RequestParameter {

    @Id
    @GenericGenerator(name = "nextUp", strategy = "increment")
    @GeneratedValue(generator = "nextUp")
    Integer paramId;

    @OneToOne
    @JoinColumn(name="PARAM_TYPE_ID")
    ParameterType parameterType;

    String paramName;
    String paramValue;

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }
}
