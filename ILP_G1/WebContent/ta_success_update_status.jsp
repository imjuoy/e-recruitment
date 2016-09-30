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
<%! String user=null; %>
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
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();"
	onunload="">
	<div class="main">
		<div class="header">
			<div class="header_resize">
				<div class="logo">
					<h1>
						<a href="ta_home.jsp"><span>ABC Group</span></a>
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
							<span>Status Update Success</span>
						</h2>
						<ul class="sb_menu"></ul>
						<br /> <br />
						<div class="clr"></div>
<!--						<div class="img">-->
<!--							<img src="images/recruit.jpg" width="200" height="119" alt=""-->
<!--								class="fl" />-->
<!--						</div>-->
						<div class="post_content">
							Successfully Updated the Status. <a href="TADisplayEditDeleteCandStatus">Another Update?</a> 
							Or <br />
							<a href="ta_home.jsp">Go Back to Homepage</a> 
						</div>
						<div class="clr"></div>
					</div>
				</div>
				<div class="mainbar">
					<div class="article">
						Welcome <%= user%>
						<ul class="sb_menu">
							<jsp:include page="ta_side_menu.jsp"></jsp:include>
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