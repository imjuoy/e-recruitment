function check()
{ 
	var js_msg="<br /><br />";
	var check_radio = 0;  
	valid = 0;
	var nRadio = document.addrecreq.VR_ID;
	
	for(var i=0;i<nRadio.length;i++)
	{
		if(nRadio[i].checked==true)
		{
			check_radio = 1;  // = 0, if any of the radio button is selected
			break;
	    }
	}
	
	if(check_radio==0)  // enters if none is selected...
	{
		js_msg = js_msg.concat("<i>*Choose a Vacancy Request</i><br />");	
		valid = 1;
	}
	
	if (document.addrecreq.PC_ID.value == "none") 
	{
	    js_msg = js_msg.concat("<i>*Choose a Placement Consultant</i><br />");
		valid = 1;
	}
	
	if(valid)
	{
		document.getElementById("js_msg").innerHTML = js_msg;
		return false;
	}
    else 
		return true;
		
}
     