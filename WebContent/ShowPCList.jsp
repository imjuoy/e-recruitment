<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>E-Recruitment</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/new_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-georgia.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript" src="js/addvacreq.js"></script>

<%@ page import="java.util.*, bean.*, java.sql.*"%>


<script type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</script>

</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
<div class="main">
<div class="header">
<div class="header_resize">
<div class="logo">
<h1><a href="###link"><span>ABC Group</span></a></h1>
<h3><span>Automated E-Recruitment</span></h3>
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
<h2><span>Search / View Placement Consultant</span></h2>
<ul class="sb_menu"></ul>
<br />
<br />

<div class="clr"></div>

<div class="post_content" align="center">

<table class='pretty-table'>
	<caption>Placement Consultant Details</caption>
	<tr>
		<th>User ID</th>
		<th>Name</th>
		<th>Password</th>
		<th>Contact No.</th>
	</tr>
	<% ResultSet RS;
	try{
	RS = (ResultSet)request.getAttribute("PCList");
	RS.beforeFirst();
	while(RS.next())
	{%>
	<tr>
		<td><%= RS.getString("PC_ID")%></td>
		<td><%= RS.getString("PC_NAME")%></td>
		<td><%= RS.getString("PC_PWD")%></td>
		<td><%= RS.getString("PC_CONTACT")%></td>
	</tr>
	<%}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}%>
</table>

</div>
<div class="clr"></div>
</div>
</div>

<div class="mainbar">
<div class="article"><%@ include file="login_det.jsp"%>
<ul class="sb_menu">
	<%@ include file="hr_menu.jsp"%>
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
