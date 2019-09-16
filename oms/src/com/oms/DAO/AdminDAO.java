package com.oms.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oms.model.*;

import com.oms.DAO.*;


public class AdminDAO {
	public static Connection getConnection()
	{
		
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","natesh","12345567");
		 System.out.println("connection successful");
	}
		catch(Exception e)
		{
			System.out.println("error connecting to Database"+e);
		}
		return con;
	}
	
//insert a new employee
	
public static int insertEmployee(Employee employee){
	int status=0;
	try
	{
		Connection con= AdminDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into employees values"+"(emp_seq.NEXTVAL,?,?,?, default)");
	//	ps.setInt(1, employee.getEmployee_id());
		ps.setString(1,employee.getEmployee_name());
		ps.setString(2,employee.getemployee_password());
		ps.setString(3,employee.getEmployee_designation());
	status=ps.executeUpdate();
	System.out.println("insert employee loop entered");
	con.close();
	}
	catch(Exception e)
	{
		System.out.println("Error inserting Employee details");
		e.printStackTrace();
		
	}return status;
}


public static List<Employee> getAllEmployees(){
	List <Employee> list = new ArrayList<Employee>();
	try{
		Connection con = AdminDAO.getConnection();
		PreparedStatement ps = con.prepareStatement("select employee_id, employee_name, designation from employees");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Employee allEmployees = new Employee();
			allEmployees.setEmployee_id(rs.getInt(1));
			allEmployees.setEmployee_name(rs.getString(2));
			allEmployees.setEmployee_designation(rs.getString(3));
			
			
			list.add(allEmployees);
		}
		con.close();
		
	}
	
	catch(Exception e){
		System.out.println(e);
	}
	return list;
}





//View the employee by id 

public static Employee getEmployeeById(long id)
{
	Employee employee_view_obj=new Employee();
	try
	{
		Connection  con= AdminDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from employees where employee_id=?");
		ps.setLong(1, id);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			employee_view_obj.setEmployee_id(rs.getInt(1));
			employee_view_obj.setEmployee_name(rs.getString(2));
			employee_view_obj.setemployee_password(rs.getString(3));
			employee_view_obj.setEmployee_designation(rs.getString(4));
			
		}
		con.close();
	}
	catch (Exception e){
		e.printStackTrace();
		}
	return employee_view_obj;
}



// Delete the employee

public static int deleteEmployee(long id)
{
	int status=0;
	try
	{
		Connection  con= AdminDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("" + "delete from employees where employee_id=?");
		ps.setLong(1, id);
		status=ps.executeUpdate();
		System.out.println("deleted successfully");
		con.close();
	}
	catch (Exception e){
		System.out.println("Unable to delete");
		e.printStackTrace();}
	return status;
}




public static int updateEmployee(Employee employee){  
    int status=0;  
    try{  
        Connection con=AdminDAO.getConnection();  
        PreparedStatement ps=con.prepareStatement("update employees set employee_name=?, designation=?, delete_status=default where employee_id=?");  
	       ps.setString(1,employee.getEmployee_name());
		//	ps.setString(2,employee.getemployee_password());
			ps.setString(2,employee.getEmployee_designation());
		 ps.setInt(3, employee.getEmployee_id());
	          
        status=ps.executeUpdate();  
        System.out.println("Update Successful");
        con.close();  
    }
    
    catch(Exception ex)
    {
    	System.out.println("Update error : "+ex);;
    	}  
      
    return status;  
} 


}
