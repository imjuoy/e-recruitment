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
{   removeall();     
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
                           for(i=ct; i>=0; i--)    {   
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