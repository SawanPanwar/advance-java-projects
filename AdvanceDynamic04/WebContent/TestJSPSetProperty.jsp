<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="bean" scope="request" class="in.co.rays.bean.UserBean"></jsp:useBean>
	<jsp:setProperty name="bean" property="*" />
	<jsp:setProperty name="bean" property="firstName" param="firstname" />
	<jsp:setProperty name="bean" property="lastName" value="kirar" />

	<form action="" method="post">
		<table>
			<tr>
				<th>FirstName :</th>
				<td><input type="text" name="firstname"></td>
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
				<th></th>
				<td><input type="submit" name="operation" value="signUp"></td>
			</tr>
		</table>
	</form>


	<%
		String op = (String) request.getParameter("operation");

		if (op != null) {
	%>
	<%=bean.getFirstName()%>
	<%=bean.getLastName()%>
	<%=bean.getLoginId()%>
	<%=bean.getPassword()%>
	<%
		}
	%>


</body>
</html>