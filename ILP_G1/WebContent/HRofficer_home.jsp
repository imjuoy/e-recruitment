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
           <h2><span>WELCOME HR !!</span></h2><ul class="sb_menu"></ul> 
               <br /><br />
          
          <div class="clr"></div>
          <div class="img"><img src="images/recruit.jpg" width="200" height="119" alt="" class="fl" /></div>
          <div class="post_content">
            <h3>HR Recruitment Officer is responsible for co-ordinating all the inputs
                that come from the BGC Admin and Unit Head, to make the entire 
                E-recruitment process easy and hasslefree.</h3>
           
           </div>
          <div class="clr"></div>
        </div>
      </div>
      
      <div class="mainbar">
        <div class="article">
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
                             
							<li><a href="BGCServlet">Select BGC admin</a>
							</li>
							<li><a href="viewbgc_admin_servlet">View all BGC admin</a>
							</li>
							<li><a href="Schedule_BGC_servlet">Schedule BGC test</a>
							</li>
							<li><a href="displayDate">View BGC schedule</a>
							</li>
							<li><a href="emp_dropdown_servlet">Add Employee</a>
							</li>
							<li><a href="Search_emp.jsp">View Employee details</a>
							</li>
							<li><a href="editctc_servlet">Edit CTC and Designation</a>
							</li>
							<li><a href="login.jsp">Logout</a>
							</li>
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