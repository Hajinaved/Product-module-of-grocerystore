package com.haji;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddUser extends HttpServlet {	

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw= response.getWriter();
		String name= request.getParameter("product-name");
		String cat=request.getParameter("category");
		String sub=request.getParameter("sub");
		String stock=request.getParameter("stock");
		String price=request.getParameter("price");
		if(name.isEmpty()||cat==null||sub==null||stock.isEmpty()||price.isEmpty()) {//this check is not working
			RequestDispatcher rd = request.getRequestDispatcher("AdU.html");
			rd.forward(request, response);
			pw.append("ENTER CORRECT DETAILS");
			
		}
		else {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery_store","root","system");
			PreparedStatement ps = conn.prepareStatement("insert into product values(?,?,?,?,?,?);");
			ps.setString(1,"0");
			ps.setString(2,name);
			ps.setString(3,cat);
			ps.setString(4, sub);
			ps.setString(5,stock);
			ps.setString(6,price);
			
			ps.executeUpdate();
			response.sendRedirect("st");
		}
		catch(Exception e) {
			pw.print("error aaya");
			e.printStackTrace();
		}
		
		
				
		}
	}}
		

