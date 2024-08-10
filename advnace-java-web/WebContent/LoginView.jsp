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
			<h1>Login</h1>
			<%
				String msg = (String) request.getAttribute("msg");
				String uri = (String) request.getAttribute("uri");
				String loginId = (String) request.getAttribute("loginId");
				String password = (String) request.getAttribute("password");
			%>
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
					<th>LoginID:</th>
					<td><input type="text" name="loginId"></td>
					<td><font color="red"> <%=(loginId != null) ? loginId : ""%>
					</font></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="text" name="password"></td>
					<td><font color="red"> <%=(password != null) ? password : ""%>
					</font></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="operation" value="signIn">
						<input type="submit" name="operation" value="signUp"></td>
				</tr>
			</table>
		</div>
		<input type="hidden" name="uri" value="<%=uri%>">
	</form>
</body>
</html>