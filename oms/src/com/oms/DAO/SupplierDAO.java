package com.oms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oms.model.Employee;
import com.oms.model.Items;

public class SupplierDAO {
	
	public static boolean Validate(String supplier_name, String supplier_pass)
	{
		boolean status = false;
		try{
			Connection con = AdminDAO.getConnection();
		
	        
			PreparedStatement ps = con.prepareStatement("select * from supplier where SUPPLIER_NAME =? and SUPPLIER_PASS= ?");
			ps.setString(1, supplier_name);
			ps.setString(2, supplier_pass);
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
			}
		catch(Exception e){
			System.out.println(e);
		}
		
		return status;
	}
	

	public static int insertItem(Items item){
		int status=0;
		try
		{
			Connection con= AdminDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into items values"+"(item_seq.NEXTVAL,?,?)");

			ps.setString(1, item.getItem_name());
			ps.setString(2, item.getItem_description());
		/*	ps.setInt(3, item.getItem_cost());
			ps.setInt(4, item.getItem_quantity());
			ps.setString(5, item.getItemStatus());
			ps.setString(6, item.getSupplier_id());
			*/
			
			
		status=ps.executeUpdate();
		con.close();
		}
		catch(Exception e)
		{
			System.out.println("Error inserting item details");
			e.printStackTrace();
			
		}return status;
	}
	

	
	public static List<Items> getAllItems(){
		List <Items> itemList = new ArrayList<Items>();
		try{
			Connection con = AdminDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select item_id, ITEM_NAME, ITEM_DESC  from items");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Items item = new Items();
				
				item.setItem_id(rs.getInt(1));
				item.setItem_name(rs.getString(2));
				item.setItem_description(rs.getString(3));
			/*	item.setItem_cost(rs.getInt(4));
				item.setItem_quantity(rs.getInt(5));
				item.setStatus(rs.getString(6));
				*/
				
				itemList.add(item);
			}
			con.close();
			
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		return itemList;
	}

	
	
	
	
	
	
	
	public static Items getItemById(long item_id) {
		Items item_view_obj=new Items();
		try
		{
			Connection  con= AdminDAO.getConnection();
			PreparedStatement ps=con.prepareStatement("select ITEM_NAME, ITEM_DESC from items where item_id=?");
			ps.setLong(1, item_id);
			
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				item_view_obj.setItem_name(rs.getString(1));
				item_view_obj.setItem_description(rs.getString(2));
				/*item_view_obj.setItem_cost(rs.getInt(3));
				item_view_obj.setItem_quantity(rs.getInt(4));
				item_view_obj.setStatus(rs.getString(5));
				item_view_obj.setSupplier_id(rs.getString(6));*/
				
				
				
			}
			con.close();
		}
		catch (Exception e){
			e.printStackTrace();
			}
		return item_view_obj;
	}
	
	
	
	

public static int updateItems(Items item, long item_id){  
    int status=0;  
    try{  
        Connection con=AdminDAO.getConnection();  
        PreparedStatement ps=con.prepareStatement("update items set item_name=?,item_desc=? where item_id=?");  
	       ps.setString(1, item.getItem_name());
			ps.setString(2,item.getItem_description());
			/*ps.setInt(3, item.getItem_cost());
			ps.setInt(4, item.getItem_quantity());
		 ps.setString(5, item.getItemStatus());
		 ps.setLong(6, item_id);*/  
		 
	          
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


public static int deleteItem(long item_id)
{
	int status=0;
	try
	{
		Connection  con= AdminDAO.getConnection();
		PreparedStatement ps=con.prepareStatement("" + "delete from items where item_id=?");
		ps.setLong(1, item_id);
		status=ps.executeUpdate();
		System.out.println("deleted successfully");
		con.close();
	}
	catch (Exception e){
		System.out.println("Unable to delete item");
		e.printStackTrace();}
	return status;
}


	
	
	
}
