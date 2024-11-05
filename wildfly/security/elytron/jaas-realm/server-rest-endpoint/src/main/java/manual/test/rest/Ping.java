package manual.test.rest;

import jakarta.annotation.Resource;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.EJBContext;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("ping")
@Stateless
public class Ping {
	
	@Resource
    private SessionContext sessionContext;

    @Resource
    private EJBContext ejbContext;

    @GET
    @RolesAllowed("Admin")
    public String ping() {
        return sessionContext == null ? "No session context! " :  "Hello " + sessionContext.getCallerPrincipal().getName() + "!";
    }
    
}
