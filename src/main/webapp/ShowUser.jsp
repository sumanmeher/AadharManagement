<%@page import="com.digit.hibernateServlet.bean.AadharDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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
	session = request.getSession();
	AadharDetails userList = (AadharDetails) session.getAttribute("userDetail");
	
	out.println(userList.getName());
	
	%>

</body>
</html>