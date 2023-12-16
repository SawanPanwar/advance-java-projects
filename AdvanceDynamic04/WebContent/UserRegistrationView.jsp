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
		<%
			String msg = (String) request.getAttribute("msg");
		%>
		<table>
			<tr>
				<%
					if (msg != null) {
				%>
				<%=msg%>
				<%
					}
				%>
			</tr>
			<tr>
				<th>First Name :</th>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<th>Last Name :</th>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<th>LoginId :</th>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<th>DOB :</th>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<th>Address :</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
<%@ include file="Footer.jsp"%>
</html>