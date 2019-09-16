package com.oms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oms.DAO.SupplierDAO;
import com.oms.DAO.SupplierListDAO;
import com.oms.model.Supplier;
import com.oms.model.SupplierList;

/**
 * Servlet implementation class SupplierList
 */
@WebServlet("/SupplierListServlet")
public class SupplierListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		String type_of_employee = request.getParameter("type_of_employee");
		System.out.println(type_of_employee);
		  String item_name= request.getParameter("item_name");
		  System.out.println(item_name);
		  
		  String emp_sid = request.getParameter("employee_id");
		  int emp_id = Integer.parseInt(emp_sid);
		  
		  
		
		List<SupplierList> list = SupplierListDAO.getSupplierList(item_name);
		 
		// HttpRequest.getRequestDispatcher("SupplierDashboard.jsp").forward(request, response);
		if(type_of_employee.equals("employee"))
		{
			request.setAttribute("employee_id", emp_id);
		 RequestDispatcher rd = request.getRequestDispatcher("SupplierListForEmployee.jsp");
			rd.include(request, response);
		}
		else {
			request.setAttribute("employee_id", emp_id);
			 RequestDispatcher rd = request.getRequestDispatcher("SupplierListForManager.jsp");
				rd.include(request, response);
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
