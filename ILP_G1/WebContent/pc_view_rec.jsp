<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html">
<head>
<title>E-Recruitment :: Placement Portal Recruitment Requests</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-georgia.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript" src="js/pcloginform.js"></script>

<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>

</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
	<%!java.sql.ResultSet rs = null;%>
	<%
	rs = (java.sql.ResultSet) request
			.getAttribute("RecruitmentRequests");
%>
	<div class="main">
		<div class="header">
			<div class="header_resize">
				<div class="logo">
					<h1>
						<a href="###link"><span>ABC E-Recruitment</span></a>
					</h1>
					<h3>
						<span>Placement Consultant Portal</span>
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
							<span>Recruitment Requests</span>
						</h2>
						<ul class="sb_menu">
							
						</ul>
						<br /> <br />

						<div class="clr"></div>
						<div class="img"></div>
						<div class="post_content">
							<center>
								<table>
									<tr>
										<th>Recruitment Request Id</th>
										<th>Vacancy Request Id</th>
										<th>HR Recruitment Officer Id</th>
										<th>Required By Date</th>
										<th>Placement Consultant Id</th>
									</tr>
									<%	
		while (rs.next()) {
			out.println("<tr>");
			out.println("<td>" + rs.getString(1) + "</td>");
			out.println("<td>" + rs.getString(2) + "</td>");
			out.println("<td>" + rs.getString(3) + "</td>");
			out.println("<td>" + rs.getString(4) + "</td>");
			out.println("<td>" + rs.getString(5) + "</td>");
			out.println("</tr>");
		}
	%>
								</table>
							</center>
						</div>
						<div class="clr"></div>
					</div>
				</div>

				<div class="mainbar">
					<div class="article">
						<br /> <br /><ul class="sb_menu">
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