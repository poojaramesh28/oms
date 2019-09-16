package com.oms.DAO;  //data access object
//we are using diff modules bcoz its an ex of mvc(model view controller)

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PendingDao{
public static List<PendingDao> getAllPendingEmployees()
{
List<Pending> list = new ArrayList<PendingDao>();
	try{
		Connection con=CustomerDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("select * from employees");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Pending c=new Pending();
			c.setId(rs.getInt(1));
			c.setName(rs.getString(2));
			c.setOrderId(rs.getInt(3));
			c.setOrderName(rs.getInt(4));
			c.setOrderQuantity(rs.getInt(5));
			c.setItemName(rs.getString(6));
			c.setStatus(rs.getInt(7));
          list.add(c);
		} con.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
	
public static Connection getConnection()  //returns connection
	{ Connection con=null;
	
		try
		{
			//load to driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
		   //create the connection object
			System.out.println("Connecting to database...");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","","");  
		}
		catch(Exception e){
			System.out.println("Error in connection"+e);
		}
		return con;
	}
	
	
	public static int acceptedOrder(Employee c)  //int bcoz of dml statement
	{
		int status=0;
		try
		{
			Connection con=OrderDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into orders values"+"(order_id.NEXTVAL,?,?,?,?,?,?)");  //preparedst for getting ip during runtime..?-placeholder
			ps.setString(1,c.getOrderName());
		    ps.setString(2,c.getEmployeeId());
		    ps.setString(3,c.getOrderCost());
		    ps.setString(4,c.getOrderQuantity());
		    ps.setString(5,c.getSupplierItemId());
		    ps.setString(6,c.getOrderDate());
		    
		    
		    status=ps.executeUpdate();
		    con.close();
		   
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	
	
	public static int rejectedOrder(long id)  //int bcoz of dml statement
	{ int status=0;
		try
		{
			Connection con=OrderDAO.getConnection();
			PreparedStatement ps=con.prepareStatement(" " +"delete from temp_order where id=?");  //preparedst for getting ip during runtime..?-placeholder
			ps.setLong(1, id);
		status=ps.executeUpdate();	
		con.close();
		}
		
		catch(Exception e){
			e.printStackTrace();

		
	}return status;
	

	
	}
	}
	
	

