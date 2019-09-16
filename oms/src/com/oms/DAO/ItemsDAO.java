package com.oms.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oms.model.Employee;
import com.oms.model.Items;


public class ItemsDAO {

	
	
	public static List<Items> getPurchaseableItems(){
		List <Items> Itemlist = new ArrayList<Items>();
		try{
			Connection con = AdminDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select ITEM_ID, ITEM_NAME,ITEM_DESC from items");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Items items = new Items();
				items.setItem_id(rs.getInt(1)); // note: we need item id to pass it into show suppliers in PM and PE item selection
				items.setItem_name(rs.getString(2));
				items.setItem_description(rs.getString(3));
				//items.setItem_cost(rs.getInt(4));
			
				
				Itemlist.add(items);
			}
			con.close();
			
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		return Itemlist;
	}
}
