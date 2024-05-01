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
	%>
	<%@ include file="Header.jsp"%>
	<form action="LoginCtl" method="post">
		<%
			if (msg != null) {
		%>
		<h4><%=msg%></h4>
		<%
			}
		%>
		<table>
			<tr>
				<th>LoginId:</th>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="signIn"><input
					type="submit" name="operation" value="signUp"></td>
			</tr>
		</table>
	</form>

</body>
</html>