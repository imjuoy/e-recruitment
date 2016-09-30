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

<link href="css/calendar.css" rel="stylesheet" type="text/css" />

<script src="js/count.js" type="text/javascript"></script>
<script src="js/jsl.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
<script src="js/calendar.js" type="text/javascript"></script>

<%@ page import="java.util.*, bean.*, java.sql.*, util.*"%>
<script type="text/javascript">
function init()
  {
	calendar.set("date");
  }
</script>

<script type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</script>
<script type="text/javascript" src="js/editRR.js"></script>
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
<h2><span>View/Edit/Delete Recruitment Request</span></h2>
<ul class="sb_menu"></ul>
<br />
<br />

<div class="clr"></div>

<div class="post_content">
<%
		 System.out.println("xxxxxxxxxxxxxxxxxxxx IN EditPC.jsp session.getAttribute('work')= "+request.getAttribute("work"));
		 
		 
		 if((request.getAttribute("work").toString()).equals("showlist"))  // TO SHOW THE FULL LIST OF ALL THE RR
		 { 
			 System.out.println("xxxxxxxxxxxxxxxxxxxx IN VED_RR.jsp in showlist if condition");
		 %>
<div align="center">


<table class='pretty-table'>
	<caption></caption>
	<tr>
		<th>Required By</th>
		<th>Recruitment Request Details</th>
		<th>Placement Consultant</th>
		<th>Choose Your Option</th>
	</tr>
	<% ResultSet RS;
	DateConverter DC = new DateConverter();
	try{
	RS = (ResultSet)request.getAttribute("VED_RRList");
	RS.beforeFirst();
	while(RS.next())
	{%>
	<tr>
		<form action="do.RRwork" method="post"><input type="hidden"
			name="RR_ID" value="<%= RS.getString("REC_RQST_ID") %>" />
		<td><%= DC.convertDate(RS.getDate("REQ_BY")) %></td>
		<td><%= "Project: "+RS.getString("PROJ_NAME") + " (" + RS.getString("PROJ_DOM") + ")" +  "<br />Location: " + RS.getString("LOCATION") + "<br />Skill: " + RS.getString("VAC_SKILL") + " (" + RS.getString("VAC_EXP") + " yrs Exp.)<br />Intake: " + RS.getString("NO_OF_VAC") %></td>
		<td>
		<% 
	if(RS.getInt("PC_STATUS")==1)
	{
		out.print(RS.getString("PC_NAME"));
	}
	else
	{
		out.print("<span style='color:#ae0404; font-style:italic;'>A Placement Consultant should be<br />assigned immediately !!</span>");
	}
	
	%>
		</td>
		<td><input type="submit" name="button" value="Edit" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="submit" name="button" value="Delete" /></td>

		</form>
	</tr>
	<%}
	}
	catch (SQLException e) {
		e.printStackTrace();
	}%>
</table>
</div>
<% } 
		 
		 // for edit form 
		 
		 if((request.getAttribute("work").toString()).equals("rrdetail")) // TO PUT DETAIL OF SELECTED RR
		 { ResultSet RS1;
		 DateConverter DC = new DateConverter();
		 	try{
		 	RS1 = (ResultSet)request.getAttribute("RR");
		 	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!result set of PARTICULAR RR in edit rr JSP page : "+RS1);
		 	RS1.first();
		 	{%>Recruitment Request Details:<br />
<br />
<form method='post' name='updaterr' action='do.RRwork'
	onsubmit="return check();">
<table>
	<tr>
		<td>ID:</td>
		<td><input type="text" name="rr_id"
			value="<%= RS1.getString("REC_RQST_ID") %>" readonly="readonly" /></td>
		<td><span style="color: #ae0404; font-style: italic;"><i>(Cannot
		Be Edited)</i></span></td>
	</tr>
	<tr>
		<td>Date:</td>
		<td><input type="text" name="date" id="date"
			value="<%= DC.convertDate2(RS1.getDate("REQ_BY"))%>"
			readonly="readonly" /></td>
		<td></td>
	</tr>

	<%}
		 	}
		 	catch (SQLException e) {
		 		e.printStackTrace();
		 	}
		  %>
</table>
<br />
Placement Consultant: <select name="PC_ID">
	<option value='none'>Select Your Option</option>

	<% ResultSet RS2;
	try{
		RS2 = (ResultSet)request.getAttribute("PCList");
		System.out.println("!!!!1234567890!!!!!!!!!result set of pc in edit rr JSP page : "+RS2);
		RS2.beforeFirst();
		while(RS2.next())
			{%>

	<option value='<%= RS2.getString("PC_ID")%>'><%= RS2.getString("PC_NAME") + " (" + RS2.getString("PC_ID") + ")"%></option>

	<%}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		%>

</select><br />
<input type="submit" name="button" value="Update" /> <span id='js_msg'
	style="color: #ae0404;"></span></form>
<% }%>
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
