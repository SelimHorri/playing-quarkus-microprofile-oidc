package com.selimhorri.app;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
class EmployeeRepository implements PanacheRepositoryBase<Employee, Integer> {
	
	public List<Employee> findAlll() {
		return listAll(Sort.by("id").descending()); 
	}
	
}



