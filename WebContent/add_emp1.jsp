<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.sql.*"%>
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
<script language="javascript" type="text/javascript"src="js/datetimepicker.js"></script>
<script type="text/javascript" src="js/addemp.js"></script>
<script type="text/javascript">
    window.history.forward();
    function noBack() { window.history.forward(); }
</script>

</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="logo">
        <h1><a href="###link"><span>ABC Group</span></a></h1><h3><span>Automated E-Recruitment</span></h3>
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
           <h2><span>ADD EMPLOYEE</span></h2><ul class="sb_menu"></ul> 
               <br /><br />
          
          <div class="clr"></div>
          <div class="post_content">
           </div>
          <div class="clr"></div>
        </div>
      </div>
      
      <div class="sidebar">
        <div class="article">
		
<ul class="sb_menu">


<form name="add_emp" action="empservlet" method="post"
	onsubmit="return check();"> <%
	ResultSet candid = (ResultSet) request.getAttribute("result1");
	ResultSet unitheadid = (ResultSet) request.getAttribute("result2");
	ResultSet projctid = (ResultSet) request.getAttribute("result3");
%>
<table align="left">
	<tr>
		<td>Employee Id:</td>
		<td><select name="empid">
			<option value="0">Select</option>

			<%
				while (candid.next()) {
			%>


			<option value=<%=candid.getString(1)%>><%=candid.getString(1)%></option>
			<%
				}
			%>
		</select></td>
		<td><span id="empid_msg"></span></td>
	</tr>
	<tr>
		<td>Employee Name:</td>
		<td><input type="text" name="ename"></input></td>
		<td><span id="ename_msg"></span></td>
	</tr>
	<tr>
		<td>Date of Birth:</td>
		<td><input type="text" name="dob"></input><a
			href="javascript:NewCal('dob','ddmmmyyyy')"><img
			src="images/calendar.gif" width="16" height="16" border="0"
			alt="Pick a date"></a></td>
		<td><span id="dob_msg"></span></td>
	</tr>
	<tr>
		<td>Location:</td>
		<td><input type="text" name="loc"></input></td>
		<td><span id="loc_msg"></span></td>
	</tr>
	<tr>
		<td>Experience:</td>
		<td><input type="text" name="exp"></input></td>
		<td><span id="exp_msg"></span></td>
	</tr>
	<tr>
		<td>Gender:</td>
		<td><input type="radio" name="gen" value="M">Male</input> <input
			type="radio" name="gen" value="F">Female</input></td>
		<td><span id="gen_msg"></span></td>
	</tr>
	<tr>
		<td>Domain:</td>
		<td><input type="text" name="dom"></input></td>
		<td><span id="dom_msg"></span></td>
	</tr>
	<tr>
		<td>CTC:</td>
		<td><input type="text" name="ctc"></input></td>
		<td><span id="ctc_msg"></span></td>
	</tr>
	<tr>
		<td>Designation:</td>
		<td><input type="text" name="desig"></input></td>
		<td><span id="desig_msg"></span></td>
	</tr>
	<tr>
		<td>Date of Joining:</td>
		<td><input type="text" name="doj"></input><a
			href="javascript:NewCal('doj','ddmmmyyyy')"><img
			src="images/calendar.gif" width="16" height="16" border="0"
			alt="Pick a date"></a></td>
		<td><span id="error_msg"></span></td>
	</tr>
	<tr>
		<td>Unit Head:</td>
		<td><select name="unithead_id">
			<option value="0">Select</option>
			<%
				while (unitheadid.next()) {
			%>
           <option value=<%=unitheadid.getString(1)%>><%=unitheadid.getString(1)%></option>
			<%
				}
			%>
		</select></td>
		<td><span id="uhid_msg"></span></td>
	</tr>
	<tr>
		<td>Project Head ID</td>
	    <td><select  name="prjid">
	    <option value="0">Select</option>
<%
while(projctid.next())
{
%>
     <option value=<%=projctid.getString(1)%>><%=projctid.getString(1) %></option>  
 <%
}
 %> 
     </select></td>   
     <td><span id="prid_msg"></span></td>
	</tr>
	<tr>
		<td><input type="submit" value="submit"></input></td>
	</tr>

</table>
</form>
</body>
</table>
</form>
</div>
<div class="clr"></div>
</div>
<div class="mainbar">
<div class="article"><%@ include file="login_det.jsp"%>
<h2><span>Menu</span></h2>
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