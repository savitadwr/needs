package com.needs.rs;

import com.needs.model.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;

    public HelloWorldResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
    }

    @GET
    public Saying sayHello(@QueryParam("name") String name) {
        final String result = name == null ? this.defaultName : name;
        final String value = String.format(template, result);
        return new Saying(1, value);
    }
}
