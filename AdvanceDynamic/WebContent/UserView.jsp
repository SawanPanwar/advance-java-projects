<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UserCtl" method="post">
		<%@ include file="Header.jsp"%>
		<%
			UserBean bean = (UserBean) request.getAttribute("bean");
			String msg = (String) request.getAttribute("msg");
		%>
		<%
			if (msg != null) {
		%>
		<%=msg%>
		<%
			}
		%>

		<%
			if (bean != null) {
		%>
		<table>
			<tr>
				<th></th>
				<td><input type="hidden" name="id" value="<%=bean.getId()%>"></td>
			</tr>
			<tr>
				<th>FirstName :</th>
				<td><input type="text" name="firstName"
					value="<%=bean.getFirstName()%>"></td>
			</tr>
			<tr>
				<th>LastName :</th>
				<td><input type="text" name="lastName"
					value="<%=bean.getLastName()%>"></td>
			</tr>
			<tr>
				<th>LoginId :</th>
				<td><input type="text" name="loginId"
					value="<%=bean.getLoginId()%>"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="text" name="password"
					value="<%=bean.getPassword()%>"></td>
			</tr>
			<tr>
				<th>DOB :</th>
				<td><input type="date" name="dob" value="<%=bean.getDob()%>"></td>
			</tr>
			<tr>
				<th>Address :</th>
				<td><input type="text" name="address"
					value="<%=bean.getAddress()%>"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="update"></td>
			</tr>
		</table>
		<%
			} else {
		%>
		<table>
			<tr>
				<th>FirstName :</th>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<th>LastName :</th>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<th>LoginId :</th>
				<td><input type="text" name="loginId"></td>
			</tr>
			<tr>
				<th>Password :</th>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<th>DOB :</th>
				<td><input type="date" name="dob"></td>
			</tr>
			<tr>
				<th>Address :</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="add"></td>
			</tr>
		</table>
		<%
			}
		%>

	</form>
</body>
</html>