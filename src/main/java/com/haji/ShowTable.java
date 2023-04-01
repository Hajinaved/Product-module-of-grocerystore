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

public class ShowTable extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/grocery_store", "root",
					"system");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from product");

			RequestDispatcher rd = req.getRequestDispatcher("first.jsp");
			rd.include(req, resp);
			pw.print("<table>\r\n" + "		\r\n" + "		<tr>\r\n" + "			<td>ID</td>\r\n"
					+ "			<td>NAME</td>\r\n" + "			<td>CATEGORY</td>\r\n"
					+ "			<td>SUB_CATEGORY</td>\r\n" + "			<td>STOCK</td>\r\n"
					+ "			<td>PRICE</td>\r\n" + "			<td>EDIT</td>\r\n" + "			<td>DELETE</td>\r\n"
					+ "		</tr>\r\n");
			while (rs.next()) {
				String id=rs.getString(1);
				pw.print("<tr>");
				pw.print("<td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>  " + rs.getString(3)
						+ "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td>" + rs.getString(6)
						+ "</td>"
						+ "<td><a href='edit?id="+id+"'> EDIT IT </td>"
						+"<td><a href='del?id="+id+"'>DELETE</td>");
				pw.print("</tr>");
			}

			pw.print("\r\n" + "	</table>");

		}

		catch (Exception e) {
			pw.print("ERROR AYA");
		}
	}

}
