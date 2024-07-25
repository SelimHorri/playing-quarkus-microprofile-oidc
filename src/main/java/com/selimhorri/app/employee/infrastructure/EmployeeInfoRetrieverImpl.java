package com.selimhorri.app.employee.infrastructure;

import com.selimhorri.app.ApiPayload;
import com.selimhorri.app.employee.application.EmployeeInfoRetriever;
import com.selimhorri.app.employee.application.EmployeePayload;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
class EmployeeInfoRetrieverImpl implements EmployeeInfoRetriever {
	
	@RestClient
	private final EmployeeRemoteClient employeeRemoteClient;
	
	@Override
	public ApiPayload<List<EmployeePayload>> findAllEmployees() throws WebApplicationException {
		return this.employeeRemoteClient.findAllEmployees();
	}
	
	@Override
	public ApiPayload<EmployeePayload> findById(Integer id) throws WebApplicationException {
		return this.employeeRemoteClient.findById(id);
	}
	
}



