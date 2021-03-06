package com.pramy.demo.cxf.jersey;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * IntelliJ IDEA 17
 * Created by Pramy on 2018/2/1.
 */
@Component
@Path("/demo")
public class Demo {

    //path注解指定路径,get注解指定访问方式,produces注解指定了返回值类型，这里返回JSON
    @Path("/city")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public City get(){
        City city = new City();
        city.setId(1);
        city.setCityName("beijing");
        city.setCityCode("001");
        System.out.println(city.toString());
        return city;
    }



}