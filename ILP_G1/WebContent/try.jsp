<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>hey</title>
<script>
function loadXMLDoc()
{ var xmlhttp; 
var v=document.dummy.sele.value;
var urls="db_fetch.jsp?ok="+v;
if (window.XMLHttpRequest) 
{   xmlhttp=new XMLHttpRequest();  
} 
else
{   xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");  
}
xmlhttp.onreadystatechange=function() 
							{   
								removeall();     
								if (xmlhttp.readyState==4) 
								{       
									z=0;      
									var roott=xmlhttp.responseXML.documentElement;       
   									var ress=roott.getElementsByTagName("empname")[z].childNodes[0].nodeValue;   
           						    while(ress!=null)      
                          			{          
                   						addoptions(ress);       
                         				z++ ;         
                						var ress=roott.getElementsByTagName("empname")[z].childNodes[0].nodeValue; 
                               		}   
                        		} 
                       			function removeall()    
                        		{      
                     				var ct=document.dummy.sele2.length;   
                           			for(i=ct; i>=0; i--)
                               		{   
                       					document.dummy.sele2.options[i]=null;   
                                  	} 
                               	 }   
                           		function addoptions(reslt)  
                              	{      
                         			 var ct1=document.createElement("OPTION");   
                                	 ct1.text=reslt;  
                                     ct1.value=reslt; 
                              		 document.dummy.sele2.options.add(ct1); 
                                } 
                           }   
        xmlhttp.open("GET",urls,true);
         xmlhttp.send(); 
         }
 </script>
</head>
<body>
<form name="dummy"><font face="verdana" size="2"> Employee
Number:<select name="sele" onchange="loadXMLDoc()">
	<option>select</option>
	<option value="uh">100</option>
	<option value="uh">101</option>
</select> Employee Name: <select name="sele2">
	<option>--choose--</option>
</select></form>
</body>
</html>