package com.selimhorri.app.employee.application;

import com.selimhorri.app.ApiPayload;
import org.jboss.resteasy.reactive.RestPath;

import java.util.List;

public interface EmployeeConsumerService {
	
	ApiPayload<List<EmployeePayload>> findAllEmployees();
	ApiPayload<List<EmployeePayload>> findById(@RestPath Integer id);
	
}



