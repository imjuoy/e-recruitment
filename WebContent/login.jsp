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
<script type="text/javascript" src="js/login.js"></script>
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
           <h2><span>LOGIN PLEASE!!</span></h2><ul class="sb_menu"></ul> 
               <br /><br />
          
          <div class="clr"></div>
          <div class="img"><img src="images/recruit.jpg" width="200" height="119" alt="" class="fl" /></div>
          <div class="post_content">
            <h3>E-Recruitment System is an automated system for identifying and attracting
            best and worthy talent in the country.</h3>
        
           </div>
          <div class="clr"></div>
        </div>
      </div>
      
      <div class="mainbar">
        <div class="article">
        <br></br><br></br><br></br>
<ul class="sb_menu">
<p><form name="loginform" method="post" action="Loginservlet" onsubmit="return validateForm();">
				   
<table width="60%" cellpadding="1">

<tr>
<td><label>User-Type</label></td>
<td>:</td>
<td>
	<select name="desig">
		<option value="none">Select User Type</option>
		<option value="hr">HR Officer</option>
		<option value="uh">Unit Head</option>
		<option value="bgcadmin">BGC Admin</option>
		
	</select>
</td>
</tr>
<tr>
<td>Emp ID</td>
<td>:</td>
<td><input type="text" name="id"/></td>
</tr>
<tr>
<td>Password</td>
<td>:</td>
<td><input type="password" name="pwd"/></td>
</tr>
<tr>
<td colspan="3"><input type="submit" name="button" value="Login"/></td>
</tr>
<tr>
</tr>
<tr>
</tr>

<tr>
<td colspan="4">
	<a href="forgot_pwd.jsp">Forgot password?</a>
</td>
</tr>
<tr>


<tr>
	<td colspan="3">
		<span id='js_msg' style="color:#ae0404;"></span>
	</td>
</tr>
</table>
</form>
       </div>
       </div>
      <div class="clr"></div>
    </div>
  </div>

<br /><br /><br /><br /><br /><br />
<footer>
<p style="text-align:center;">Copyright@ABC Group</p>
</footer>
</body>
</html>