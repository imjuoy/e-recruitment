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
<script type="text/javascript" src="js/addplac.js"></script>
<script type="text/javascript" src="js/confirmdelete.js"></script>

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
<h2><span>Edit / Delete Placement Consultant</span></h2>
<ul class="sb_menu"></ul>
<br />
<br />

<div class="clr"></div>

<div class="post_content">
<%
		 System.out.println("xxxxxxxxxxxxxxxxxxxx IN EditPC.jsp session.getAttribute('work')= "+request.getAttribute("work"));
		 
		 
		 if((request.getAttribute("work").toString()).equals("showlist"))  // TO SHOW THE FULL LIST OF ALL THE PC
		 { 
			 System.out.println("xxxxxxxxxxxxxxxxxxxx IN EditPC.jsp in showlist if condition");
		 %>
<div align="center">
<table class='pretty-table'>
	<caption>Placement Consultant Details</caption>
	<tr>
		<th>User ID</th>
		<th>Name</th>
		<th>Contact No.</th>
		<th>Choose your Option</th>
	</tr>
	<% ResultSet RS;
	try{
	RS = (ResultSet)request.getAttribute("PCList");
	RS.beforeFirst();
	while(RS.next())
	{%>
	<tr>
		<form method='post' action='do.EditPC'><input type="hidden"
			name="PC_ID" value="<%= RS.getString("PC_ID") %>" />
		<td><%= RS.getString("PC_ID")%></td>
		<td><%= RS.getString("PC_NAME")%></td>
		<td><%= RS.getString("PC_CONTACT")%></td>
		<td><input type="submit" name="button" value="Edit" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="submit" name="button" value="Delete" /></td>
	</tr>
	</form>
	<%}
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

<p style="text-align: center;">Copyright@ABC Group</p>
</body>
</html>