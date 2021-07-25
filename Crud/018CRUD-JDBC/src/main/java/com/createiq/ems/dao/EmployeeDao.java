package com.createiq.ems.dao;

import com.createiq.ems.model.Employee;

public interface EmployeeDao {

	void save(Employee employee);

	void update(Employee employee);

	void findById(Integer id);

	void findByAll();
	
	
}
