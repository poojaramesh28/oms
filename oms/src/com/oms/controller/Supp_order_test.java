package com.oms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oms.DAO.Supp_order_TestDAO;

/**
 * Servlet implementation class Supp_order_test
 */
@WebServlet("/Supp_order_test")
public class Supp_order_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supp_order_test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String item_name = "green";
		int id=0;
		System.out.println(item_name);
		
		String check_name = Supp_order_TestDAO.getItemName(item_name);
		System.out.println(check_name);
		System.out.println(check_name+" back to servlet");
		
		
		
		
		if(check_name.equals(item_name)) {
			id = Supp_order_TestDAO.getItemID(check_name);
			System.out.println("same name");
			System.out.println(id);
			System.out.println("Hello");
			Supp_order_TestDAO.setItemID(id);
		}
		else if(check_name.equals("different"))
		{
			System.out.println("New item function");
			int item_id = Supp_order_TestDAO.insertNewItem(item_name);
			System.out.println(item_id);
			Supp_order_TestDAO.insertIntoSupp_order(item_id);
			System.out.println("back to servlet after inserting");
		
			
		}
		else {
			System.out.println("final else loop");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
