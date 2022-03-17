package com.paragona.demoliberty.rest.basic;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@RequestScoped
@Path("/greeting")
public class GreetingResource {

    @GET
    @Path("/hello")
    public String sayHello(){
        return "Hello";
    }
    
}
