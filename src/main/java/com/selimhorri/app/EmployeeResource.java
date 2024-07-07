package com.selimhorri.app;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestPath;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
class EmployeeResource {
	
	@RestClient
	private final EmployeeRemoteClient employeeRemoteClient;
	private final EmployeeService employeeService;
	
	@GET
	public Response findAll() {
		return Response
				.ok(this.employeeService.findAll())
				.build();
	}
	
	@GET
	@Path("/remote/employees")
	public Response findAllRemoteEmployees() {
		return this.employeeRemoteClient.findAllEmployeesWithCheck();
	}
	
	@GET
	@Path("/remote/employees/{id}")
	public Response findRemoteEmployeeById(@RestPath Integer id) {
		return this.employeeRemoteClient.findByIdWithCheck(id);
	}
	
}



