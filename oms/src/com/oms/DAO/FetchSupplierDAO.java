package com.oms.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oms.model.Employee;
import com.oms.model.SupItems;
import com.oms.model.Supplier;

public class FetchSupplierDAO {

	public static Connection getConnection() {

		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "natesh",
					"12345567");
			System.out.println("connection successful");
		} catch (Exception e) {
			System.out.println("error connecting to Database" + e);
		}
		return con;
	}

	public static List<SupItems> getSupplierById(int id) {
		ResultSet rs;
	
		System.out.println(id);
		List<SupItems> sup = new ArrayList<SupItems>();
		try {
			Connection con = FetchSupplierDAO.getConnection();
			System.out.println(id);
				PreparedStatement ps = con.prepareStatement(" select supplier_name from supplier join supp_items on supplier.supplier_id = supp_items.supplier_id where item_id = ?");
				ps.setLong(1, id);
				rs = ps.executeQuery();
				//SupItems supplier_view_obj = new SupItems();

				while (rs.next()) {
					System.out.println("stop here");
					SupItems a=new SupItems();
					a.setSupplier_name(rs.getString(1));
					sup.add(a);
					System.out.println(rs.getString(1));
					
				}
				//sup.add(supplier_view_obj);
				for(SupItems i:sup){
					System.out.println(i.getSupplier_name());
				}
				System.out.println(sup);
				System.out.println("above is dao");
				
			}
		 catch (Exception e) {
			e.printStackTrace();
		}
		return sup;
	}

}
