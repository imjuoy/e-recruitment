<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@page import="java.sql.*" %>
<%@page import="util.*" %>
<%@page import="model.*" %>

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
        <h1><a href="###link"><span>ABC Group</span></a></h1><h3><span>Buliding the future.....</span></h3>
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
          <h2><span>Automated E-Recruitment</span></h2>
          
          <div class="clr"></div>
          <div class="img"></div>
          <div class="post_content">
<br /><br /><br /><br />
            <h3>Employee details.</h3>
            
            

<%="this is update admin jsp page" %>
</center>
<center>
<TABLE BORDER="1">
<TR>
<TH>DELETE</TH>
<TH>EDIT</TH>
<TH>ADMINID</TH>
<TH>EMPID</TH>


</TR>

<%

ResultSet rs=null;
//updateBgc u=new updateBgc();
//rs=u.update();

while(rs.next())
{%>
</center>
<center>
<TR>
<TD><a href="delete.jsp">Delete</a></TD>
<TD><a href="edit.jsp">edit</a></TD>
<TD> <%= rs.getString(1)%> </TD>
<TD> <%= rs.getString(2)%> </TD>


</center>
</TR>
 
<% }%>


<br>

            <p> </p>
           </div>
          <div class="clr"></div>
        </div>
      </div>
      
      <div class="sidebar">
        <div class="article">
		<h2><span></span></h2><br />

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