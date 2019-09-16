package com.oms.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oms.controller.*;
import com.oms.DAO.*;
import com.oms.model.*;

public class OrderDAO {
	public static List<Orders> getOrderedItems(){
		List <Orders> Orderlist = new ArrayList<Orders>();
		try{
			Connection con = AdminDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from orders");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Orders order = new Orders();
				order.setOrder_id(rs.getInt(1)); // note: we need item id to pass it into show suppliers in PM and PE item selection
				order.setItem_id(rs.getInt(2)); 
				order.setSupplier_id(rs.getInt(3)); 
				order.setOrder_quantity(rs.getInt(4)); 
				order.setOrder_cost(rs.getInt(5)); 
				order.setOrder_status(rs.getString(6));
				order.setEmployee_id(rs.getInt(7));
				order.setComments(rs.getString(8));
				order.setOrder_date(rs.getString(9));
				
				Orderlist.add(order);
			}
			con.close();
			
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		return Orderlist;
	}
	
	

public static void OrderEmployee(Orders order)
{
	try
	{
		
		Connection  con= AdminDAO.getConnection();
		//CallableStatement stmt=con.prepareCall("{call mgr_order_status(?,?,?,?,?)}");
		//stmt.execute();
		PreparedStatement ps=con.prepareStatement("call emp_order_status(?,?,?,?,?)");
		ps.setInt(1, order.getItem_id());
		ps.setInt(2, order.getSupplier_id());
		ps.setInt(3, order.getOrder_quantity());
		ps.setInt(4, order.getOrder_cost());
		ps.setInt(5, order.getEmployee_id());
		
		
		
		ps.executeUpdate();
		System.out.println(" manager procedure Procedure Executed");
		con.close();
	}
	catch (Exception e){
		System.out.println("Unable to update");
		e.printStackTrace();
		}
	
}


public static void OrderPurchaseManager(Orders order)
{
	
	try
	{
		
		Connection  con= AdminDAO.getConnection();
		//CallableStatement stmt=con.prepareCall("{call mgr_order_status(?,?,?,?,?)}");
		//stmt.execute();
		PreparedStatement ps=con.prepareStatement("call mgr_order_status(?,?,?,?,?)");
		ps.setInt(1, order.getItem_id());
		ps.setInt(2, order.getSupplier_id());
		ps.setInt(3, order.getOrder_quantity());
		ps.setInt(4, order.getOrder_cost());
		ps.setInt(5, order.getEmployee_id());
		
		
		
		ps.executeUpdate();
		System.out.println(" manager procedure Procedure Executed");
		con.close();
	}
	catch (Exception e){
		System.out.println("Unable to update");
		e.printStackTrace();
		}
	
}	
	
	
	
	
}
