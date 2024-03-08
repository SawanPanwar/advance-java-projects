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
		String fname = request.getParameter("firstName");
		String lname = request.getParameter("lastName");
		String login = request.getParameter("loginId");
		String pass = request.getParameter("password");
		String dob = request.getParameter("dob");
		String address = request.getParameter("address");
	%>
	<h3><%=fname%></h3>
	<h3><%=lname%></h3>
	<h3><%=login%></h3>
	<h3><%=pass%></h3>
	<h3><%=dob%></h3>
	<h3><%=address%></h3>

</body>
</html>