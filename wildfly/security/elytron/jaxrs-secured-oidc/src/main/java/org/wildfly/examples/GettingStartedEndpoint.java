package org.wildfly.examples;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class GettingStartedEndpoint {

    @GET
    @Path("/public")
    public Response sayHello() {
        return Response.ok("Hello, public").build();
    }
    
    @GET
    @Path("/secured")
    public Response secured() {
    	return Response.ok("Hello, secured").build();
    }
}
