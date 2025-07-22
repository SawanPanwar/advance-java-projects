<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>User Details</h1>
	<%=request.getParameter("firstName")%>
	<%=request.getParameter("lastName")%>
	<%=request.getParameter("loginId")%>
	<%=request.getParameter("password")%>
	<%=request.getParameter("dob")%>
	<%=request.getParameter("address")%>
</body>
</html>