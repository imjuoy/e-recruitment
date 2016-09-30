<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<script type="text/javascript" src="js/addemp.js"></script>
<script language="javascript" type="text/javascript"
	src="js/datetimepicker.js"></script>
<script type="text/javascript" src="js/addemp.js"></script>
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
<h1><a href="###link"><span>ABC Group</span></a></h1>
<h3><span>Buliding the future.....</span></h3>
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
<h2><span>Select Criteria</span></h2>
<ul class="sb_menu"></ul>

<div class="clr"></div>
<div class="img"></div>
<div class="post_content">
<h3><center>View Candidates</center></h3>
<form name="update_bgc_status" action="display_cand_details" method="post"
	onsubmit="return check();">
	<tr>
		<td>Status:</td>
		<td><select name="bgc_status">
			<option value="0">Select</option>
		    <option value="1">Approved</option>	
		    <option value="0">Rejected</option>
		    <option value="2">Pending</option>
		</select></td>
		<td><span id="uhid_msg"></span></td>
	</tr>
	<td><input type="submit" value="submit"></input></td>
	</tr>

</table>
</form>
</body>
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
	<li><a href="checksession">Home</a></li>
	<li><a href="">Logout</a></li>
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