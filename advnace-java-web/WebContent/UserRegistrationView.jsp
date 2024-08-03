<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UserRegistrationCtl" method="post">
		<%
			String msg = (String) request.getAttribute("msg");
		%>
		<table>
			<%
				if (msg != null) {
			%>
			<%=msg%>
			<%
				}
			%>
			<tr>
				<th>FirstName:</th>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<th>LastName:</th>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<th>LoginID:</th>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<th>DOB:</th>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<th>Address:</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="signUp"></td>
			</tr>
		</table>
	</form>
</body>
</html>