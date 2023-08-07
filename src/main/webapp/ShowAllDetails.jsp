
<%@page import="com.digit.hibernateServlet.bean.AadharDetails"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Details</title>
</head>
<body>
	<%
	session = request.getSession();
	List userList = (List) session.getAttribute("allUser");
	Iterator itr = userList.iterator();

	while (itr.hasNext()) {
		AadharDetails s = (AadharDetails)itr.next();
		out.println("Details: <BR>"+s.getName());

	}
	%>
</body>
</html>