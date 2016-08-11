package com.spring.mvc.SpringMVCDemo.controller;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * This class helps in controlling configuration of JSON serialization and deserialization features,
 * it is a wrapper arround default Jackson ObjectMapper
 * 
 * @author nakaskaa
 */
@Component("jacksonObjectMapper")
public class JacksonJsonObjectMapper extends ObjectMapper {

    private static final long serialVersionUID = 1L;

    public JacksonJsonObjectMapper() {
        super();
        updateFeatureConfigurations();
    }

    /**
     * use this method to enable and disable serialization and deserialization features
     * detail documentation on Seriliazation feature can be found at
     * http://wiki.fasterxml.com/JacksonFeaturesSerialization
     * detail documentation on Deserilization feature can be found at
     * http://wiki.fasterxml.com/JacksonFeaturesDeserialization
     */
    private void updateFeatureConfigurations() {
        enable(SerializationFeature.INDENT_OUTPUT);
        enable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
        disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        disable(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS);
        setSerializationInclusion(Include.NON_NULL);
    }
}
