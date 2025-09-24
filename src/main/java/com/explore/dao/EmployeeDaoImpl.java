package com.explore.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.explore.entity.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	private static Connection conn=null;
	
	private static String url = "jdbc:mysql://localhost:3306/db1";
	private static String username = "root";
	private static String password = "admin@123";
	
	private static final String INSERT_QUERY ="INSERT INTO ducatstudents VALUES (%d , '%s' , %f)";
	private static final String UPDATE_QUERY ="UPDATE  ducatstudents SET salary = '%f' WHERE ID = %d";
	private static final String DELETE_QUERY ="DELETE  FROM ducatstudents WHERE ID = %d";
	private static final String SELECT_QUERY ="SELECT  * FROM ducatstudents ";
	
	
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
		st.close();
		System.out.println("Data Inserted Successfully..");
	}

	@Override
	public void UpdateData(Employee e) {
		
		//Used try with resource for auto-closeable resources
		try(Statement st = conn.createStatement()){
			st.executeUpdate(String.format(UPDATE_QUERY,e.getSalary(),e.getId()));
			System.out.println("Data Updated Successfully");
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void DeleteData(int id) {
		
		try(Statement st = conn.createStatement()){
			st.executeUpdate(String.format(DELETE_QUERY, id));
			System.out.println("Deletion Successfull..");
		}
		catch(SQLException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public List<Employee> getAllData() {
		List<Employee> employee = new ArrayList<>();
		try(Statement st = conn.createStatement()){
			
			ResultSet rs = st.executeQuery(SELECT_QUERY);
			while(rs.next()) {
				
				Employee emp = new Employee();
				
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setSalary(rs.getDouble(3));
				employee.add(emp);
			}
		}
		catch(SQLException exception) {
			exception.printStackTrace();
		}
		return employee;
	}

	@Override
	public void printAllEmployee() {
		
		try(Statement st = conn.createStatement()){
			ResultSet rs = st.executeQuery(SELECT_QUERY);
			
			while(rs.next()) {
				System.out.println("ID = " + rs.getInt(1) +"\t Name = " + rs.getString(2) + "\t Salary = " + rs.getDouble(3));
			}
		}
		catch(SQLException exception) {
			exception.printStackTrace();
		}
	}

}
