<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The test jdbc</title>
</head>
<body>
	<sql:setDataSource var="db" driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/grocery_store" user="root"
		password="system" />
	<sql:query var="rs" dataSource="${db}">select * from product; </sql:query>
	<table>
		<tr>
			<td>ID</td>
			<td>NAME</td>
			<td>CATEGORY</td>
			<td>SUB_CATEGORY</td>
			<td>STOCK</td>
			<td>PRICE</td>
		</tr>
		<c:forEach var="row" items="${rs.rows}">
			<tr>
				<td><c:out value="${row.id}"></c:out></td>

				<td><c:out value="${row.name}"></c:out></td>

				<td><c:out value="${row.category}"></c:out></td>

				<td><c:out value="${row.subcategory}"></c:out></td>

				<td><c:out value="${row.stock}"></c:out></td>

				<td><c:out value="${row.price}"></c:out></td>
			</tr>

		</c:forEach>
	</table>
</body>
</html>