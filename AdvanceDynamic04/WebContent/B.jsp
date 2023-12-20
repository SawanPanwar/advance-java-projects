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
		request.setAttribute("msg2", "B");
	%>

	<jsp:forward page="C.jsp"></jsp:forward>

</body>
</html>