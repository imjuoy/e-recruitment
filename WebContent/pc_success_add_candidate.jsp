<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html">
<html">
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
<script type="text/javascript" src="js/pcloginform.js"></script>

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
			response.sendRedirect("pc_login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	if (session != null) {
		user = (String) session.getAttribute("User");
		if (user == null) {
			System.out.println("User not logged in");
			try {
				response.sendRedirect("pc_login.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("User still logged in");
		}
	}
%>
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
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
							<span>Add Candidate Success</span>
						</h2>
						<ul class="sb_menu">
							
						</ul>
						<br /> <br />

						<div class="clr"></div>
						<div class="img"></div>
						<div class="post_content" align="center">
							Candidate Added Successfully.
						</div>
						<div class="clr"></div>
					</div>
				</div>

				<div class="mainbar">
					<div class="article">
						<br />
						<ul class="sb_menu">
							<li><a href="pc_home.jsp">Home</a></li>
							<li><a href="PCViewRecruitmentRequest">View Recruitment
									Request</a></li>
							<li><a href="AddCandidate">Add Candidate Profile</a></li>
							<li><a href="add_multiple_candidate.jsp">Add Multiple
									Candidates</a></li>
							<li><a href="PCDisplayCandidates">Display Candidates</a></li>
							<li><a href="PCConfirmCompletion">Confirm Completion</a></li>
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