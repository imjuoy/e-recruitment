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
<script type="text/javascript" src="js/addplac.js"></script>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
<%@ page import="java.io.*,bean.LoginBean"%>
<%!String user = null;%>
<%
	if (session == null)
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	if (session != null) {
		String user = (String) session.getAttribute("User");
		if (user == null) {
			System.out.println("User not logged in");
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("User still logged in");
		}
	}
%>
<%!int i = 0;
	String[] s = new String[10];%>
<%
	java.sql.ResultSet rs = (java.sql.ResultSet) request
			.getAttribute("StatusInfo");
	rs.next();

	s[0] = rs.getString(1);
	s[1] = rs.getString(2);
	s[2] = rs.getString(3);
	s[3] = rs.getString(4);
	s[4] = rs.getString(5);
	s[5] = rs.getString(6);
	s[6] = rs.getString(7);
	s[7] = rs.getString(8);
	
	String[] status = new String[3];
	status[0] = "Pending";
	status[1] = "Passed";
	status[2] = "Failed";
	
	
%>
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
<h2><span>Update Candidate Status</span></h2>
<ul class="sb_menu"></ul>
<br />
<br />

<div class="clr"></div>
<!-- <div class="img">
							<img src="images/recruit.jpg" width="200" height="119" alt=""
								class="fl" />
						</div> -->
<div class="post_content">
<form method="post" action="TADisplayEditDeleteCandStatus">
<table>
	<tr>
		<td colspan=2></td>
	</tr>
	<tr>
		<td colspan=2></td>
	</tr>
	<tr>
		<td><b>Candidate Profile ID</b></td>
		<td><input type="text" name="id" value="<%=rs.getString(1)%>"
			readonly="readonly" /></td>
		<td style="color:red">* Cannot Be Modified</td>
	</tr>
	<tr>
		<td><b>Test ID</b></td>
		<td><input type="text" name="testid" value="<%=rs.getString(2)%>" readonly="readonly"/></td>
		<td style="color:red">* Cannot Be Modified</td>
	</tr>
	<% 
	if(rs.getInt(3)==0){
		out.println("<tr>");
		out.println("<td><b>Written Test Status</b></td>");
		out.println("<td><select name='wtstatus'>");
		out.println("<option value='0'>Pending</option>");
		out.println("<option value='1'>Passed</option>");
		out.println("<option value='2'>Failed</option>");
		out.println("</select></td>");
		out.println("</tr>");
	}
	else if(rs.getInt(3)==1){
		out.println("<tr>");
		out.println("<td><input type='hidden' value='"+rs.getInt(3)+"' name='wtstatus' />");
		out.println("Written Test Status : Passed");
		out.println("</td>");
		out.println("</tr>");
	}
	%>
	<% 
	if(rs.getInt(3)==1 && rs.getInt(4)==0){
		out.println("<tr>");
		out.println("<td><b>Technical Interview Status</b></td>");
		out.println("<td><select name='tistatus'>");
		out.println("<option value='0'>Pending</option>");
		out.println("<option value='1'>Passed</option>");
		out.println("<option value='2'>Failed</option>");
		out.println("</select></td>");
		out.println("</tr>");
	}
	else if(rs.getInt(4)==1){
		out.println("<tr>");
		out.println("<td><input type='hidden' value='"+rs.getInt(4)+"' name='tistatus' />");
		out.println("Technical Interview Status : Passed");
		out.println("</td>");
		out.println("</tr>");
	}
	else if(rs.getInt(3)==0 && rs.getInt(4)==0){
		out.println("<tr>");
		out.println("<td><input type='hidden' value='"+rs.getInt(4)+"' name='tistatus' />");
		out.println("</td>");
		out.println("</tr>");
	}
	%>
	<tr>
		<td><input type="reset" name="reset" value="Reset Form" /></td>
		<td><input type="submit" name="button" value="Update" /></td>
	</tr>
	<tr>
		<td colspan=2></td>
	</tr>

</table>
</form>
</div>
<div class="clr"></div>
</div>
</div>

<div class="mainbar">
<div class="article">Welcome<%=user%>
<ul class="sb_menu">
	<jsp:include page="ta_side_menu.jsp"></jsp:include>
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