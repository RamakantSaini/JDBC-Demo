package com.explore;

import java.sql.SQLException;
import java.util.List;

import com.explore.dao.EmployeeDao;
import com.explore.dao.EmployeeDaoImpl;
import com.explore.entity.Employee;
//import java.sql.Statement;

public class Main {
	public static void main(String[] args) throws SQLException {
		
		EmployeeDao edao = new EmployeeDaoImpl();
//		Employee e1 = new Employee(4,"Piyush Saini",300000);
//		
//		edao.InsertData(e1);
		
//		edao.printAllEmployee();
		
		//Sql Injection
		edao.getEmpByName("abc' or '1=1");
	}

}
