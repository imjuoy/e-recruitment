function check() {
   
	    var valid = 0;
		if (document.addvacreq.vactype.value == "none") 
		{
		    document.getElementById("vactype_msg").innerHTML = "*Please Select a Vacancy Type";
		    valid = 1;
		}
		else {
		    document.getElementById("vactype_msg").innerHTML = "";
		    
			}
		     
		if (document.addvacreq.proj.value == "none") 
		{
		    document.getElementById("proj_msg").innerHTML = "*Please Select a Project";
		    valid = 1;
		}
		else {
		    document.getElementById("proj_msg").innerHTML = "";
		    }
			
		if (document.addvacreq.loc.value == "none") 
		{
		    document.getElementById("loc_msg").innerHTML = "*Please Select a Location";
		    valid = 1;
		}
		else {
		    document.getElementById("loc_msg").innerHTML = "";
		    }
		    
		if (document.addvacreq.nmbrvac.value == "") 
		{
		    document.getElementById("nmbrvac_msg").innerHTML = "*Please Enter no.of  Vacancy";
		    valid = 1;
		}
		else {
		    document.getElementById("nmbrvac_msg").innerHTML = "";
	    	var i= document.addvacreq.nmbrvac.value;
			if(isNaN(i))
			{
			document.getElementById("nmbrvac_msg").innerHTML = "*Please Enter a Valid Number";
			valid=1;
			}
		}
		
			
		if (document.addvacreq.req_by_date.value == "") 
		{
		    document.getElementById("req_by_date_msg").innerHTML = "*Please Enter Required By Date";
		    valid = 1;
		} 
		else{
			document.getElementById("req_by_date_msg").innerHTML = "";
			
		}
		if(valid)
				return false;
		else 
				return true;
		
	}