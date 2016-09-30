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
							<span>Placement Consultant Login</span>
						</h2>
						
						<br /> <br />

						<div class="clr"></div>
						<div class="img"></div>
						<div class="post_content">
							<center>
								<form action="PCLogin" onsubmit="emptyValidate()" method="post">
									<table>
										<tr>
											<td>Username :</td>
											<td><input type="text" id="userName" name="userName"
												maxlength="12" onblur="notEmptyUsername()" /></td>
											<td>
												<div id="userempty"></div>
											</td>
										</tr>
										<tr>
											<td>Password :</td>
											<td><input type="password" id="password" name="password"
												maxlength="12" onblur="notEmptyPassword()" /></td>
											<td>
												<div id="passempty"></div>
											</td>
										</tr>
										<tr>
											<td id="submit" colspan="2"></td>
										</tr>
									</table>
								</form>
							</center>
						</div>
						<div class="clr"></div>
					</div>
				</div>

				<div class="mainbar">
					<div class="article">
						<br /> <br /> <br />
						<ul class="sb_menu">
							<li><a href="index.jsp">Employee Portal</a></li>
							<li><a href="pc_login.jsp">Placement Consultant Portal</a></li>
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