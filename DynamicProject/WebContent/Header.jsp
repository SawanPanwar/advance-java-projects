<%@page import="in.co.rays.bean.UserBean"%>
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
		UserBean bean1 = (UserBean) session.getAttribute("user");
	%>

	<table width="100%" border="0">
		<tr>
			<td width="90%"><a href="WelcomeCtl"><b>Welcome</b></a> | <%
				if (bean1 != null) {
			%> <a href="LoginCtl?operation=logout"><b>Logout</b></a> <%
 	} else {
 %><a href="LoginCtl"><b>Login</b></a> <%
 	}
 %></td>
			<td rowspan="2">
				<h1 align="Right">
					<img src="img/customLogo.jpg" width="318" height="90">
				</h1>
			</td>
		</tr>
		<tr>
			<td>
				<%
					if (bean1 != null) {
				%>
				<h3>
					Hii,
					<%=bean1.getFirstName()%></h3> <a href="UserCtl"><b>Add User</b></a> | <a
				href="UserListCtl.do"><b>User List</b></a> <%
 	} else {
 %>
				<h3>Hi, Guest</h3> <%
 	}
 %>
			</td>
		</tr>
	</table>
	<hr>

</body>
</html>