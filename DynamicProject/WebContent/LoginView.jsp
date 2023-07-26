<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginCtl" method="post">

		<%@ include file="Header.jsp"%>

		<%
			String msg = (String) request.getAttribute("msg");
			String uri = (String) request.getAttribute("uri");
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
				<th>Login ID :</th>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="text" name="password"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" name="operation" value="SignIn">
					<input type="submit" name="operation" value="SignUp"></td>
			</tr>
		</table>
		<input type="hidden" name="uri" value="<%=uri%>">
	</form>
</body>
</html>