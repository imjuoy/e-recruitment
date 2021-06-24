<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.sql.*,util.*,util.ResultSetToJson,org.json.JSONArray"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<% 
try
{
    System.out.println("Hey");
	response.setContentType("text/xml");
	String sn = request.getParameter("ok");
	System.out.println("sn = "+sn);
	String s[]=new String[5];
	s=sn.split("-");
	Connection conn = connection.getConnection();
	Statement st = conn.createStatement();
	String query="select * from emp_details_g1 where emp_id='"+s[1]+"'";
	ResultSet rs =st.executeQuery(query);
	System.out.println("select * from emp_details_g1 where emp_id='"+s[1]+"'");
	JSONArray arr = ResultSetToJson.convert(rs);
	out.println(arr);
	//out.println("<emp>");
	/*while(rs.next()) 
	{
	out.println("<empno>"+rs.getString(1)+"</empno>");
	out.println("<empname>"+rs.getString(2)+"</empname>");
	out.println("<location>"+rs.getString(12)+"</location>");
			 
	}
	out.println("</emp>");   */
	rs.close();
	st.close();
	conn.close();
}catch(Exception e)
{
	e.printStackTrace();
}
%>

</body>
</html>