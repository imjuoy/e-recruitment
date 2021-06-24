<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
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
						<a href="###link"><span>ABC Group</span> </a>
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
							<span>Automated E-Recruitment</span>
						</h2>

						<div class="clr"></div>
						<div class="img"></div>
						<div class="post_content" align="center">




							<br /> <br /> <br /> <br />
							<h3>Candidate Details</h3>
							<div align="left">
								<TABLE BORDER="1">
									<TR>
										<TH>CANDIDATE_ID</TH>
										<TH>VACANCY_ID</TH>
										<TH>NAME</TH>
										<TH>DATE_of_BIRTH</TH>
										<TH>LOCATION</TH>
										<TH>GENDER</TH>
										<TH>10Th%</TH>
										<TH>12Th%</TH>
										<TH>GAP</TH>
										<TH>EXPERIENCE</TH>
										<%
											ResultSet rs2 = (ResultSet) request.getAttribute("result");
											while (rs2.next()) {
										%>

										<TR>
											<TD><%=rs2.getString(1)%></TD>
											<TD><%=rs2.getString(2)%></TD>
											<TD><%=rs2.getString(3)%></TD>
											<TD><%=rs2.getDate(4)%></TD>
											<TD><%=rs2.getString(5)%></TD>
											<TD><%=rs2.getString(6)%></TD>
											<TD><%=rs2.getInt(7)%></TD>
											<TD><%=rs2.getInt(8)%></TD>
											<TD><%=rs2.getString(9)%></TD>
											<TD><%=rs2.getInt(11)%></TD>
										</TR>
										<%
											}
											String filepath=(String)request.getAttribute("filepath");
										%>
										<TR><a href="<%=filepath %>">Download PDF REPORT</a></TR>
										<br></br>
								</TABLE>
							</div>
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
						<ul class="sb_menu">
							<li><a href="checksession">Home</a></li>
							<li><a href="login.jsp">Logout</a>
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