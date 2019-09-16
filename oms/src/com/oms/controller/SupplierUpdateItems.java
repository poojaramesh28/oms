package com.oms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oms.DAO.AdminDAO;
import com.oms.DAO.SupplierDAO;
import com.oms.model.Employee;
import com.oms.model.Items;

/**
 * Servlet implementation class SupplierUpdateItems
 */
@WebServlet("/SupplierUpdateItems")
public class SupplierUpdateItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierUpdateItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String item_id_string = request.getParameter("item_id");
		long item_id = Integer.parseInt(item_id_string);
		
		String item_cost_String = request.getParameter("item_cost");
		int item_cost = Integer.parseInt(item_cost_String);
		String item_name = request.getParameter("item_name");
		String item_description = request.getParameter("item_description");
		String item_status = request.getParameter("item_status");
		
		String item_quantity_string = request.getParameter("item_quantity");
		int item_quantity = Integer.parseInt(item_quantity_string);

		Items item = new Items();
		item.setItem_cost(item_cost);
		item.setItem_name(item_name);
		item.setItem_description(item_description);
		item.setStatus(item_status);
		item.setItem_quantity(item_quantity);
		

		int status = SupplierDAO.updateItems(item, item_id);
		if (status > 0) {
			out.print("<p> Record updated Successfully </p>");
			request.getRequestDispatcher("manager.jsp").include(request, response);
		} else {
			out.print("<p> Unable to update Record </p>");
		}
		out.close();
       
	}

		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
