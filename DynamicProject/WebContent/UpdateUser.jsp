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


	<%
		String msg = (String) request.getAttribute("msg");
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>
	<form action="UserCtl" method="post">
		<%@ include file="Header.jsp"%>
		<br> <br>
		<div align="center">
			<h1 align="center" style="margin-bottom: -15; color: navy">
				Update User</h1>
			<table>
				<tr>
					<td><input type="hidden" name="id" value="<%=bean.getId()%>"></td>
				</tr>

				<tr>
					<th>First Name :</th>
					<td><input type="text" name="firstName"
						value="<%=bean.getFirstName()%>"></td>
				</tr>
				<tr>
					<th>Last Name :</th>
					<td><input type="text" name="lastName"
						value="<%=bean.getLastName()%>"></td>
				</tr>
				<tr>
					<th>Login ID :</th>
					<td><input type="text" name="loginId"
						value="<%=bean.getLoginId()%>"></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input type="text" name="password"
						value="<%=bean.getPassword()%>"></td>
				</tr>
				<tr>
					<th>DOB :</th>
					<td><input type="date" name="dob" value="<%=bean.getDob()%>"></td>
				</tr>
				<tr>
					<th>Address :</th>
					<td><input type="text" name="address"
						value="<%=bean.getAddress()%>"></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td colspan="2"><input type="submit" name="operation" value="update">  <input
						type="submit" name="operation" value="list"></td>
				</tr>
			</table>
		</div>
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <br> <br>
	</form>

	<%@ include file="Footer.jsp"%>

</body>
</html>