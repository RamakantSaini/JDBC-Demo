package com.explore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.explore.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static Connection conn=null;
	
	private static String url = "jdbc:mysql://localhost:3306/db1";
	private static String username = "root";
	private static String password = "admin@123";
	
	private static String INSERT_QUERY ="INSERT INTO ducatstudents VALUES (%d , '%s' , %f)";
	
	
	static {
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	@Override
	public void InsertData(Employee e) throws SQLException {
		
		
		Statement st = conn.createStatement();
		
		st.executeUpdate(String.format(INSERT_QUERY, e.getId(),e.getName(),e.getSalary()));
		
		System.out.println("Data Inserted Successfully..");
	}

	@Override
	public void UpdateData(Employee e) {
		
		
	}

	@Override
	public void DeleteData(int id) {
		
		
	}

	@Override
	public void getAllData() {
		
		
	}

}
