<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>E-Recruitment</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/new_style.css" rel="stylesheet" type="text/css" />
<link href="css/coin-slider.css" rel="stylesheet" type="text/css" />

<link href="css/calendar.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-georgia.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>

<script src="js/count.js" type="text/javascript"></script>
<script src="js/jsl.js" type="text/javascript"></script>
<script src="js/common.js" type="text/javascript"></script>
<script src="js/calendar.js" type="text/javascript"></script>

<script type="text/javascript">
function init()
  {
	calendar.set("req_by_date");
  }
</script>

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
<h2><span>Create Vacancy Request</span></h2>
<ul class="sb_menu"></ul>
<br />
<br />

<div class="clr"></div>

<div class="post_content">



<form name="addvacreq" action="createVR" method="post"
	onsubmit="return check();">
<table>
	<tr>
		<td>Vacancy Type:</td>
		<td><select name="vactype">
			<option value='none'>Select Your Option</option>

			<% ResultSet RS2;
					try{
					RS2 = (ResultSet)request.getAttribute("VacList");
					RS2.beforeFirst();
					while(RS2.next())
					{%>

			<option value='<%= RS2.getString("VAC_ID")%>'><%= "Skill: " + RS2.getString("VAC_SKILL") + " | Exp: " + RS2.getString("VAC_EXP") + " Yrs"%>
			</option>

			<%}
					}
					catch(SQLException e) {
						e.printStackTrace();
					}%>
		</select></td>

		<td><span id="vactype_msg" style="color: #ae0404;"></span></td>
	</tr>
	<tr>
		<td>Project:</td>
		<td><select name="proj">
			<option value='none'>Select Your Option</option>

			<%ResultSet RS1;
				try{
				RS1 = (ResultSet)request.getAttribute("ProjList");
				RS1.beforeFirst();
				while(RS1.next())
				{%>
			<option value='<%= RS1.getString("PROJ_ID") %>'><%= RS1.getString("PROJ_DOM") + " - " + RS1.getString("PROJ_NAME")%></option>
			<%}
				}
				catch (SQLException e) {
					e.printStackTrace();
				}%>
		</select></td>

		<td><span id="proj_msg" style="color: #ae0404;"></span></td>
	</tr>

	<tr>
		<td>Location:</td>
		<td><select name="loc">
			<option value='none'>Select Your Option</option>
			<option value="Bangalore">Bangalore</option>
			<option value="Chennai">Chennai</option>
			<option value="Delhi">Delhi</option>
			<option value="Kolkata">Kolkata</option>
			<option value="Mumbai">Mumbai</option>
		</select></td>
		<td><span id="loc_msg" style="color: #ae0404;"></span></td>
	</tr>

	<tr>
		<td>No.of Vacancy:</td>
		<td><input type="text" name="nmbrvac"></td>
		<td><span id="nmbrvac_msg" style="color: #ae0404;"></span></td>
	</tr>

	<tr>
		<td>Required By Date:</td>
		<td><input type="text" name="req_by_date" id="req_by_date"
			readonly="true"></td>
		<td><span id="req_by_date_msg" style="color: #ae0404;"></span></td>
	</tr>

	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" name="sub"
			value="Submit"></td>
	</tr>
</table>
</form>



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