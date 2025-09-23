package com.explore;

//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;

public class Main {

	private static String url = "jdbc:mysql://localhost:3306/db1";
	private static String username = "root";
	private static String password = "admin@123";


	public static void main(String[] args) {
		try {

//			conn = DriverManager.getConnection(url, username, password);
//
//			st = conn.createStatement();
//
//			st.executeUpdate("INSERT INTO ducatstudents(id,name,salary) values (1,'Aman Saini',20000)");
			
			DriverManager.getConnection(url, username, password).createStatement().executeUpdate("INSERT INTO ducatstudents(id,name,salary) values (2,'Raj Saini',30000)");

			System.out.println("Data Inserted successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
