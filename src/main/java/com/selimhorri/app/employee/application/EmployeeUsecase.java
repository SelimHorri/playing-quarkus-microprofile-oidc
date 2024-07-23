package com.selimhorri.app.employee.application;

import com.selimhorri.app.employee.domain.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import org.jboss.logging.Logger;

import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor
public class EmployeeUsecase {
	
	private final Logger log;
	private final EmployeeRepository employeeRepository;
	
	public List<EmployeeDto> findAll() {
		log.info("accessing findAll business logic");
		return this.employeeRepository.findAlll()
				.stream()
				.map(EmployeeDto::from)
				.toList();
	}
	
}



