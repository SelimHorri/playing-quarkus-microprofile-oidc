package com.selimhorri.app.employee.application;

import com.selimhorri.app.ApiPayload;

import java.util.List;

public interface EmployeeInfoRetriever {
	
	ApiPayload<List<EmployeePayload>> findAllEmployees();
	ApiPayload<List<EmployeePayload>> findById(Integer id);
	
}



