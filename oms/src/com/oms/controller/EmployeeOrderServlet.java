package com.oms.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oms.controller.*;
import com.oms.DAO.*;
import com.oms.model.*;



/**
 * Servlet implementation class EmployeeOrderServlet
 */
@WebServlet("/EmployeeOrderServlet")
public class EmployeeOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
		
        String item_sid = request.getParameter("item_id");
        int item_id = Integer.parseInt(item_sid);
        		

        String supplier_sid = request.getParameter("supplier_id");
        int supplier_id = Integer.parseInt(supplier_sid);
		
       
		
		String order_s_quantity = request.getParameter("item_quantity");
		int order_quantity = Integer.parseInt(order_s_quantity);
		
		
		String order_s_price = request.getParameter("item_cost");
		int order_price = Integer.parseInt(order_s_price); //item cost
		
		
		String order_status = request.getParameter("order_status");
		
		String employee_sid= request.getParameter("employee_id");
		int employee_id= Integer.parseInt(employee_sid);
		

		Orders order = new Orders();
		order.setItem_id(item_id);
		order.setSupplier_id(supplier_id);
		order.setEmployee_id(employee_id);
		order.setOrder_quantity(order_quantity);
		order.setOrder_cost(order_price);
	
		
		

		
		 OrderDAO.OrderEmployee(order);
		
			out.print("<p> Record updated Successfully </p>");
		

	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);

	}

}
