<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<title>E-Recruitment</title>
<script type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</script>
</head>
<body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="###link"><span>ABC Group</span></a></h1><h3><span>Buliding the future</span></h3>
      </div>
      <div class="clr"></div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
  
  <div class="content">
    <div class="content_resize">
      <div class="sidebar">
        <div class="article">
          <h2><span>Automated E-Recruitment</span></h2>
          <br /> <br />
          <div class="clr"></div>
          <div class="img"></div>
          <div>
           <h4><center>BGC Admin Details:</h4>

<TABLE BORDER="1">
<TR>

<TH>ADMIN ID</TH>
<TH>STATUS</TH>
<TH>EMPLOYEE ID</TH>

</TR>


<%
ResultSet rs2=(ResultSet)request.getAttribute("result");
while(rs2.next())
{%>

<TR>

<TD> <%= rs2.getString(1) %> </TD>
<TD> <%= rs2.getString(2) %> </TD>
<TD> <%= rs2.getString(3) %> </TD>


</TR>
 
<%
}
%>

<br></br>
</TABLE>
</center>
<br>

<p></p>
</div>
<div class="clr"></div>
</div>
</div>

<div class="mainbar">
<div class="article"><%@ include file="login_det.jsp"%>
<h2><span>Menu</span></h2>
<br />
<ul class="sb_menu">
	
	                       <%@ include file="hr_menu.jsp" %>

</ul>
</div>


</div>
<div class="clr"></div>
</div>
</div>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<footer>
<p style="text-align: center;">Copyright@ABC Group</p>
</footer>
</BODY>

</body>
</html>