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
	<form action="LoginCtl" method="post">
		<div align="center">
			<%
				String msg = (String) request.getAttribute("msg");
			%>
			<h1>Login</h1>
			<%
				if (msg != null) {
			%>
			<h3>
				<font color="red"><%=msg%></font>
			</h3>
			<%
				}
			%>
			<table>
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
					<td><input type="submit" value="signIn"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>