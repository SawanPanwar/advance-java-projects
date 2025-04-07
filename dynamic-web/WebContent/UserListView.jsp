<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>
	<form>
		<div align="center">
			<h1>User List</h1>
		</div>
		<table border="1%" style="width: 100%">
			<tr>
				<th>Select</th>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Login ID</th>
				<th>Password</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Edit</th>
			</tr>
			<%
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>
			<tr align="center">
				<td><input type="checkbox"></td>
				<td><%=bean.getId()%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=bean.getAddress()%></td>
				<td><a href="UserCtl">edit</a></td>
			</tr>
			<%
				}
			%>

		</table>
	</form>
</body>
</html>