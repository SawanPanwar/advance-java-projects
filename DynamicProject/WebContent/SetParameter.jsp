<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="SetParameter.jsp" method="post">

		<jsp:useBean id="bean" class="in.co.rays.bean.UserBean"
			scope="request"></jsp:useBean>

		<jsp:setProperty property="*" name="bean" />
		<table>
			<tr>
				<th>First Name</th>
				<td><input type="text" name="firstName" value=""></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" name="lastName" value=""></td>
			</tr>
			<tr>
				<th>Login Id</th>
				<td><input type="text" name="loginId" value=""></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td><input type="submit" name="operation" value="Add"></td>
			</tr>
		</table>
		<%
			String op = request.getParameter("operation");
			if (op != null) {
		%>
		<h3><%=bean.getFirstName()%></h3>
		<h3><%=bean.getLastName()%></h3>
		<h3><%=bean.getLoginId()%></h3>
		<h3><%=bean.getPassword()%></h3>
		<%
			}
		%>
	</form>

</body>
</html>