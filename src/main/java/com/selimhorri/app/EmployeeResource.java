package com.selimhorri.app;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
class EmployeeResource {
	
	private final EmployeeService employeeService;
	
	@GET
	public Response findAll() {
		return Response
				.ok(this.employeeService.findAll())
				.build();
	}
	
}



