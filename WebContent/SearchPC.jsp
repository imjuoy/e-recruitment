<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>E-Recruitment</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="css/new_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-georgia.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript" src="js/confirmpcdel.js"></script>

<script src="ajax/PCajax.js"></script>

<%@ page import="java.util.*, bean.*, java.sql.*"%>

<script type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</script>

</head>
<body onload="noBack();loadContent();">
<div class="main">
<div class="header">
<div class="header_resize">
<div class="logo">
<h1><a href="###link"><span>ABC Group</span></a></h1>
<h3><span>Automated E-Recruitment</span></h3>
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
<h2><span>Placement Consultant : View/Edit/Delete/Search</span></h2>
<ul class="sb_menu"></ul>
<br />
<br />

<div class="clr"></div>

<div class="post_content" align="center">

<table>
	<tr>
		<td></td>

		<td></td>

	</tr>

</table>
<table>
	<tr>
		<td><b>Placement Consultant ID :</b></td>
		<td><input type="text" name="pcid" id="pcid"
			onkeyup='loadContent()'></input></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td><b>Provide the ID to Edit or Delete</b></td>
	</tr>
	<tr>
		<td><b>Placement Consultant Name :</b></td>
		<td><input type="text" name="pcname" id="pcname"
			onkeyup='loadContent()'></input></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>
		<form action="do.EditPC" name="edit" method="post"><input
			type="text" name="PC_ID" />&nbsp;&nbsp;<input type="submit"
			name="button" value="Edit" /></form>
		</td>
	</tr>
	<tr>
		<td><b>Contact No :</b></td>
		<td><input type="text" name="con" id="con" maxlength="10"
			onkeyup='loadContent()'></input></td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>
		<form action="do.EditPC" name="deletepc" method="post"><input
			type="text" name="PC_ID" />&nbsp;&nbsp;<input type="submit"
			name="button" value="Delete" onclick="" /></form>
		</td>
	</tr>
	<tr>
		<td colspan="2">* <i>Provide Details, to <b>search</b>
		according to your need.</i> <br />
		* <i>Sample Placement Consultant ID: PC_1 or PC_2</i></td>
	</tr>
</table>


<br />


<br />
<br />
<span id="content"></span></div>
<div class="clr"></div>
</div>
</div>

<div class="mainbar">
<div class="article"><%@ include file="login_det.jsp"%>
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

<p style="text-align: center;">Copyright@ABC Group</p>

</div>
</body>
</html>
