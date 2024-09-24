<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="UserRegistrationCtl" method="post">
		<div align="center">
			<%
				String msg = (String) request.getAttribute("msg");
			%>
			<h1>User Registration</h1>
			<%
				if (msg != null) {
			%>
			<h3>
				<font color="green"><%=msg%></font>
			</h3>
			<%
				}
			%>
			<table>
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<th>Login Id:</th>
					<td><input type="text" name="loginId"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="text" name="password"></td>
				</tr>
				<tr>
					<th>DOB:</th>
					<td><input type="date" name="dob" style="width: 98%"></td>
				</tr>
				<tr>
					<th>Address:</th>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" value="signUp"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>