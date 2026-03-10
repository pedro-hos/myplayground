package com.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.inject.Inject;
import jakarta.security.enterprise.authentication.mechanism.http.OpenIdAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.openid.ClaimsDefinition;
import jakarta.security.enterprise.identitystore.openid.OpenIdContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tokens")
@OpenIdAuthenticationMechanismDefinition(
		providerURI = "http://localhost:8080/realms/master",
		clientId = "my_client",
		clientSecret = "KWE3apDc2IKdM2Fl3XzGoZSHjTGNBgY8",
		redirectToOriginalResource = true,
		claimsDefinition = @ClaimsDefinition(callerGroupsClaim = "groups"),
		tokenAutoRefresh = true
		)
@ServletSecurity(@HttpConstraint(rolesAllowed = "whatever"))
public class TokenServlet extends HttpServlet {
	@Inject
	private OpenIdContext oidcCtx;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain");
		PrintWriter writer = response.getWriter();
		
		writer.println("Access token:");
		writer.println("-------------");
		writer.println();
		writer.println(oidcCtx.getAccessToken().getToken());
		writer.println();
		writer.println(oidcCtx.getAccessToken().getJwtClaims());
		writer.println();
		
		writer.println("ID token:");
		writer.println("---------");
		writer.println();
		writer.println(oidcCtx.getIdentityToken().getToken());
		writer.println();
		writer.println(oidcCtx.getIdentityToken().getJwtClaims());
		writer.println();
		
		response.flushBuffer();
	}
}