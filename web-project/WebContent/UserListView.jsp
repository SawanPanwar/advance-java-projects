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
		int pageNo = (int) request.getAttribute("pageNo");
		int index = ((pageNo - 1) * 5) + 1;
		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>
	<%@ include file="Header.jsp"%>
	<form action="UserListCtl" method="post">
		<div align="center">
			<h1>User List</h1>
		</div>
		<div align="center">
			<table>
				<tr>
					<th>First Name:</th>
					<td><input type="text" name="firstName"
						placeholder="enter first name here">&nbsp; &nbsp;</td>
					<th>Date of birth:</th>
					<td><input type="date" name="dob">&nbsp; &nbsp;</td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>
		</div>
		<br>
		<table border="1%" style="width: 100%">
			<tr>
				<th>Select</th>
				<th>S.No.</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>LoginId</th>
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
				<td><input type="checkbox" name="ids" value="<%=bean.getId()%>"></td>
				<td><%=index++%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=bean.getAddress()%></td>
				<td><a href="UserCtl?id=<%=bean.getId()%>">edit</a></td>
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
					<%=(list.size() < 5) ? "disabled" : ""%>></td>
			</tr>
		</table>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>
</body>
</html>