<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ReceiveServlet" method="post">
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
				<th></th>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>