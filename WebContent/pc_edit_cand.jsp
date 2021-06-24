<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>E-Recruitment :: Add Candidates</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-georgia.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript" src="js/add_candidate.js"></script>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
<%@ page import="java.io.*,bean.LoginBean,util.DateConverter"%>
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
<%!java.sql.ResultSet rs1=null,rs2 = null;%>
<%
rs1 = (java.sql.ResultSet) request.getAttribute("CandInfo");

	rs2 = (java.sql.ResultSet) request.getAttribute("VacancyIdList");
	rs1.next();
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
							<span>Add Candidates</span>
						</h2>
						<ul class="sb_menu"></ul>
						<br /> <br />

						<div class="clr"></div>

						<div class="post_content">
							<form action="PCEditDeleteModel" method="post" onsubmit="emptyValidate()">
								<table>
									<tr>
										<td>Candidate Profile ID :</td>
										<td><input type="text" id="id" name="id" maxlength="10"
											onblur="notEmptyId()" readonly="readonly" value="<%=rs1.getString(1) %>" /></td>
										<td>
											<div id="idempty">* Mandatory</div>
										</td>
									</tr>
									<tr>
										<td>Vacancy ID :</td>
										<td><select name="vacancyId" onblur="notEmptyVacId()">
												<%
													
														out.println("<option value='" + rs1.getString(2) + "'>"
																+ rs1.getString(2) + "</option>");
													
												%>
										</select></td>
										<td>
											<div id="vacidempty"></div>
										</td>
									</tr>
									<tr>
										<td>Candidate Name :</td>
										<td><input type="text" id="name" name="name"
											maxlength="20" value="<%=rs1.getString(3) %>" /></td>
										<td>
											<div id="nameempty"></div>
										</td>
									</tr>
									<tr>
										<td>Date Of Birth (dd-mon-yyyy) :</td>
										<td><input type="text" id="dob" name="dob" maxlength="11" value="<%=DateConverter.convertDate(rs1.getDate(4)) %>"  /></td>
										<td>
											<div id="dobempty"></div>
										</td>
									</tr>
									<tr>
										<td>Sex :</td>
										<td><select name="sex" id="sex" value="<%=rs1.getString(6) %>">
												<option value="m">Male</option>
												<option value="f">Female</option>
										</select></td>
										<td>
											<div id="sexempty"></div>
										</td>
									</tr>
									<tr>
										<td>Location :</td>
										<td><input type="text" id="location" name="location"
											maxlength="20" value="<%=rs1.getString(5) %>"/></td>
										<td>
											<div id="locationempty"></div>
										</td>
									</tr>
									<tr>
										<td>Percentage in 10th :</td>
										<td><input type="text" id="perc10th" name="perc10th"
											maxlength="5" value="<%=rs1.getString(7) %>"/></td>
										<td>
											<div id="perc10thempty"></div>
										</td>
									</tr>
									<tr>
										<td>Percentage in 12th :</td>
										<td><input type="text" id="perc12th" name="perc12th"
											maxlength="5" value="<%=rs1.getString(8) %>"/></td>
										<td>
											<div id="perc12thempty"></div>
										</td>
									</tr>
									<tr>
										<td>Gap In Education :</td>
										<td><input type="text" id="gapined" name="gapined"
											maxlength="100" value="<%=rs1.getString(9) %>"/></td>
										<td>
											<div id="gapinedempty"></div>
										</td>
									</tr>
									<tr>
										<td>Gap In Experience :</td>
										<td><input type="text" id="gapinex" name="gapinex"
											maxlength="3" value="<%=rs1.getString(10) %>"/></td>
										<td>
											<div id="gapinexempty"></div>
										</td>
									</tr>
									<tr>
										<td>Experience(in years) :</td>
										<td><input type="text" id="exp" name="exp" maxlength="3" value="<%=rs1.getString(11) %>"/></td>
										<td>
											<div id="expempty"></div>
										</td>
									</tr>
									<tr>
										<td id="submit"></td>
									</tr>
								</table>
							</form>
						</div>
						<div class="clr"></div>
					</div>
				</div>

				<div class="mainbar">
					<div class="article">
					<br /> <br />
						<ul class="sb_menu">
							<li><a href="pc_home.jsp">Home</a></li>
							<li><a href="PCViewRecruitmentRequest">View Recruitment
									Request</a></li>
							<li><a href="AddCandidate">Add Candidate Profile</a></li>
							<li><a href="add_multiple_candidate.jsp">Add Multiple
									Candidates</a></li>
							<li><a href="">Display Candidates</a></li>
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
		<p style="text-align: center;">Copyright@XYZ Cars Co.</p>
		</footer>
</body>
</html>