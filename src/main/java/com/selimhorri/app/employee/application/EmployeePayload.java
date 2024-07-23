package com.selimhorri.app.employee.application;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public record EmployeePayload(Integer id, String employeeName, Long employeeSalary, Integer employeeAge, String profileImage) {}



