<%@page import="in.co.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="bean1" class="in.co.rays.bean.UserBean"
		scope="request"></jsp:useBean>

	<%
		UserBean bean = new UserBean();
	%>

</body>
</html>