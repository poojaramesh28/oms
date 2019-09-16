package com.oms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Supp_order_TestDAO {


	public static String getItemName(String item_name){
		 
	String name = null;
	System.out.println(item_name+" DAO");

		 try {

		  Connection con = AdminDAO.getConnection();
		  PreparedStatement ps = con.prepareStatement("select item_name from items where item_name=? ");
		  ps.setString(1, item_name);
		  
		  ResultSet rs = ps.executeQuery();

		  while (rs.next()) {
		   name = rs.getString(1);

		  }

		 } catch (Exception e) {
		  System.out.println("Error fetching item name : " + e);
		 }
		 if(name==null)
		 {
			 return "different";
		 }
		 else {
			 return name;
		 }
		}
	
	
	
	
	public static int getItemID(String name)
	{
		
		int id = 0;
		System.out.println(id+" DAO");

			 try {

			  Connection con = AdminDAO.getConnection();
			  PreparedStatement ps = con.prepareStatement("select item_id from items where item_name=?");
			  ps.setString(1, name);
			  
			  ResultSet rs = ps.executeQuery();

			  while (rs.next()) {
			   id = rs.getInt(1);

			  }
			   
			  
			  

			 } catch (Exception e) {
			  System.out.println("Error fetching item name : " + e);
			 }
			 System.out.println("DAO id : "+id);
			 return id;


	}



	public static int insertNewItem(String item_name)
	{
		int return_id=0;
	
		System.out.println(item_name+" DAO insert");

			 try {

			  Connection con = AdminDAO.getConnection();
			  System.out.println(item_name+" is being passed to insert new item (different)");
			  PreparedStatement ps = con.prepareStatement(" insert into items values (item_seq.nextval,?,'pinky')");
			  ps.setString(1, item_name);
			   ps.executeQuery();
			  con.prepareStatement("commit");
			 
			  ps.executeQuery();
			  
			  //get the inserted item id
			  
		ps =  con.prepareStatement("select item_id from items where item_name=?");
			  ps.setString(1, item_name);
			  ResultSet rs=ps.executeQuery();
			  while(rs.next())
			  {
				  return_id = rs.getInt(1);
			  }
				 System.out.println(return_id); 
			 
			 }
			 catch (Exception e) {
			  System.out.println("Error inserting item : " + e);
			 }
			 return return_id;
		
		
		
		
		}
	
	
	
	
	public static void insertIntoSupp_order(int item_id)
	{
	
		
		 try {

			  Connection con = AdminDAO.getConnection();
			  PreparedStatement ps = con.prepareStatement(" insert into supp_items values (supp_item_seq.nextval,?,2000,105,8)");
			  ps.setInt(1, item_id);
			  ResultSet rs = ps.executeQuery();
			System.out.println("inserted into supp_items");
	}
		 
		 catch (Exception e) {
			  System.out.println("Error inserting item : " + e);
			 }
	}
	
	
	
	
	
	
	
	
	
	public static void setItemID(int id)
	{
		 try {

			  Connection con = AdminDAO.getConnection();
			  PreparedStatement ps = con.prepareStatement(" insert into supp_items values (supp_item_seq.nextval,?,2000,200,50)");
			  ps.setInt(1, id);
			  
			  ResultSet rs = ps.executeQuery();
			
System.out.println("Inserted");
			 }
			 catch (Exception e) {
			  System.out.println("Error fetching  : " + e);
			 }
			
		
		
	}
	
}
