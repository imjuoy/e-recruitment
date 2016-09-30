<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>E-Recruitment</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/new_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-georgia.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript" src="js/appconfirm.js"></script>

<%@ page import="java.util.*, bean.*, java.sql.*,util.*"%>

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
<h2><span>Approve Vacancy Request</span></h2>
<ul class="sb_menu"></ul>
<br />
<br />

<div class="clr"></div>

<div class="post_content">
<%
		 System.out.println("xxxxxxxxxxxxxxxxxxxx IN Approve Vacancy Request.jsp session.getAttribute('work')= "+request.getAttribute("work"));
		 if((request.getAttribute("work").toString()).equals("showlist"))  // TO SHOW THE FULL LIST OF ALL UNAPPROVED VR
		 { 
			 System.out.println("xxxxxxxxxxxxxxxxxxxx IN Approve Vacancy Request.jsp in showlist if condition");
		 %>
<div align="center">
<table class='pretty-table'>
	<caption></caption>
	<tr>
		<th>Required By</th>
		<th>Requested On</th>
		<th>Project Details</th>
		<th>Requirement Details</th>
		<th>No.of Vacancy</th>
		<th>Raised By</th>
		<th>Click to Approve</th>
	</tr>
	<% 
	int c=0;
	ResultSet RS;
	DateConverter DC = new DateConverter();
	try{
	RS = (ResultSet)request.getAttribute("VRList");
	RS.beforeFirst();
	while(RS.next())
	{%>
	<tr>
		<form method='post' action='do.Approve'><input type="hidden"
			name="VR_ID" value="<%= RS.getString("VAC_REQ_ID") %>" />
		<td><%= DC.convertDate(RS.getDate("REQ_BY")) %></td>
		<td><%= DC.convertDate(RS.getDate("REQST_ON")) %></td>
		<td><%= RS.getString("PROJ_NAME") + " (" + RS.getString("PROJ_DOM") + ")" +  " - " + RS.getString("LOCATION") %></td>
		<td><%= RS.getString("VAC_SKILL") + " (" + RS.getString("VAC_EXP") + " yrs Exp.)" %></td>
		<td><%= RS.getString("NO_OF_VAC") %></td>
		<td><%= RS.getString("EMP_NAME") + " (" + RS.getString("EMP_ID") + ")" %></td>
		<td><input type="button" name="button" value="Approve"
			onclick="apconfirm(<%= c %>);" /></td>
	</tr>
	</form>
	<%
	c++;
	}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}%>
</table>
</div>
<% } 

if((request.getAttribute("work").toString()).equals("pcdetail")) // TO PUT DETAIL OF SELECTED PC
{ ResultSet RS;
	try{
	RS = (ResultSet)request.getAttribute("PC");
	RS.first();
	{%>Placement Consultant Details:<br />
<form method='post' name='addpc' action='do.EditPC'
	onsubmit="return check();">
<table>
	<tr>
		<td>ID:</td>
		<td><input type="text" name="pc_id"
			value="<%= RS.getString("PC_ID") %>" readonly="readonly" /></td>
		<td><span style="color: #ae0404; font-style: italic;"><i>(Cannot
		Be Edited)</i></span></td>
	</tr>
	<tr>
		<td>Name:</td>
		<td><input type="text" name="pcname"
			value="<%= RS.getString("PC_NAME") %>" /></td>
		<td><span id="pcname_msg"
			style="color: #ae0404; font-style: italic;"></span></td>
	</tr>
	<tr>
		<td>Contact:</td>
		<td><input type="text" name="pc_con" maxlength="10"
			value="<%= RS.getString("PC_CONTACT") %>" /></td>
		<td><span id="pc_con_msg"
			style="color: #ae0404; font-style: italic;"></span></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" name="button" value="Update" /></td>
	</tr>
</table>
</form>
<%}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}
} %>
</div>
<div class="clr"></div>
</div>
</div>

<div class="mainbar">
<div class="article"><%@ include file="login_det.jsp"%>
<ul class="sb_menu">
	<%@ include file="basic_menu.jsp"%>
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

<p style="text-align: center;">Copyright@ABC Group</p>
</body>
</html>