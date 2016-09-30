function check() {
   
	    var valid = 0;
		if (document.addrec.pos.value == "") 
		{
		    document.getElementById("pos_msg").innerHTML = "*Enter No.of Positions";
		    valid = 1;
		}
		else {
		    document.getElementById("loc_msg").innerHTML = "";
		    var i= document.addrec.pos.value;
		    if(isNaN(i))
		    {
			document.getElementById("pos_msg").innerHTML = "*Enter a Valid Number";
			valid=1;
			}
		     }
		     
		     
		if (document.addrec.skill.value == "") 
		{
		    document.getElementById("skill_msg").innerHTML = "*Enter Skills";
		    valid = 1;
		}
		else {
		    document.getElementById("skill_msg").innerHTML = "";
		    }
		    
		    
		if (document.addrec.exp.value == "none") 
		{
		    document.getElementById("exp_msg").innerHTML = "*Enter Experience";
		    valid = 1;
		}
		else {
		    document.getElementById("exp_msg").innerHTML = "";
		    }
		    
		if (document.addrec.loc.value == "") 
		{
		    document.getElementById("loc_msg").innerHTML = "*Enter Location";
		    valid = 1;
		}
		else {
		    document.getElementById("loc_msg").innerHTML = "";
		    }
		    
		if (document.addrec.dom.value == "") 
		{
		    document.getElementById("dom_msg").innerHTML = "*Enter Business Domain";
		    valid = 1;
		}
		else {
		    document.getElementById("dom_msg").innerHTML = "";
		    }  
		    
		if (document.addrec.doj.value == "") 
		{
		    document.getElementById("doj_msg").innerHTML = "*Enter Date of Joining";
		    valid = 1;
		} 
		else{
			document.getElementById("doj_msg").innerHTML = "";
			if(document.addrec.doj.value.length!=10 || document.addrec.doj.value.charAt(2)!='/' || document.addrec.doj.value.charAt(5)!='/')
			{
				document.getElementById("doj_msg").innerHTML = "*Enter Valid Date";
				valid = 1;
			}
		}
		
		if (document.addrec.pc.value == "") 
		{
		    document.getElementById("pc_msg").innerHTML = "*Enter Placement Consultant";
		    valid = 1;
		}
		else {
		    document.getElementById("pc_msg").innerHTML = "";
		    }  
		if(valid)
				return false;
		else 
				return true;
		
	}
