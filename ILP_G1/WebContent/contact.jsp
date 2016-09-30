<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*,bean.LoginBean"%>
<%
if (session == null)
	try {
		response.sendRedirect("index.jsp");
	} catch (IOException e) {
		e.printStackTrace();
	}
if (session != null) {
	LoginBean loginBean = (bean.LoginBean) session.getAttribute("User");
	if (loginBean == null) {
		System.out.println("User not logged in");
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	} else {
		System.out.println("User still logged in");
	}
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>


</head>
<body>
	Contact Us.
	<br /> Or don't. Your wish.
</body>
</html>