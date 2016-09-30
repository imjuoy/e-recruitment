function getdesg()
{ var xmlhttp; 
var v=document.dummy.empid.value;
var urls="get_desg.jsp?ok="+v;
if (window.XMLHttpRequest) 
{   xmlhttp=new XMLHttpRequest();  
} 
else
{   xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");  
}
xmlhttp.onreadystatechange=function() 
{   
if (xmlhttp.readyState==4) 
{       
	z=0;      
	var roott=xmlhttp.responseXML.documentElement;       
    var ress=roott.getElementsByTagName("designation")[z].childNodes[0].nodeValue;
                   while(ress!=null)      
                           {     
                	 addoptions(ress);       
                         z++ ;         
                var ress=roott.getElementsByTagName("designation")[z].childNodes[0].nodeValue; 
                               }   
                        } 
                      
                           function addoptions(reslt)  
                              {    
                        	   //alert(reslt);
                          document.getElementById("a").innerHTML=reslt; 
                                    } 
                           }   
        xmlhttp.open("GET",urls,true);
         xmlhttp.send(); 
         }