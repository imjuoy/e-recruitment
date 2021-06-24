function validateForm()
{

var x=document.forms["loginform"]["desig"].value;
var y=document.forms["loginform"]["id"].value;
var v=document.forms["loginform"]["pwd"].value;
var passid_len = v.length; 
var letters = /^[0-9a-zA-Z]+$/;   
 

	if (x=='none')
	  {
	  alert("Please select designation");
	  return false;
	  }
	
	if (y==null || y=="")
	  {
	  alert("Employee ID must be filled out");
	  return false;
	  }
	
	if (passid_len==0)   
	{   
	
	alert("Password should not be empty ");   
	//passid.focus(); 
	return false;  
	}

}