package com.selimhorri.app;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
record EmployeePayload(Integer id, String employeeName, Long employeeSalary, Integer employeeAge, String profileImage) {}



