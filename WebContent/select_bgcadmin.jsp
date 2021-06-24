<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page import="java.sql.*" %>
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
<script type="text/javascript" src="js/selectbgc.js"></script>
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
        <h1><a href="###link"><span>ABC Group</span></a></h1><h3><span>Buliding the future.....</span></h3>
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
          <h2><span><b>Select BGC Admin</b></span></h2>
          
          <div class="clr"></div>
          <div class="img"></div>
          <div class="post_content">
            

<form name="addbgc" action="Approval" method="post" onsubmit="return check();">
<%
ResultSet s=(ResultSet)request.getAttribute("result");
%>
<table>
	<tr>
        <td>Employee ID</td>
		<td>
	<select name="empname">
		<option value="0">Select</option>
<%
while(s.next())
{
%>		
	<option value=<%= s.getString(1) %>><%= s.getString(1) %></option>
	
<%
}
%>
</select>
</td>
	</tr>
<tr><br></br></tr>
<tr></tr>	
	
	<tr>
		<td colspan="2" align="right"><input type="submit" name="sub" value="Submit"></input></td>
	</tr>

</table>
</form>
<br>

            <p> </p>
           </div>
          <div class="clr"></div>
        </div>
      </div>
      
      <div class="mainbar">
        <div class="article">
		<h2><span>Menu</span></h2><br />
<ul class="sb_menu">
        <li><a href="HRofficer_home.jsp">Home</a></li>
        <li><a href="viewbgc_admin_servlet">View all BGC Admin</a></li>  
		<li><a href="Schedule_BGC_servlet">Schedule BGC test</a></li>
        <li><a href="">View BGC schedule</a></li>
        <li><a href="display_onteststatus.jsp">View Candidate Details</a></li>
		<li><a href="emp_dropdown_servlet">Add Employee</a></li>
		<li><a href="dispservlet">View Employee details</a></li>
		<li><a href="editctc_servlet">Edit CTC and Designation</a></li> 
        <li><a href="login.jsp">Logout</a></li> 
    </ul>
       </div>
        </div>
      <div class="clr"></div>
    </div>
  </div>
<br /><br /><br /><br /><br /><br /><br />
<footer>
<p style="text-align:center;">Copyright@ABC Group</p>
</footer>
</body>
</html>