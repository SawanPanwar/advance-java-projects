<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Data Submitted Successfully</h1>

	<h1><%=request.getParameter("firstName")%></h1>
	<h1><%=request.getParameter("lastName")%></h1>
</body>
</html>