package com.selimhorri.app;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import java.time.LocalDate;
import java.util.UUID;

record EmployeeDto(UUID identifier,
				   String firstname,
				   String lastname,
				   @JsonFormat(shape = Shape.STRING, pattern = "dd-MMM-yyyy") LocalDate hiredate) {
	
	public static EmployeeDto from(Employee employee) {
		return new EmployeeDto(
				employee.getIdentifier(),
				employee.getFirstname(),
				employee.getLastname(),
				employee.getHiredate());
	}
	
}



