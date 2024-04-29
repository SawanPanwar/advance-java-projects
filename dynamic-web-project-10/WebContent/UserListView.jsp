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

		List nextlist = (List) request.getAttribute("nextlist");

		List list = (List) request.getAttribute("list");
		Iterator it = list.iterator();
	%>
	<%@ include file="Header.jsp"%>
	<form action="UserListCtl" method="post">
		<table style="width: 100%" border="1">
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
				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
			%>
			<tr>
				<td style="text-align: center;"><%=bean.getId()%></td>
				<td style="text-align: center;"><%=bean.getFirstName()%></td>
				<td style="text-align: center;"><%=bean.getLastName()%></td>
				<td style="text-align: center;"><%=bean.getLoginId()%></td>
				<td style="text-align: center;"><%=bean.getPassword()%></td>
				<td style="text-align: center;"><%=bean.getDob()%></td>
				<td style="text-align: center;"><%=bean.getAddress()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<table>
			<tr>
				<td><input type="submit" name="operation" value="previous"
					<%=(pageNo != 1) ? "" : "disabled"%>></td>
				<td align="right"><input type="submit" name="operation"
					value="next" <%=(nextlist.size() != 0) ? "" : "disabled"%>></td>
			</tr>
		</table>
		<input type="hidden" name="pageNo" value="<%=pageNo%>">
	</form>
</body>
</html>