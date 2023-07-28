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
	<%@ include file="Header.jsp"%>
	<div align="center">
		<h1 align="center" style="margin-bottom: -15; color: navy;">User
			List</h1>

		<form action="UserListCtl.do" method="post">
			<%
				int pageNo = (int) request.getAttribute("pageNo");
				int index = ((pageNo - 1) * 5) + 1;
				List list = (List) request.getAttribute("list");
				Iterator it = list.iterator();
			%>

			<table style="width: 30%">
				<tr>
					<td><input type="text" name="firstName"
						placeholder="Enter First Name"></td>
					<td><input type="date" name="dob"></td>
					<td></td>
					<td><input type="submit" name="operation" value="search">
					</td>
				</tr>
				<tr></tr>
				<tr></tr>
				<tr></tr>
			</table>

			<table border="1" style="width: 100%; border: groove;">
				<tr style="background-color: #e1e6f1e3;">
					<th width="5%">Select</th>
					<th width="5%">S.No.</th>
					<th width="13%">FirstName</th>
					<th width="13%">LastName</th>
					<th width="13%">LoginId</th>
					<th width="8%">Password</th>
					<th width="13%">DOB</th>
					<th width="8%">Address</th>
					<th width="5%">Edit</th>
				</tr>

				<%
					while (it.hasNext()) {

						UserBean bean = (UserBean) it.next();
				%>

				<tr>
					<td style="text-align: center;"><input type="checkbox"
						name="ids" value="<%=bean.getId()%>"></td>
					<td style="text-align: center;"><%=index++%></td>
					<td style="text-align: center;"><%=bean.getFirstName()%></td>
					<td style="text-align: center;"><%=bean.getLastName()%></td>
					<td style="text-align: center;"><%=bean.getLoginId()%></td>
					<td style="text-align: center;"><%=bean.getPassword()%></td>
					<td style="text-align: center;"><%=bean.getDob()%></td>
					<td style="text-align: center;"><%=bean.getAddress()%></td>
					<td style="text-align: center;"><a
						href="UserCtl?id=<%=bean.getId()%>">edit</a></td>
				</tr>

				<%
					}
				%>
			</table>
			<table style="width: 100%">
				<tr>
					<td style="width: 25%"><input type="submit" name="operation"
						value="previous"></td>
					<td align="center" style="width: 25%"><input type="submit"
						name="operation" value="add"></td>
					<td align="center" style="width: 25%"><input type="submit"
						name="operation" value="delete"></td>
					<td style="width: 25%" align="right"><input type="submit"
						name="operation" value="next"></td>
				</tr>
			</table>
			<input type="hidden" name="pageNo" value="<%=pageNo%>">
		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>