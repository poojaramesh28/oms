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
 * Servlet implementation class SupplierAddItems
 */
@WebServlet("/SupplierAddItems")
public class SupplierAddItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierAddItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		response.getWriter();
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
	  // no item id as its a sequence
		
		String item_name = request.getParameter("item_name");
		String item_description = request.getParameter("item_description");
		
		/*String item_cost_String = request.getParameter("item_cost");
		int item_cost = Integer.parseInt(item_cost_String);
		
		String item_quantity_String = request.getParameter("item_quantity");
		int item_quantity = Integer.parseInt(item_quantity_String);
		
		
		String item_status = request.getParameter("item_status");
		
		String supplier_id = request.getParameter("supplier_id");
		*/

		Items items = new Items();
		//employee.setEmployee_id(employee_id);
		//items.setItem_id(item_id);
		items.setItem_name(item_name);
		items.setItem_description(item_description);
		/*items.setItem_cost(item_cost);
		items.setItem_quantity(item_quantity);
		items.setStatus(item_status);
		items.setSupplier_id(supplier_id);
		
*/

		int status = SupplierDAO.insertItem(items);
		if (status > 0) {
			pw.print("<p>Item inserted Successfully </p>");
			//request.getRequestDispatcher("manager.jsp").include(request, response);
		} else {
			pw.print("<p> Unable to Insert item </p>");
		}
		pw.close();


response.sendRedirect("Admin.jsp"); // assunming admin.jsp
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
