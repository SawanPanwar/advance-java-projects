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
		<br> <br> <br> <br>
		<div align="center">
			<table>
				<h1 align="center" style="margin-bottom: -15; color: navy">Login</h1>
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
					<th align="left">Login ID :</th>
					<td align="center"><input type="text" name="loginId"></td>
				</tr>
				<tr>
					<th align="left">Password :</th>
					<td align="center"><input type="text" name="password"></td>
				</tr>

				<tr>
					<th></th>
					<td></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" name="operation" value="SignIn">
						<input type="submit" name="operation" value="SignUp"></td>
				</tr>
			</table>
		</div>
		<br> <br> <br> <br> <br> <br> <br>
		<br> <br> <input type="hidden" name="uri" value="<%=uri%>">
	</form>
	<%@ include file="Footer.jsp"%>
</body>
</html>