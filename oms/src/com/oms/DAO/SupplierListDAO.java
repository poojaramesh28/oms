package com.oms.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oms.DAO.SupplierListDAO;
import com.oms.model.Items;
import com.oms.model.Supplier;
import com.oms.model.SupplierList;

public class SupplierListDAO {
	public static Connection getConnection()
	{  Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			   System.out.println("Connecting to database...");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","natesh","12345567");  
		}
		
		catch(Exception e){
			System.out.println("connection error"+e);
		}
		return con;
	}
	

	public static List<SupplierList> getSupplierList(String item_name)
	{
		List<SupplierList> supplier_list=new ArrayList<SupplierList>();
		
		try
		{
			System.out.println(item_name);
			Connection con=SupplierListDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select supplier.supplier_id, supplier.supplier_name, items.item_cost, items.item_id from supplier inner join items on supplier.supplier_id = items.supplier_id where items.item_name = ?");
			ps.setString(1, item_name);  
			ResultSet rs=ps.executeQuery();
			System.out.println("query executed");
			while(rs.next()){
				
				SupplierList sl=new SupplierList();
				
				
				sl.setSupplierId(rs.getInt(1));
				sl.setSupplierName(rs.getString(2));
				sl.setItemCost(rs.getInt(3));
				sl.setItem_id(rs.getInt(4));
				
				
				supplier_list.add(sl);
				
				
				System.out.println("SupplierList result set entered");
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("error in fetching supplier list  ");
			e.printStackTrace();
			
			}
		return supplier_list;
				
		}
	
	
	
}
