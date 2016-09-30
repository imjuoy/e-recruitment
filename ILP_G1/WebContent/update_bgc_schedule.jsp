<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="java.sql.*" %>
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
<script language="javascript" type="text/javascript"
	src="js/datetimepicker.js"></script>
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
<h2><span>Automated E-Recruitment</span></h2>

<div class="clr"></div>
<div class="img"></div>
<div class="post_content">
<h3>Schedule BGC test</h3>

<form name="addpc" action="Addservlet" method="post">
<%
	String adminid = (String) request.getAttribute("Id");
	String fdate = (String) request.getAttribute("Fdate");
	String tdate = (String) request.getAttribute("Tdate");
	ResultSet rs=(ResultSet)request.getAttribute("result");
%>
<table>
	<tr>
		<td>Administrator ID</td>
		<td><select  name="adminid">
		   <option value="<%=adminid%>"><%=adminid %></option>
		   <%
		   while(rs.next())
		   {
		   %>
		   <option value="<%=rs.getString(1)%>"><%=rs.getString(1)%></option>
		
		<%
		   }
		%>
		</select>
		</td>
	</tr>


	<tr>
		<td>From Date(DD-MON-YY)<sup style='color: red; font size: 12px'>*</sup></td>
		<td><input type="text" name="fdate" value="<%=fdate%>"></input><a
			href="javascript:NewCal('fdate','ddmmmyyyy')"><img
			src="images/calendar.gif" width="16" height="16" border="0"
			alt="Pick a date"></a></td>
	</tr>
	<tr>
		<td>To Date(DD-MON-YY)<sup style='color: red; font size: 12px'>*</sup></td>
		<td><input type="text" name="tdate" value="<%=tdate%>"></input><a
			href="javascript:NewCal('tdate','ddmmmyyyy')"><img
			src="images/calendar.gif" width="16" height="16" border="0"
			alt="Pick a date"></a></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" name="sub" value="Submit"></input></td>
	</tr>

</table>
</form>
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
	<li><a href="UpdateDate">Update BGC schedule</a></li>
	<li><a href="displayDate">View BGC schedule</a></li>
	<li><a href="display_onteststatus.jsp">View Candidate Details</a></li>
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