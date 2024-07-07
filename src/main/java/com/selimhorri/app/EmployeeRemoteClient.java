package com.selimhorri.app;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.ClientWebApplicationException;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;
import java.util.function.Supplier;

@RegisterRestClient(configKey = "employees-remote-client")
@Path("/api/v1")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
interface EmployeeRemoteClient {
	
	@GET
	@Path("/employees")
	ApiPayload<List<EmployeePayload>> findAllEmployees();
	
	@GET
	@Path("/employee/{id}")
	ApiPayload<List<EmployeePayload>> findById(@RestPath Integer id);
	
	default Response findAllEmployeesWithCheck() {
		return this.handleException(this::findAllEmployees);
	}
	
	default Response findByIdWithCheck(Integer id) {
		return this.handleException(() -> this.findById(id));
	}
	
	private Response handleException(Supplier<? extends ApiPayload<?>> successfulBody) {
		try {
			return Response
					.ok(successfulBody.get())
					.build();
		}
		catch (ClientWebApplicationException e) {
			return Response
					.serverError()
					.entity("Error fetching API: " + e.getMessage())
					.build();
		}
	}
	
}



