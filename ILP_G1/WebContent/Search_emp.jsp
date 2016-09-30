<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>E-Recruitment</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/style_searchbox.css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/coin-slider.css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/cufon-georgia.js"></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/coin-slider.min.js"></script>
<script type="text/javascript" src="js/loginform.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/search_emp.js"></script>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script src="js/jquery.autocomplete.js"></script>
<script>
	jQuery(function() {
		$("#country").autocomplete("get_searchdata.jsp");
	});
</script>
</head>
<body>
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
          <div class="img"></div>
          <div class="post_content">
          <form name="search">
          <center>SEARCH EMPLOYEE NAME:<input type="text" id="country"
	              name="country" class="input_text" onclick="loadXMLDoc_search()" />
	      <table>
	      <tr>
	      <td>
	      <span id="a"></span>
	      </td>
	      <td>
	      <span id="b"></span>
	      </td>
	      <td>
	      <span id="c"></span>
	      </td>
	       </tr>
	         </table>        
	            </center> 
	              </form>
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
	    <br>
        <br>
         
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