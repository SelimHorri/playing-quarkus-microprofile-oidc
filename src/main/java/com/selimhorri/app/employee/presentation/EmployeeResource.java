package com.selimhorri.app.employee.presentation;

import com.selimhorri.app.ApiPayload;
import com.selimhorri.app.employee.application.EmployeeInfoRetriever;
import com.selimhorri.app.employee.application.EmployeeUsecase;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
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
		return new ResponseWrapper(this.employeeInfoRetriever::findAllEmployees)
				.toResponse();
	}
	
	@GET
	@Path("/remote/employees/{id}")
	public Response findRemoteEmployeeById(@RestPath Integer id) {
		return new ResponseWrapper(() -> this.employeeInfoRetriever.findById(id))
				.toResponse();
	}
	
	private record ResponseWrapper(Supplier<? super ApiPayload<?>> payload) {
		
		Response toResponse() {
			return handleException(payload);
		}
		
		private static Response handleException(Supplier<? super ApiPayload<?>> successfulBody) {
			try {
				return Response
						.ok(successfulBody.get())
						.build();
			}
			catch (WebApplicationException e) {
				return Response
						.serverError()
						.entity("Error fetching API: " + e.getMessage())
						.build();
			}
		}
		
	}
	
}



