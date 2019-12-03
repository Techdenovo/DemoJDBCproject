package com.techdenovo.practise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.techdenovo.practise.model.Employee;

public class InsertValues {
	String url="";
	String user="";
	String password="";
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		try {
			employee.setName(new BufferedReader(new InputStreamReader(System.in)).readLine());
			employee.setDesignation(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sqlQuery="insert into employee values('"+employee.getName()+"','"+employee.getDesignation()+"')";
		//System.out.println(sqlQuery);
	}

}
