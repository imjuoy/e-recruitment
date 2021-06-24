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
    function noBack() { window.history.forward(); }
</script>
</head>
<body onload="noBack();" onpageshow="if(event.persisted) noBack();" onunload="">
	<div class="main">
		<div class="header">
			<div class="header_resize">
				<div class="logo">
					<h1>
						<a href="###link"><span>ABC Group</span></a>
					</h1>
					<h3>
						<span>Buliding the future.....</span>
					</h3>
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
						<h2>
							<span>VIEW CANDIDATES</span>
						</h2>

						<div class="clr"></div>
						<div class="img"></div>
						<div class="post_content">
							<br /> <br /> <br />
							<TABLE BORDER="1" cellpadding="0" cellspacing="0" width="600">

								<TR>
									<TH>EMPLOYEE 
									DETAILS</TH>
									<TH>EXPERIENCE</TH>
									<TH>CTC</TH>
									<TH>UNIT HEAD</TH>
									<TH>PROJECT DETAILS</TH>
									<TH>DATES</TH>
									
								</TR>


								<%
									ResultSet rs2 = (ResultSet) request.getAttribute("result");
									int i;
								%>

								<%
									while (rs2.next()) {
								%>
								<form name="my_form" method="get" action="intermediate_servlet">
									<TR>
										<TD>Employee ID:<%=rs2.getString(1)%><br />Name:<%=rs2.getString(2)%><br />Gender:<%=rs2.getString(10)%></TD>
										<TD><%=rs2.getString(3)%></TD>
										<TD><%=rs2.getString(4)%></TD>
										<TD><%=rs2.getString(5)%></TD>
										<TD>Project ID: <%=rs2.getString(7)%><br />Domain: <%= rs2.getString(6)%><br />Location: <%=rs2.getString(12)%></TD>
										<TD>DOB:<%=rs2.getDate(8)%><br />DOJ:<%=rs2.getDate(9)%></TD>
										
										<%
											}
										%>

										<td></td>
										</center>
									</TR>
								</form>




							</TABLE>

							<br>

								<p></p>
						</div>
						<div class="clr"></div>
					</div>
				</div>

				<div class="mainbar">
					<div class="article">
						<h2>
							<span>Menu</span>
						</h2>
						<br />
						<br />
						<br />
						<br />
						<ul class="sb_menu">
							<li><a href="HRofficer_home.jsp">Home</a></li>
							<li><a href="BGCServlet">Select BGC admin</a></li>
							<li><a href="viewbgc_admin_servlet">View all BGC admin</a></li>
							<li><a href="Schedule_BGC_servlet">Schedule BGC test</a></li>
							<li><a href="displayDate">View BGC schedule</a></li>
							<li><a href="display_onteststatus.jsp">View Candidate
									Details</a></li>
							<li><a href="emp_dropdown_servlet">Add Employee</a></li>
							<li><a href="dispservlet">View Employee details</a></li>
							<li><a href="editctc_servlet">Edit CTC and designation</a></li>
							<li><a href="login.jsp">Logout</a></li>

						</ul>
					</div>


				</div>
				<div class="clr"></div>
			</div>
		</div>
		<br /> <br /> <br /> <br /> <br /> <br /> <br />
		<footer>
		<p style="text-align: center;">Copyright@ABC Group</p>
		</footer>
</body>
</html>