package com.haji;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Edit_record extends HttpServlet {
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			resp.setContentType("text/html");
			PrintWriter pw =resp.getWriter();
			String s= req.getParameter("id");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery_store", "root",
						"system");
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select * from product");
				while(rs.next()) {
					if(rs.getString(1).equals(s)) {
						pw.print(rs.getString(1)+"   "+rs.getString(2));
						break;
					}
				}
				
				req.setAttribute("c1",rs.getString(1));
				req.setAttribute("c2",rs.getString(2));
				req.setAttribute("c3",rs.getString(3));
				req.setAttribute("c4",rs.getString(4));
				req.setAttribute("c5",rs.getString(5));
				req.setAttribute("c6",rs.getString(6));
				RequestDispatcher rd = req.getRequestDispatcher("AP1.jsp");
				rd.forward(req, resp);
				
				
				
			}
	
			catch(Exception e) {
				e.printStackTrace();
			}
	}

}
