<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>E-Recruitment</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-georgia.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript" src="js/loginform.js"></script>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body onload="noBack();" onpageshow="if(event.persisted) noBack();"
	onunload="">
<div class="main">
<div class="header">
<div class="header_resize">
<div class="logo">
<h1><a href="###link"><span>ABC Group</span></a></h1>
<h3><span>Buliding the future.....</span></h3>
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
<h2><span><b>Display BGC Schedule</b></span></h2>

<div class="clr"></div>
<div class="img"></div>
<div class="post_content"><br />
<br />

<TABLE BORDER="0" cellpadding="5" cellspacing="5" >
	<tr>
		<th>ADMIN_ID</th>
		<th>FROM_DATE</th>
		<th>TO_DATE</th>
		<th>BGC_ID</th>
	</tr>

	<%
		ResultSet rs2 = (ResultSet) request.getAttribute("ResultSet");
	%>

	<%
		while (rs2.next()) {
	%>
	<form name="my_form" method="get" action="intermediate_servlet">
	<tr>
		<td><input type="text" name="adminid" readonly="readonly" value="<%=rs2.getString(1)%>"></input></td>
		<td><input type="text" name="fdate" readonly="readonly" value="<%=rs2.getString(2)%>"></input></td>
		<td><input type="text" name="tdate" readonly="readonly" value="<%=rs2.getString(3)%>"></input></td>
		<td><%=rs2.getInt(4)%></td>
		<td><input type="submit" name="button" value="EDIT" /></td>
		<td><input type="submit" name="button" value="DELETE"></input></td>
	</tr>
	</form>

	<%
		}
	%>



</TABLE>

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
	<li><a href="BGCadmin_home.jsp">Home</a></li>
	<li><a href="displayDate">View BGC schedule</a></li>
	<li><a href="bgc_status_servlet"> Update BGC Status</a></li>
	<li><a href="login.jsp">Logout</a></li>

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
</body>
</html>