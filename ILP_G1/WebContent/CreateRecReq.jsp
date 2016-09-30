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
<script type="text/javascript" src="js/addrecreq.js"></script>

<%@ page import="java.util.*, bean.*, java.sql.*, util.*"%>


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
<h2><span>Create Recruitment Request</span></h2>
<ul class="sb_menu"></ul>
<br />
<br />

<div class="clr"></div>

<div class="post_content">
<form name="addrecreq" action="createRR" method="post"
	onsubmit="return check();">Vacancy Request: <br />
<br />
<table class='pretty-table'>
	<caption></caption>
	<tr>
		<th></th>
		<th>Required By</th>
		<th>Requested On</th>
		<th>Project Details</th>
		<th>Requirement Details</th>
		<th>No.of Vacancy</th>
		<th>Raised By</th>
	</tr>
	<% ResultSet RS1;
	DateConverter DC = new DateConverter();
	try{
	RS1 = (ResultSet)request.getAttribute("VacReqList");
	RS1.beforeFirst();
	while(RS1.next())
	{%>
	<tr>
		<td><input type="radio" name="VR_ID"
			value="<%= RS1.getString("VAC_REQ_ID") %>"></input></td>
		<td><%= DC.convertDate(RS1.getDate("REQ_BY")) %></td>
		<td><%= DC.convertDate(RS1.getDate("REQST_ON")) %></td>
		<td><%= RS1.getString("PROJ_NAME") + " (" + RS1.getString("PROJ_DOM") + ")" +  " - " + RS1.getString("LOCATION") %></td>
		<td><%= RS1.getString("VAC_SKILL") + " (" + RS1.getString("VAC_EXP") + " yrs Exp.)" %></td>
		<td><%= RS1.getString("NO_OF_VAC") %></td>
		<td><%= RS1.getString("EMP_NAME") + " (" + RS1.getString("EMP_ID") + ")" %></td>
	</tr>
	<%}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}%>
</table>
<br />
Placement Consultant: <select name="PC_ID">
	<option value='none'>Select Your Option</option>

	<% ResultSet RS2;
	try{
		RS2 = (ResultSet)request.getAttribute("PCList");
		RS2.beforeFirst();
		while(RS2.next())
			{%>

	<option value='<%= RS2.getString("PC_ID")%>'><%= RS2.getString("PC_NAME") + " (" + RS2.getString("PC_ID") + ")"%></option>

	<%}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}%>

</select> &nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" name="sub"
	value="Create Recruitment Request"></input> <span id='js_msg'
	style="color: #ae0404;"></span></form>
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
