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
        <h1><a href="###link"><span>ABC Group</span></a></h1><h3><span>Buliding the future</span></h3>
      </div>
      <div class="clr"></div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
  
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2><span>Registration</span></h2>
          
          <div class="clr"></div>
         
          <div class="post_content">
            <p><form name="change_pwd" action="Changepwdservlet" method="post"><b>

<table>
<tr>
	<td>Employee ID<sup style='color:red; font size:12px'>*</sup></td>
	<td><input type="text" name="eid" value='<%=(String)session.getAttribute("id")%>' readonly="readonly" /></td>
</tr>


<tr>
<td>Old password <sup style='color:red; font size:12px'>*</sup></td>
<td><input type="password" name="oldpass" /></td>
</tr>

<tr>
<td>New Password<sup style='color:red; font size:12px'>*</sup></td>
<td><input type="password" name="newpass" /></td>
</tr>

<tr>
<td>Confirm Password<sup style='color:red; font size:12px'>*</sup></td>
<td><input type="password" name="conpass" /></td>
</tr>

<tr>
		<td colspan="2"> <input type="submit" name="rst_pwd" value="Reset Password"></td>
	</tr>

</b></table>
</form>
</p>
            <p> </p>
           </div>
          <div class="clr"></div>
        </div>
      </div>
      
      <div class="sidebar">
        <div class="article">
		

<tr>
<td colspan="3">
<span id='js_msg'></span>
</td>
</tr>
</table>
</form>
       </div>
        
       
      </div>
      <div class="clr"></div>
    </div>
  </div>
<br /><br /><br />

<footer>
<p style="text-align:center;">Copyright@ABC Group</p>
</footer>

</body>
</html>