package com.createiq.ems.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import com.createiq.ems.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	@Autowired
	private DriverManagerDataSource dataSource;
	public void save(Employee employee) {
		try {
			 connection=dataSource.getConnection();
			 preparedStatement=connection.prepareStatement("insert into employee values(?,?,?)");
			 preparedStatement.setInt(1, employee.getEid());
			 preparedStatement.setString(2, employee.getEname());
			preparedStatement.setDouble(3, employee.getEsalary());
			 
			int i= preparedStatement.executeUpdate();
			 System.out.println(i);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void update(Employee employee) {
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement("update  employee set ename=?  where eid=?");
			preparedStatement.setString(1, employee.getEname());
			preparedStatement.setInt(2,employee.getEid());
			int i=preparedStatement.executeUpdate();
			System.out.println("updated row sucessfully with "+employee.getEid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void findById(Integer id) {
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement("select * from employee where eid=?");
			preparedStatement.setInt(1,id);
			resultSet=preparedStatement.executeQuery();
			List<Employee> employees =new ArrayList<Employee>();
			while (resultSet.next()) {
				Employee employee=new Employee();
				employee.setEid(resultSet.getInt(1));
				employee.setEname(resultSet.getString(2));
				employee.setEsalary(resultSet.getDouble(3));
				employees.add(employee);
				}
			System.out.println(employees);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public void findByAll() {
		try {
			connection=dataSource.getConnection();
			preparedStatement=connection.prepareStatement("select * from employee");
			resultSet=preparedStatement.executeQuery();
			List<Employee> employees =new ArrayList<Employee>();
			while (resultSet.next()) {
				Employee employee=new Employee();
				employee.setEid(resultSet.getInt(1));
				employee.setEname(resultSet.getString(2));
				employee.setEsalary(resultSet.getDouble(3));
				employees.add(employee);
				}
			System.out.println(employees);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
