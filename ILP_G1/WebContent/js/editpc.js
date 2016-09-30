function check() {
   
	    var valid = 0;
		if (document.addpc.pcname.value == "") 
		{
		    document.getElementById("pcname_msg").innerHTML = "*Enter Placement Consultant Name";
		    valid = 1;
		}
		else {
		    document.getElementById("pcname_msg").innerHTML = "";
			 }
		
		if (document.addpc.con.value == "") 
		{
		    document.getElementById("pc_con_msg").innerHTML = "*Enter Contact";
		    valid = 1;
		}
		else {
		    document.getElementById("pc_con_msg").innerHTML = "";
		    var i= document.addpc.con.value;
		    if(isNaN(i))
		    {
			document.getElementById("pc_con_msg").innerHTML = "*Enter a Valid Number";
			valid=1;
			}
		    if(document.addpc.con.value.length<10)
				{
					document.getElementById("pc_con_msg").innerHTML = "*Contact Should be of 10 digits";
					valid=1;
				}
		    }
		
		      if(valid)
				return false;
		else 
				return true;
		
	}
