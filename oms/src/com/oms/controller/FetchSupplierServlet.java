package com.oms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oms.DAO.AdminDAO;
import com.oms.DAO.FetchSupplierDAO;
import com.oms.model.SupItems;
import com.oms.model.Supplier;

@WebServlet("/FetchSupplierServlet")
public class FetchSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FetchSupplierServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<SupItems> sup = new ArrayList<SupItems>();
		

		PrintWriter out = response.getWriter();
		//int item_sid = Integer.parseInt(request.getParameter("item_id"));
		int item_sid = 4037;
		System.out.println(item_sid);
		sup = FetchSupplierDAO.getSupplierById(item_sid);
		String ot = "";
		for (SupItems i : sup) {
			System.out.println(i.getSupplier_name());
			ot += "<option value='demo'>" + i.getSupplier_name() + "</option>";

		}
		out.print(ot);

		System.out.println("stop");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
