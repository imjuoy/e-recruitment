function check() {
   
	    var valid = 0;
		if (document.addvac.pos.value == "") 
		{
		    document.getElementById("pos_msg").innerHTML = "*Enter No.of Positions";
		    valid = 1;
		}
		else {
		    document.getElementById("loc_msg").innerHTML = "";
		    var i= document.addvac.pos.value;
		    if(isNaN(i))
		    {
			document.getElementById("pos_msg").innerHTML = "*Enter a Valid Number";
			valid=1;
			}
		     }
		     
		     
		if (document.addvac.skill.value == "") 
		{
		    document.getElementById("skill_msg").innerHTML = "*Enter Skills";
		    valid = 1;
		}
		else {
		    document.getElementById("skill_msg").innerHTML = "";
		    }
		    
		    
		if (document.addvac.exp.value == "none") 
		{
		    document.getElementById("exp_msg").innerHTML = "*Enter Experience";
		    valid = 1;
		}
		else {
		    document.getElementById("exp_msg").innerHTML = "";
		    }
		    
		if (document.addvac.loc.value == "") 
		{
		    document.getElementById("loc_msg").innerHTML = "*Enter Location";
		    valid = 1;
		}
		else {
		    document.getElementById("loc_msg").innerHTML = "";
		    }
		    
		if (document.addvac.dom.value == "") 
		{
		    document.getElementById("dom_msg").innerHTML = "*Enter Business Domain";
		    valid = 1;
		}
		else {
		    document.getElementById("dom_msg").innerHTML = "";
		    }  
		    
		if (document.addvac.doj.value == "") 
		{
		    document.getElementById("doj_msg").innerHTML = "*Enter Date of Joining";
		    valid = 1;
		} 
		else{
			document.getElementById("doj_msg").innerHTML = "";
			if(document.addvac.doj.value.length!=10 || document.addvac.doj.value.charAt(2)!='/' || document.addvac.doj.value.charAt(5)!='/')
			{
				document.getElementById("doj_msg").innerHTML = "*Enter Valid Date";
				valid = 1;
			}
		}
		if(valid)
				return false;
		else 
				return true;
		
	}
