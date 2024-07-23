package com.selimhorri.app.employee.infrastructure;

import com.selimhorri.app.ApiPayload;
import com.selimhorri.app.employee.application.EmployeeConsumerService;
import com.selimhorri.app.employee.application.EmployeePayload;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
class EmployeeConsumerServiceImpl implements EmployeeConsumerService {
	
	@RestClient
	private final EmployeeRemoteClient employeeRemoteClient;
	
	@Override
	public ApiPayload<List<EmployeePayload>> findAllEmployees() {
		return this.employeeRemoteClient.findAllEmployees();
	}
	
	@Override
	public ApiPayload<List<EmployeePayload>> findById(Integer id) {
		return this.employeeRemoteClient.findById(id);
	}
	
}



