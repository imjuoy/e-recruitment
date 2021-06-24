function check()
{
var a=document.forms["addschedule"]["adminid"].value;
var start=document.forms["addschedule"]["fdate"].value;
var end = document.forms["addschedule"]["tdate"].value;
var stDate = new Date(start);
var enDate = new Date(end);
var compDate = enDate - stDate;




if (a=='0')
{
alert("Please select administrator id");

return false;
}

/*
if(compDate=="0");
{
	
alert("Please Enter the correct date ");
return false;
}*/
}