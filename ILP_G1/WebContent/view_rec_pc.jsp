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
<%!String user=null;%>
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
<%!
	java.sql.ResultSet rs = null;%>
<%
	rs = (java.sql.ResultSet) request
			.getAttribute("RecruitmentRequests");
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
							<span>Raised Recruitment Requests</span>
						</h2>
						<ul class="sb_menu"></ul>
						<br /> <br />

						<div class="clr"></div>
						<!-- 						<div class="img"> -->
						<!-- 							<img src="images/recruit.jpg" width="200" height="119" alt="" -->
						<!-- 								class="fl" /> -->
						<!-- 						</div> -->
						<div class="post_content">

							<table border=1>
								<tr>
									<th>Recruitment Request Id</th>
									<th>Vacancy Request Id</th>
									<th>HR Recruitment Officer Id</th>
									<th>Placement Consultant Id</th>
									<th>Required By Date</th>
								</tr>
								<%
									while (rs.next()) {
										out.println("<tr>");
										out.println("<td>" + rs.getString(1) + "</td>");
										out.println("<td>" + rs.getString(2) + "</td>");
										out.println("<td>" + rs.getString(3) + "</td>");
										out.println("<td>" + rs.getString(4) + "</td>");
										out.println("<td>" + DateConverter.convertDate(rs.getDate(5)) + "</td>");
										out.println("</tr>");
									}
								%>
							</table>
						</div>
						<div class="clr"></div>
					</div>
				</div>

				<div class="mainbar">
					<div class="article">
						<ul class="sb_menu">
							<li><a href="pc_home.jsp">Home</a></li>
							<li><a href="PCViewRecruitmentRequest">View Recruitment
									Request</a></li>
							<li><a href="AddCandidate">Add Candidate Profile</a></li>
							<li><a href="add_multiple_candidate.jsp">Add Multiple
									Candidates</a></li>
							<li><a href="display_candidate.jsp">Display Candidates</a></li>
							<li><a href="edit_candidate.jsp">Edit Candidate Profile</a></li>
							<li><a href="delete_candidate.jsp">Delete Candidate
									Profile</a></li>
									<li><a href="Logout">Log Out</a></li>
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