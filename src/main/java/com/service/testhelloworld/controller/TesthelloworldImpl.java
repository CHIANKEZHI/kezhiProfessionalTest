package com.service.testhelloworld.controller;



import javax.ws.rs.core.MediaType;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@javax.annotation.Generated(value = "io.swagger.codegen.languages.CseSpringDemoCodegen", date = "2018-05-23T07:05:35.012Z")

@RestSchema(schemaId = "testhelloworld")
@RequestMapping(path = "/testHelloWorld", produces = MediaType.APPLICATION_JSON)
public class TesthelloworldImpl {

    @Autowired
    private TesthelloworldDelegate userTesthelloworldDelegate;


    @RequestMapping(value = "/helloworld",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public String helloworld( @RequestParam(value = "name", required = true) String name){

        return userTesthelloworldDelegate.helloworld(name);
    }

}
