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
	<form action="UserListCtl" method="post">

		<%@ include file="Header.jsp"%>


		<%
			int pageNo = (int) request.getAttribute("pageNo");

			int index = ((pageNo - 1) * 5) + 1;

			List nextList = (List) request.getAttribute("nextList");

			List list = (List) request.getAttribute("list");

			Iterator it = list.iterator();
		%>
		<table>
			<tr>
				<th>FirstName :</th>
				<td><input type="text" name="firstName"></td>
				<td><input type="submit" name="operation" value="search"></td>
			</tr>
		</table>

		<table border="1">
			<tr>
				<th>S.No.</th>
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
				<td><%=index++%></td>
				<td><%=bean.getFirstName()%></td>
				<td><%=bean.getLastName()%></td>
				<td><%=bean.getLoginId()%></td>
				<td><%=bean.getPassword()%></td>
				<td><%=bean.getDob()%></td>
				<td><%=bean.getAddress()%></td>
			</tr>
			<%
				}
			%>
		</table>
		<table>
			<tr>
				<td><input type="hidden" name="pageNo" value="<%=pageNo%>"></td>
			</tr>
		</table>
		<table>
			<tr>
				<td><input type="submit" name="operation" value="previous"
					<%=(pageNo != 1) ? "" : "disabled"%>></td>
				<td></td>
				<td></td>
				<td><input type="submit" name="operation" value="next"
					<%=(list.size() == 5 && nextList.size() > 0) ? "" : "disabled"%>></td>
			</tr>
		</table>

	</form>

</body>
</html>