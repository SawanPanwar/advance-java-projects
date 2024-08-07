<%@page import="in.co.rays.bean.UserBean"%>
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
		List nextList = (List) request.getAttribute("nextList");
		int pageNo = (int) request.getAttribute("pageNo");
	%>
	<%@ include file="Header.jsp"%>
	<form action="UserListCtl" method="post">
		<div align="center">
			<h1>User List</h1>
		</div>
		<table>
			<tr>
				<td><input type="text" name="firstName"></td>
				<td><input type="date" name="dob"></td>
				<td><input type="submit" name="operation" value="search"></td>
			</tr>
		</table>
		<br>
		<table border="1%" style="width: 100%">
			<tr>
				<th>Id</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginId</th>
				<th>Password</th>
				<th>DOB</th>
				<th>Address</th>
			</tr>
			<%
				Iterator it = list.iterator();
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>
			<tr>
				<td align="center"><%=bean.getId()%></td>
				<td align="center"><%=bean.getFirstName()%></td>
				<td align="center"><%=bean.getLastName()%></td>
				<td align="center"><%=bean.getLoginId()%></td>
				<td align="center"><%=bean.getPassword()%></td>
				<td align="center"><%=bean.getDob()%></td>
				<td align="center"><%=bean.getAddress()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<br>
		<table style="width: 100%">
			<tr>
				<td style="width: 30%"><input type="submit" name="operation"
					value="previous" <%=(pageNo == 1) ? "disabled" : ""%>></td>
				<td style="width: 30%"><input type="submit" name="operation"
					value="add"></td>
				<td style="width: 25%"><input type="submit" name="operation"
					value="delete"></td>
				<td style="text-align: right;"><input type="submit"
					name="operation" value="next"
					<%=(nextList.size() == 0) ? "disabled" : ""%>></td>
			</tr>
		</table>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>
</body>
</html>