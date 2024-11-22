<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome</h1>
	<h3><%=request.getParameter("firstName")%></h3>
	<h3><%=request.getParameter("lastName")%></h3>
	<h3><%=request.getParameter("loginId")%></h3>
	<h3><%=request.getParameter("password")%></h3>
	<h3><%=request.getParameter("dob")%></h3>
	<h3><%=request.getParameter("address")%></h3>
</body>
</html>