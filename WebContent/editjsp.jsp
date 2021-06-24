<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/edit_ctc.js"></script>
<script type="text/javascript" src="js/get_desg.js"></script>
<script type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</script>
<title>E-Recruitment</title>
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
<div class="main">
<div class="header">
<div class="header_resize">
<div class="logo">
<h1><a href="###link"><span>ABC Group</span></a></h1>
<h3><span>Building the future</span></h3>
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
<h2><span>Edit CTC And DESIGNATION</span></h2>
<br />
<br />
<div class="clr"></div>
<div class="img"></div>
<div>


<p>
<form name="dummy" method="post" action="Editservlet" onsubmit="return check();">

<table cellpadding="0">
	<%
		ResultSet a = (ResultSet) request.getAttribute("result");
		ResultSet c = (ResultSet) request.getAttribute("result1");
	%>

	<tr>
		<td>Employee   ID:</td>
		<td><select name="empid" onchange="getdesg()">
		   <option value="none">--Select--</option>
			<%
				while (a.next()) {
			%>
			<option value=<%=a.getString(1)%>><%=a.getString(1)%></option>
			<%
				}
			%>
		</select></td>
	</tr>
	<tr><td>Present Designation:</td><td><span id="a"></span><br /></td></tr>
	<tr>
		<td>New Designation:</td>
		<td><select name="sele" onchange="loadXMLDoc()" />
			<option value="0">Select</option>
			<%
				while (c.next()) {
			%>
			<option value=<%=c.getString(1)%>><%=c.getString(1)%></option>
			<%
				}
			%>
		</select></td>
	</tr>
	<tr>
		<td>CTC:</td>
		<td><select name="sele2">
		     <option>---choose---</option>
	         </select>
	         </td>
	</tr>    
	<tr>
		<td colspan="3"><input type="submit" name="button" value="submit" /></td>
	</tr>
</table>
</form>
<br>

<p></p>
</div>
<div class="clr"></div>
</div>
</div>

<div class="mainbar">
<div class="article"><%@ include file="login_det.jsp"%>
<h2><span>Menu</span></h2>
<br />
<ul class="sb_menu">
	<%@ include file="hr_menu.jsp"%>

</ul>
</div>


</div>
<div class="clr"></div>
</div>
</div>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<footer>
<p style="text-align: center;">Copyright@ABC Group</p>
</footer>
</body>
</html>