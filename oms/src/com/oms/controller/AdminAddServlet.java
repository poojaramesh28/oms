package com.oms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oms.DAO.AdminDAO;
import com.oms.model.Employee;


/**
 * Servlet implementation class AdminAddServlet
 */
@WebServlet("/AdminAddServlet")
public class AdminAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.getWriter().append("hi");
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		
		
		//String employee_idString = request.getParameter("employee_id");
		//int employee_id = Integer.parseInt(employee_idString);
		String employee_name = request.getParameter("employee_name");
		String employee_password = request.getParameter("employee_password");
		String employee_designation = request.getParameter("employee_designation");

		Employee employee = new Employee();
		//employee.setEmployee_id(employee_id);
		employee.setEmployee_name(employee_name);
		employee.setemployee_password(employee_password);
		employee.setEmployee_designation(employee_designation);
		System.out.println(employee_name+" "+employee_password+" "+employee_designation);

		int status = AdminDAO.insertEmployee(employee);
		if (status > 0) {
			pw.print("<p> Record Saved Successfully </p>");
			//request.getRequestDispatcher("manager.jsp").include(request, response);
		} else {
			pw.print("<p> Unable to Save Record </p>");
		}
		pw.close();


response.sendRedirect("Admin.jsp"); // assunming admin.jsp
		
		
	}

}
