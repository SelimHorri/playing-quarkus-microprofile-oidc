package com.selimhorri.app.employee.application;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.selimhorri.app.employee.domain.Employee;

import java.time.LocalDate;
import java.util.UUID;

public record EmployeeDto(UUID identifier,
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



