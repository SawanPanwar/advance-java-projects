<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="HelloServlet" method="post">
		<input type="submit">
	</form>

	<h1>advance-java-web</h1>

	<%
		for (int i = 1; i <= 5; i++) {
	%>
	<h1><%=i%>
		advance-java-web
	</h1>
	<%
		}
	%>
</body>
</html>