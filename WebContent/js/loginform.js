function check()
	{
		var valid = 0;
		var js_msg="";
		if(document.loginform.userdesg.value=="none")
			{
				js_msg = js_msg.concat("<i>*Choose User Type</i><br />");
				valid=1;
			}
		if(document.loginform.userid.value.trim()=='')
			{
				js_msg = js_msg.concat("<i>*Enter User ID</i><br />");
				valid=1;
			}
		if(document.loginform.userpass.value.trim()=='')
			{
				js_msg = js_msg.concat("<i>*Enter Password</i>");
				valid=1;
			}
		if(valid)
			{
				document.getElementById("js_msg").innerHTML = js_msg;
				return false;
			}
		
	}
