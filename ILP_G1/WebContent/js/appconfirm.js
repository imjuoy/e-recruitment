function apconfirm(c)
{
var r=confirm("Are you sure you want to approve this vacancy request ??");
if (r==true)
  {
	document.forms[c].method = "post";
	document.forms[c].submit();
    }
  
else
  {
	document.forms[c].method = "get";
	document.forms[c].submit();
  } 

}
