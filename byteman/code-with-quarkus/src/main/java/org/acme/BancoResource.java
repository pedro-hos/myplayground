package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/banco")
public class BancoResource {
	
	@GET
	@Path("/sacar/{valor}")
    @Produces(MediaType.TEXT_PLAIN)
	public Response sacar(@PathParam("valor") double valor) {
		double saldo = 100.00;
		
		if(saldo < valor) {
			return Response.status(Status.PAYMENT_REQUIRED).entity("Saldo insuficiente! Vai trabalhar para ganhar mais!").build(); 
		}
		
		saldo = saldo - valor;
		return Response.ok("Sucesso! Toma aqui seu dinheiro!").build(); 
	}

}
