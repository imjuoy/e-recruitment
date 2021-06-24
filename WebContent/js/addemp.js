function check()
{

var e=document.forms["add_emp"]["empid"].value;
var p=document.forms["add_emp"]["prjid"].value;
var u=document.forms["add_emp"]["unithead_id"].value;


	if (e=='0')
	  {
	  alert("Please select employee id");
	  return false;
	  }
	if (u=='0')
	  {
	  alert("Please select unithead id");
	  return false;
	  }
	if (p=='0')
	  {
	  alert("Please select project id");
	  return false;
	  }
	
}