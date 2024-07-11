package com.selimhorri.app.auth;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class LoginController {
	
	private final LoginService loginService;
	
	@POST
	public Response login(@Valid LoginRequest loginRequest) {
		return Response
				.ok(this.loginService.login(loginRequest))
				.build();
	}
	
}



