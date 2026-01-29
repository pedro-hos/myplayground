package org.wildfly.examples;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.security.enterprise.authentication.mechanism.http.OpenIdAuthenticationMechanismDefinition;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RequestScoped
@Path("/oidc")
@Produces({ MediaType.TEXT_PLAIN })
@OpenIdAuthenticationMechanismDefinition( //
        clientId = "myclient", //
        clientSecret = "rDqoG5v8c1K1kc39rwvEZKNBNLxMceXq", //
        redirectURI = "http://localhost:8180/jaxrs-secured-oidc/secured", //
        providerURI = "http://localhost:8080/realms/myrealm", 
        extraParameters = {"bearer-only=true"} //
)
public class Securitybean implements Serializable{

	private static final long serialVersionUID = 1L;

}
