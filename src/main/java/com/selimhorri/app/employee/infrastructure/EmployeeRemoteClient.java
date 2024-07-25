package com.selimhorri.app.employee.infrastructure;

import com.selimhorri.app.ApiPayload;
import com.selimhorri.app.employee.application.EmployeePayload;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

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
	ApiPayload<EmployeePayload> findById(@RestPath Integer id);
	
}



