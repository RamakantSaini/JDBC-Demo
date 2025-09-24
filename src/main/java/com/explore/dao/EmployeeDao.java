package com.explore.dao;

import java.sql.SQLException;
import java.util.List;

import com.explore.entity.Employee;

public interface EmployeeDao {
	public void InsertData(Employee e) throws SQLException;
	
	public void UpdateData(Employee e);
	
	public void DeleteData(int id);
	
	public List<Employee> getAllData();
	
	public void printAllEmployee();
	
	public void getEmpByName(String name);

}
