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

	<%
		String success = (String) request.getAttribute("success");
		String error = (String) request.getAttribute("error");
	%>
	<div align="center">
		<h1>User Registration</h1>
		<%
			if (success != null) {
		%>
		<h3>
			<font color="green"><%=success%></font>
		</h3>

		<%
			}
		%>
		<%
			if (error != null) {
		%>
		<h3>
			<font color="red"><%=error%></font>
		</h3>

		<%
			}
		%>
		<form action="UserRegistrationCtl" method="post">
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
					<th>Login ID:</th>
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
		</form>
	</div>
</body>
</html>