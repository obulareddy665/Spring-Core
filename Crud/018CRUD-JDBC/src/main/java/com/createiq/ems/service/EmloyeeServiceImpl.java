package com.createiq.ems.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.createiq.ems.dao.EmployeeDao;
import com.createiq.ems.model.Employee;
@Service("employeeService")
public class EmloyeeServiceImpl implements EmployeeService {
	@Autowired
		EmployeeDao employeeDao;
	public void save(Employee employee) {
		employeeDao.save(employee);
		
	}

	public void update(Employee employee) {
		employeeDao.update(employee);
		
	}

	public void findById(Integer id) {
		employeeDao.findById(id);
		
	}

	public void findByAll() {
		employeeDao.findByAll();
		
	}

}
