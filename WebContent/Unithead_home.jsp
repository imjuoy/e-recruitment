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
           <h2><span>WELCOME UNIT HEAD</span></h2><ul class="sb_menu"></ul> 
               <br /><br />
          
          <div class="clr"></div>
          <div class="img"><img src="images/recruit.jpg" width="200" height="119" alt="" class="fl" /></div>
          <div class="post_content">
            <h2>Unit Head performs a pivotal role of recognizing the BGC Administrator
                and thereby approving them after which the BGC Administrator can perform
                the BGC Tests</h2>
           
           </div>
          <div class="clr"></div>
        </div>
      </div>
      
      <div class="mainbar">
        <div class="article"><%@ include file="login_det.jsp"%>
		<table>
	    <tr>
	    <td>EMPLOYEE ID:</td>
	    <td><%=session.getAttribute("id")%></td>
	    </tr>
	    <tr>
	    <td>DESIGNATION:</td>
	    <td><%=session.getAttribute("desg")%></td>
	    </tr>
	    </table>
<ul class="sb_menu">
        <li><a href="Approveadmin">Approve BGC admin</a></li>
        <li><a href="">Logout</a></li>
        
		 
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