package com.createiq.ems.service;

import com.createiq.ems.model.Employee;

public interface EmployeeService {
	
	void save(Employee employee);

	void update(Employee employee);

	void findById(Integer id);

	void findByAll();

}
