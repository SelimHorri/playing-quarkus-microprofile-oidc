package com.selimhorri.app.employee;

import com.selimhorri.app.ApiPayload;
import com.selimhorri.app.employee.application.EmployeeInfoRetriever;
import com.selimhorri.app.employee.application.EmployeeUsecase;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.jboss.resteasy.reactive.ClientWebApplicationException;
import org.jboss.resteasy.reactive.RestPath;

import java.util.function.Supplier;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
class EmployeeResource {
	
	private final EmployeeInfoRetriever employeeInfoRetriever;
	private final EmployeeUsecase employeeUsecase;
	
	@GET
	public Response findAll() {
		return Response
				.ok(this.employeeUsecase.findAll())
				.build();
	}
	
	@GET
	@Path("/remote/employees")
	public Response findAllRemoteEmployees() {
		return this.findAllEmployeesWithCheck();
	}
	
	@GET
	@Path("/remote/employees/{id}")
	public Response findRemoteEmployeeById(@RestPath Integer id) {
		return this.findByIdWithCheck(id);
	}
	
	private Response findAllEmployeesWithCheck() {
		return this.handleException(this.employeeInfoRetriever::findAllEmployees);
	}
	
	private Response findByIdWithCheck(Integer id) {
		return this.handleException(() -> this.employeeInfoRetriever.findById(id));
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



