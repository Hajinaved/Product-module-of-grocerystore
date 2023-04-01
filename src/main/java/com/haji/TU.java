package com.haji;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TU extends HttpServlet {
		
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			String id = req.getParameter("id");
			String name= req.getParameter("product-name");
			String cat=req.getParameter("category");
			String sub=req.getParameter("sub");
			String stock=req.getParameter("stock");
			String price=req.getParameter("price");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery_store","root","system");
				PreparedStatement ps =conn.prepareStatement("update product set name=?,category=?,subcategory=?,stock=?,price=? where id=?; ");
				ps.setString(1, name);
				ps.setString(2,cat );
				ps.setString(3,sub);
				ps.setString(4,stock);
				ps.setString(5,price);
				ps.setString(6,id);
				ps.executeUpdate();
				resp.sendRedirect("st");
				
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}

}
