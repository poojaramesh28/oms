package com.oms.DAO;

import java.sql.*;

import com.oms.model.Employee;



public class LoginDAO {
	public static boolean Validate(String name, String pass)
	{
		boolean status = false;
		try{
			Connection con = AdminDAO.getConnection();
		
	        
			PreparedStatement ps = con.prepareStatement("select * from employees where employee_name =? and employee_pass= ?");
			ps.setString(1, name);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
			}
		catch(Exception e){
			System.out.println(e);
		}
		
		return status;
	}
	
	
	

	// to check delete status


	public static int getDeleteStatus(String name, String password){
		 
		 int delete_status = 0 ;

		 try {

		  Connection con = AdminDAO.getConnection();
		  PreparedStatement ps = con
		    .prepareStatement("select delete_status from employees where employee_name=? and employee_pass=?");
		  ps.setString(1, name);
		  ps.setString(2, password);
		  ResultSet rs = ps.executeQuery();

		  while (rs.next()) {
		   delete_status = rs.getInt(1);
		  }

		 } catch (Exception e) {
		  System.out.println("Error fetching designation : " + e);
		 }
		 System.out.println(delete_status);
		 return delete_status;
		}


	
	
	public static String getDesignation(String name, String password)
	{
		String designation="";
	
		try{
			
			Connection con = AdminDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select designation from employees where employee_name=? and employee_pass=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
			designation = rs.getString(1);
			}
			
			
			
		
	}
		catch(Exception e){
			System.out.println("Error fetching designation : "+e);
		}
		System.out.println(designation);
		return designation;
		
	}
	
	
	
	

	public static int getEmployeeId(String name, String password)
	{
		int employee_id=0;
	
		try{
			Employee e= new Employee();
			
			Connection con = AdminDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select employee_id from employees where employee_name=? and employee_pass=?");
			ps.setString(1,name);
			ps.setString(2,password);
			ResultSet rs = ps.executeQuery();
			
			
			
			while(rs.next()) {
			employee_id = rs.getInt(1);
			}
			
			
			
		
	}
		catch(Exception e){
			System.out.println("Error fetching designation : "+e);
		}
		System.out.println(employee_id);
		return employee_id;
		
	}
	
}	
		
			   
		
		    
		    



