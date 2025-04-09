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
		UserBean bean = (UserBean) request.getAttribute("bean");
	%>
	<%@ include file="Header.jsp"%>
	<form action="UserCtl" method="post">
		<div align="center">
			<%
				if (bean != null && bean.getId() > 0) {
			%>
			<h1>Update User</h1>
			<%
				} else {
			%>
			<h1>Add User</h1>
			<%
				}
			%>
			<table>
				<tr>
					<th>FirstName:</th>
					<td><input type="text" name="firstName"
						value="<%=(bean != null && bean.getFirstName() != null) ? bean.getFirstName() : ""%>"></td>
				</tr>
				<tr>
					<th>LastName:</th>
					<td><input type="text" name="lastName"
						value="<%=(bean != null && bean.getLastName() != null) ? bean.getLastName() : ""%>"></td>
				</tr>
				<tr>
					<th>LoginID:</th>
					<td><input type="text" name="loginId"
						value="<%=(bean != null && bean.getLoginId() != null) ? bean.getLoginId() : ""%>"></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="text" name="password"
						value="<%=(bean != null && bean.getPassword() != null) ? bean.getPassword() : ""%>"></td>
				</tr>
				<tr>
					<th>DOB:</th>
					<td><input type="date" name="dob"
						value="<%=(bean != null && bean.getDob() != null) ? bean.getDob() : ""%>"
						style="width: 97%"></td>
				</tr>
				<tr>
					<th>Address:</th>
					<td><input type="text" name="address"
						value="<%=(bean != null && bean.getAddress() != null) ? bean.getAddress() : ""%>"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" name="operation"
						value="<%=(bean != null && bean.getId() > 0) ? "update" : "save"%>"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>