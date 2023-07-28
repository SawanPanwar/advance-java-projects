<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>
		<a href="index.jsp">Simple Link</a>
	</h3>

	<%
		String enUrl = response.encodeURL("index.jsp");
	%>

	<h3>
		<a href="<%=enUrl%>">Encoded Link</a>
	</h3>

	<h3>
		<a href="index.jsp?jsessionid=<%=session.getId()%>">Humari Link</a>
	</h3>

	<form action="track" method="get">
		<input type="hidden" name="jsessionid" value="<%=session.getId()%>">
		<input type="submit" value="Submit">
	</form>


</body>
</html>