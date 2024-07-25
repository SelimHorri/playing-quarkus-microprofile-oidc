package com.selimhorri.app.employee.application;

import com.selimhorri.app.ApiPayload;
import jakarta.ws.rs.WebApplicationException;

import java.util.List;

public interface EmployeeInfoRetriever {
	
	ApiPayload<List<EmployeePayload>> findAllEmployees() throws WebApplicationException;
	ApiPayload<EmployeePayload> findById(Integer id) throws WebApplicationException;
	
}



