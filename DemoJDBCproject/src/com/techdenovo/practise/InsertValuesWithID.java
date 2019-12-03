package com.techdenovo.practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import com.techdenovo.practise.model.Employee;
import com.techdenovo.practise.model.EmployeeWithID;

public class InsertValuesWithID {
	String url="jdbc:mariadb://localhost:3306/jdbcdemodb";
	String user="root";
	String password="";
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertValuesWithID insertValues = new InsertValuesWithID();
		EmployeeWithID employeeWithID = new EmployeeWithID();
		try {
			System.out.println("Enter Employee Id: ");
			employeeWithID.setId(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()));
			System.out.println("Enter Employee Name: ");
			employeeWithID.setName(new BufferedReader(new InputStreamReader(System.in)).readLine());
			System.out.println("Enter Employee Designation: ");
			employeeWithID.setDesignation(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlQuery="insert into employeewithpk values("+employeeWithID.getId()+",'"+employeeWithID.getName()+"','"+employeeWithID.getDesignation()+"')";
		//System.out.println(sqlQuery);
		Connection con= null;
		try {
			DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
			
			con= DriverManager.getConnection(insertValues.url,insertValues.user,insertValues.password);
			Statement st = con.createStatement();
			int m = st.executeUpdate(sqlQuery);
			if(m==1) {
				System.out.println("Inserted Successfully");
				System.out.println("Employee Name- "+employeeWithID.getName());
				System.out.println("Employee Name- "+employeeWithID.getDesignation());
			}
			else {
				System.out.println("insertion failed");
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
