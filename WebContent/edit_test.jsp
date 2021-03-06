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
<%@ page import="java.io.*,bean.LoginBean,util.DateConverter"%>
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
<% java.sql.ResultSet rs = (java.sql.ResultSet)request.getAttribute("TestInfo"); 
rs.next();
%>
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
	<div class="main">
		<div class="header">
			<div class="header_resize">
				<div class="logo">
					<h1>
						<a href="###link"><span>ABC Group</span></a>
					</h1>
					<h3>
						<span>Automated E-Recruitment</span>
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
							<span>Edit Test Schedule</span>
						</h2>
						<ul class="sb_menu"></ul>
						<br /> <br />

						<div class="clr"></div>
						<!-- <div class="img">
							<img src="images/recruit.jpg" width="200" height="119" alt=""
								class="fl" />
						</div> -->
						<div class="post_content">
							<form method="post" action="EditDeleteTests">
								<table>
									<tr>
										<td colspan=2></td>
									</tr>
									<tr>
										<td colspan=2></td>
									</tr>
									<tr>
										<td><b>Test ID</b></td>
										<td><input type="text" name="id"
											value="<%=rs.getString(1)%>" readonly="readonly" /></td>
										<td>* Cannot Be Modified</td>
									</tr>
									<tr>
										<td><b>Test Admin ID</b></td>
										<td><input type="text" name="taid"
											value="<%=rs.getString(2)%>" /></td>
									</tr>
									<tr>
										<td><b>Vacancy ID</b></td>
										<td><input type="text" name="vacid"
											value="<%=rs.getString(3)%>" /></td>
									</tr>
									<tr>
										<td><b>WrittenTest Date (YYYY-MM-DD)</b></td>
										<td><input type="text" name="wtdate"
											value="<%=DateConverter.convertDate(rs.getDate(4))%>" /></td>

							 		</tr>
									<tr>
										<td><b>Technical Interview Date(YYYY-MM-DD)</b></td>
										<td><input type="text" name="tidate"
											value="<%=DateConverter.convertDate(rs.getDate(5))%>" /></td>
									</tr>
									<tr>
										<td><b>HR Interview Date (YYYY-MM-DD)</b></td>
										<td><input type="text" name="hrdate"
											value="<%=DateConverter.convertDate(rs.getDate(6))%>" /></td>
									</tr>

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
					<div class="article">
						Welcome<%=user%>
						<ul class="sb_menu">
							<li><a href="hr_home.jsp">Home</a></li>
							<li><a href="RecruitmentRequest">View Recruitment
									Request</a></li>
							<li><a href="VacancyIdList">Display Candidate Profiles</a></li>
							<li><a href="ViewPlacementConsultants">View Placement
									Consultant Detail</a></li>
							<li><a href="creat_test.jsp">Create Test Schedule</a></li>
							<li><a href="can_stat.jsp">View Candidate Status</a></li>
							<li><a href="Logout">Logout</a></li>
							<li><a href="contact.jsp">Contact</a></li>
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