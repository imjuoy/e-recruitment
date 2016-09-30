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
<h2><span>View/Edit/Delete Vacancy Request</span></h2>
<ul class="sb_menu"></ul>
<br />
<br />

<div class="clr"></div>

<div class="post_content">
<%
		 System.out.println("xxxxxxxxxxxxxxxxxxxx IN EditPC.jsp session.getAttribute('work')= "+request.getAttribute("work"));
		 
		 
		 if((request.getAttribute("work").toString()).equals("showlist"))  // TO SHOW THE FULL LIST OF ALL THE RR
		 { 
			 System.out.println("xxxxxxxxxxxxxxxxxxxx IN VED_VR.jsp in showlist if condition");
		 %>
<div align="center">


<table class='pretty-table'>
	<caption></caption>
	<tr>
		<th>Required By</th>
		<th>Vacancy Request Details</th>
		<th>Choose Your Option</th>
	</tr>
	<% ResultSet RS;
	DateConverter DC = new DateConverter();
	try{
	RS = (ResultSet)request.getAttribute("VED_VRList");
	RS.beforeFirst();
	while(RS.next())
	{%>
	<tr>
		<form action="do.VRwork" method="post"><input type="hidden"
			name="VR_ID" value="<%= RS.getString("VAC_REQ_ID") %>" />
		<td><%= DC.convertDate(RS.getDate("REQ_BY")) %></td>
		<td><%= "Project: "+RS.getString("PROJ_NAME") + " (" + RS.getString("PROJ_DOM") + ")" +   "<br />Skill: " + RS.getString("VAC_SKILL") + " (" + RS.getString("VAC_EXP") + " yrs Exp.)<br />Location: "+RS.getString("LOCATION")+"<br />Intake: " + RS.getString("NO_OF_VAC") %></td>
		<% System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^Location = "+RS.getString("LOCATION")); %>
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
		 
		 if((request.getAttribute("work").toString()).equals("vrdetail")) // TO PUT DETAIL OF SELECTED RR
		 { ResultSet RS1;
		 RS1 = (ResultSet)request.getAttribute("VR");
		 RS1.first();
		 String prev_vac = RS1.getString("VAC_ID");
		 String prev_proj = RS1.getString("PROJ_ID");
		 String prev_loc = RS1.getString("LOCATION");
		 String prev_intake = RS1.getString("NO_OF_VAC");
		 DateConverter DC = new DateConverter();
		 	try{
		 	
		 	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!result set of PARTICULAR VR in edit vr JSP page : "+RS1);
		 	
		 	{%>Vacancy Request Details:<br />
<br />
<form method='post' name='updatevr' action='do.VRwork'
	onsubmit="return check();">
<table>
	<tr>
		<td>ID:</td>
		<td><input type="text" name="vr_id"
			value="<%= RS1.getString("VAC_REQ_ID") %>" readonly="readonly" />&nbsp;&nbsp;&nbsp;<span
			style="color: #ae0404; font-style: italic;"><i>(Cannot Be
		Edited)</i></span></td>
	</tr>


	<tr>
		<td>Vacancy Type:</td>
		<td><select name="vactype">

			<% ResultSet RS2;
					
					RS2 = (ResultSet)request.getAttribute("VacList");
					RS2.beforeFirst();
					String vacid="";
					while(RS2.next())
					{
						vacid = RS2.getString("VAC_ID");
					%>

			<option value='<%= RS2.getString("VAC_ID")%>'
				<% if(prev_vac.equals(vacid))	{ out.print("selected='selected'"); } %>><%= "Skill: " + RS2.getString("VAC_SKILL") + " | Exp: " + RS2.getString("VAC_EXP") + " Yrs" %>
			</option>

			<%}
					
					%>
		</select></td>
	</tr>

	<tr>
		<td>Project:</td>
		<td><select name="proj">

			<%ResultSet RS3;
			
				RS3 = (ResultSet)request.getAttribute("ProjList");
				RS3.beforeFirst();
				String prid="";
				while(RS3.next())
				{
					prid=RS3.getString("PROJ_ID");
				%>
			<option value='<%= RS3.getString("PROJ_ID") %>'
				<% if(prev_proj.equals(prid))	{ out.print("selected='selected'"); } %>><%= RS3.getString("PROJ_DOM") + " - " + RS3.getString("PROJ_NAME")%></option>
			<% } %>
		</select></td>
	</tr>

	<tr>
		<td>Location:</td>
		<td><select name="loc">
			<option value="Bangalore"
				<% if(prev_loc.equals("Bangalore"))	{ out.print("selected='selected'"); } %>>Bangalore</option>
			<option value="Chennai"
				<% if(prev_loc.equals("Chennai"))	{ out.print("selected='selected'"); } %>>Chennai</option>
			<option value="Delhi"
				<% if(prev_loc.equals("Delhi"))	{ out.print("selected='selected'"); } %>>Delhi</option>
			<option value="Kolkata"
				<% if(prev_loc.equals("Kolkata"))	{ out.print("selected='selected'"); } %>>Kolkata</option>
			<option value="Mumbai"
				<% if(prev_loc.equals("Mumbai"))	{ out.print("selected='selected'"); } %>>Mumbai</option>
		</select></td>

	</tr>


	<tr>
		<td>Intake:</td>
		<td><input type="text" name="no_of_vac"
			value="<%= prev_intake %>" /></td>

	</tr>



	<tr>
		<td>Date:</td>
		<td><input type="text" name="date" id="date"
			value="<%= DC.convertDate2(RS1.getDate("REQ_BY"))%>"
			readonly="readonly" /></td>

	</tr>

	<%}
		 	}
		 	catch (SQLException e) {
		 		e.printStackTrace();
		 	}
		  %>
</table>
<br />

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
<footer>
<p style="text-align: center;">Copyright@ABC Group</p>
</footer>
</body>
</html>
