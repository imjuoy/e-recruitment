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
		user = (String) session.getAttribute("User");
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
<%!java.sql.ResultSet rs2,rs1 = null;%>
<%
rs1 = (java.sql.ResultSet) request
.getAttribute("Tests");
	//rs2 = (java.sql.ResultSet) request.getAttribute("VacancyIdList");
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
							<span>Edit/Delete Test Schedule</span>
						</h2>
						<ul class="sb_menu"></ul>
						<br /> <br />

						<div class="clr"></div>
						<!-- 						<div class="img"> -->
						<!-- 							<img src="images/recruit.jpg" width="200" height="119" alt="" -->
						<!-- 								class="fl" /> -->
						<!-- 						</div> -->
						<div class="post_content">
							<table>
								<tr>
									<th></th>
									<th>ID</th>
									<th>Test Admin</th>
									<th>Vacancy ID</th>
									<th>Written Test Date</th>
									<th>Technical Date</th>
									<th>HR Interview Date</th>
									<th></th>
									<th></th>
								</tr>
								<%
									while (rs1.next()) {
										out.println("<form method='post' action='EditDeleteTests'>");
										out.println("<input type='hidden' name='id' value='"+rs1.getString(1)+"'/>");
										out.println("<tr>");
										out.println("<td>"+"<input type='hidden' value='"+rs1.getString(1)+"'/>"+"</td>");
										out.println("<td>" + rs1.getString(1) + "</td>");
										out.println("<td>" + rs1.getString(2) + "</td>");
										out.println("<td>" + rs1.getString(3) + "</td>");
										out.println("<td>" + DateConverter.convertDate(rs1.getDate(4)) + "</td>");
										out.println("<td>" + DateConverter.convertDate(rs1.getDate(5)) + "</td>");
										out.println("<td>" + DateConverter.convertDate(rs1.getDate(6)) + "</td>");
										out.println("<td>" + "<input type='submit' name='button' value='Edit' />" + "</td>");
										out.println("<td>" + "<input type='submit' name='button' value='Delete' />" + "</td>");
										out.println("</tr>");
										out.println("</form>");
									}
								%>
							</table>
						</div>
						<div class="clr"></div>
					</div>
				</div>

				<div class="mainbar">
					<div class="article">
						Welcome&nbsp;<%=user%>
						<ul class="sb_menu">
							<li><a href="hr_home.jsp">Home</a></li>
							<li><a href="RecruitmentRequest">View Recruitment
									Request</a></li>
							<li><a href="VacancyIdList">Display Candidate Profiles</a></li>
							<li><a href="ViewPlacementConsultants">View Placement
									Consultant Detail</a></li>
							<li><a href="EmployeeIdListTA">Appoint Test Admin</a></li>
							<li><a href="DisplayDeleteTA">Display/Delete Test Admin</a></li>
							<li><a href="creat_test.jsp">Create Test Schedule</a></li>
							<li><a href="DisplayEditDeleteTest">Display/Edit/Delete
									Test Schedule</a></li>
							<li><a href="DisplayEditDeleteCandStatus">Display/Update/Delete
									Candidate Status</a></li>
							<li><a href="UpdateMedicalStatus">Update Medical Status</a></li>
							<li><a href="Logout">Logout</a></li>
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