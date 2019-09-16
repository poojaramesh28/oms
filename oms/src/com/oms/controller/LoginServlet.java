package com.oms.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oms.DAO.AdminDAO;
import com.oms.DAO.LoginDAO;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.getWriter(); //.append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String name = request.getParameter("user_name");
		String password = request.getParameter("user_password");

		// encrypt again and check if its matching

		/*
		 * Base64.Encoder encoder = Base64.getEncoder(); String normalString =
		 * password; String encodedString =
		 * encoder.encodeToString(normalString.getBytes
		 * (StandardCharsets.UTF_8)); String password1 = encodedString;
		 */

		if (LoginDAO.Validate(name, password)) {
			//HttpSession session = request.getSession();
			int delete_status = LoginDAO.getDeleteStatus(name,password);
			
			String designation = LoginDAO.getDesignation(name, password);
			
			int employee_id = LoginDAO.getEmployeeId(name, password);
			System.out.println(employee_id);
			
			
			
			
			System.out.println(designation);
		//	session.setAttribute("user_name", name);

			if(delete_status == 1){
			
			if (designation.equals("Admin")) {
				
				//out.print("Admin loggined");
				RequestDispatcher rd = request
						.getRequestDispatcher("admin.jsp");
				rd.include(request, response);
			}

			if (designation.equals("PurchaseEmployee")) {
				request.setAttribute("employee_id",employee_id);
				request.getRequestDispatcher("EmployeeDashboard.jsp").forward(request, response);
				
				
				
				//RequestDispatcher rd = request.getRequestDispatcher("PurchaseEmployeeDashboard.jsp");
			//	rd.include(request, response);
			}

			if (designation.equals("PurchaseManager")) {
				request.setAttribute("employee_id",employee_id);
				request.getRequestDispatcher("PurchaseManagerDashboard.jsp").forward(request, response);
			}

			if (designation.equals("QualityControl")) {
				RequestDispatcher rd = request
						.getRequestDispatcher("QualityControlDashboard.jsp");
				rd.include(request, response);
			}

			if (designation.equals("Supplier")) {
				RequestDispatcher rd = request
						.getRequestDispatcher("/jsp/SupplierDashboard.jsp");
				rd.include(request, response);
			}

			// HttpSession session = request.getSession();

			// reuse existing session if exists or create one
			// session.setAttribute("user_name", name);
			// RequestDispatcher rd =
			// request.getRequestDispatcher("ViewCustomers.jsp");
			// rd.include(request, response);
			// out.print("   Login successfull");
		}
			else{
				
				out.print("User does not exist");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				
			}	
		}

		else {

			out.print("user name or password incorrect");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);

		}

		out.close();

	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

}
