package com.createiq.ems.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.createiq.ems.model.Employee;
import com.createiq.ems.service.EmployeeService;

public class EmployeeTest {
	public static void main(String[] args) {
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("bean.xml");
		EmployeeService employeeService=(EmployeeService) applicationContext.getBean("employeeService");
	
		
		//Employee employee=(Employee) applicationContext.getBean("employee");
//		Employee employee=new Employee(912, "Nagarjuna", 35000.);
//		employeeService.save(employee);
//		Employee employee=new Employee();
//		employee.setEid(912);
//		employee.setEname("Bochu");
//		employeeService.update(employee);
//		employeeService.findById(912);
		employeeService.findByAll();
		
		
	}

}
