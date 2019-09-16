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

import com.oms.DAO.LoginDAO;
import com.oms.DAO.SupplierDAO;

/**
 * Servlet implementation class SupplierLogin
 */
@WebServlet("/SupplierLogin")
public class SupplierLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String supplier_name = request.getParameter("supplier_name");
		String supplier_password = request.getParameter("supplier_password");
		System.out.println(supplier_name+" "+supplier_password);
		
		if(SupplierDAO.Validate(supplier_name,supplier_password)){
			HttpSession session = request.getSession();
			
			session.setAttribute("supplier_name", supplier_name);
			session.setAttribute("supplier_password", supplier_password);
			out.print("successful supplier login");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/SupplierDashboard.jsp");
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
