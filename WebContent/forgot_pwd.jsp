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
function noBack()
{
Window.history.forward(1);
}
</script>
</head>
<body onload="noBack();" onpageshow="if (event.persisted) noBack();" onunload="">
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
      <div class="sidebar">
        <div class="article">
          <h2><span>Forgot password</span></h2>
          
          <div class="clr"></div>
         
          <div class="post_content">
            <p><form name="frgt_pwd" action="Forgotpwd" method="post"><b>

<table>
<tr>
	<td>User ID</td>
	<td><input type="text" name="uid" readonly="readonly" value=<%=(String)session.getAttribute("id")%>></input></td>
</tr>

<tr>
	<td>Select your Security Question</td>
	<td>
		<select name="ques">
		
			<option value="name of your first school">What is the name of the first school you attended?</option>
			<option value="favourite TV program">What is your favorite TV program?</option>
			<option value="favourite TV program">In what city or town was your first job?</option>

		</select>

	</td>
</tr>

<tr>
<td>Answer:</td>
<td><input type="text" name="ans" /></td>
</tr>



<tr>
		<td colspan="2"> <input type="submit" name="rst_pwd" value="Submit"></td>
	</tr>

</b></table>
</form>
</p>
            <p> </p>
           </div>
          <div class="clr"></div>
        </div>
      </div>
      
      <div class="mainbar">
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