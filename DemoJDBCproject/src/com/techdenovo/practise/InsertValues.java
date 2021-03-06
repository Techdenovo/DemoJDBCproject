package com.techdenovo.practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

import com.techdenovo.practise.model.Employee;

public class InsertValues {
	String url="jdbc:mariadb://localhost:3306/jdbcdemodb";
	String user="root";
	String password="";
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertValues insertValues = new InsertValues();
		Employee employee = new Employee();
		try {
			System.out.println("Enter Employee Name: ");
			employee.setName(new BufferedReader(new InputStreamReader(System.in)).readLine());
			System.out.println("Enter Employee Designation: ");
			employee.setDesignation(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlQuery="insert into employee values('"+employee.getName()+"','"+employee.getDesignation()+"')";
		//System.out.println(sqlQuery);
		Connection con= null;
		try {
			DriverManager.registerDriver(new org.mariadb.jdbc.Driver());
			
			con= DriverManager.getConnection(insertValues.url,insertValues.user,insertValues.password);
			Statement st = con.createStatement();
			int m = st.executeUpdate(sqlQuery);
			if(m==1) {
				System.out.println("Inserted Successfully");
				System.out.println("Employee Name- "+employee.getName());
				System.out.println("Employee Name- "+employee.getDesignation());
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
