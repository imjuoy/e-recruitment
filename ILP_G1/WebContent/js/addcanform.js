function check() {
   
	    var valid = 0;
		if (document.add_can.vid.value == "") 
		{
		    document.getElementById("vid_msg").innerHTML = "Enter Vacancy ID";
		    valid = 1;
		}
		else {
		    document.getElementById("vid_msg").innerHTML = "";
		    valid = 0;
		}
		
		if(valid)
			{
				return false;
			}
		
	}
