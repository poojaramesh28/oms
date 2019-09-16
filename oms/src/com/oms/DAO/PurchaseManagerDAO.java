package com.oms.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oms.model.Items;

public class PurchaseManagerDAO {

	public static Connection getConnection()
	{
		Connection con=null;
		
		try{
		Class.forName("oracle.jdbc.driver.OracleDriver");//registering the driver
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","project_1","redhat");
		System.out.println("Hello");

		}
		catch(Exception e)
		{
			System.out.println("error connecting to Database");
		}
		return con;
	}
	
	public static List<Items> getAllItems() {
		List<Items> list = new ArrayList<Items>();
		try {
			Connection con = PurchaseManagerDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from items");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Items items = new Items();
				items.setItem_id(rs.getInt(1));
				items.setItem_name(rs.getString(2));
				items.setItem_description(rs.getString(3));
				items.setItem_cost(rs.getInt(4));
				

				list.add(items);
			}
			con.close();

		}

		catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}
}
