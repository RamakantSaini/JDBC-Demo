package com.explore.dao;

import java.sql.SQLException;

import com.explore.entity.Employee;

public interface EmployeeDao {
	public void InsertData(Employee e) throws SQLException;
	
	public void UpdateData(Employee e);
	
	public void DeleteData(int id);
	
	public void getAllData();
	

}
