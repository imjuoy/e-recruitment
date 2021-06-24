var idCheck = false;
var nameCheck = false;
var dobCheck = false;
var cross = "<img src='./images/cross.png'>";
var tick = "<img src='./images/tick.png'>";
function notEmptyId() {
	var elem = document.getElementById("id");
	if (elem.value.length == 0) {
		document.getElementById("idempty").innerHTML = cross + "Please enter the Candidate ID";
		idCheck = false;
	} else {
		document.getElementById("idempty").innerHTML = tick;
		idCheck = true;
	}
	check();
}
function notEmptyName() {
	var elem = document.getElementById("name");
	if (elem.value.length == 0) {
		
		document.getElementById("nameempty").innerHTML = cross + "Please enter Candidate's Name";
		nameCheck = false;
	} else {
		document.getElementById("nameempty").innerHTML = tick;
		nameCheck = true;
	}
	check();
}
function getMonth(val) { 
    var monthArray = new Array("JAN","FEB","MAR","APR","MAY","JUN", 
                               "JUL","AUG","SEP","OCT","NOV","DEC"); 
    for (var i=0; i<monthArray.length; i++) { 
      if (monthArray[i] == val) { 
        return(i); 
      }  
    } 
    return(-1); 
  } 

  function checkDob() {  
    var dobCheck = true;  
    var mo, day, yy, testDate;  
    var val = document.getElementById("dob");  

    var re = new RegExp("[0-9]{1,2}[-][A-Z]{3}[-][0-9]{4}", "g"); 
    if (re.test(val)) {  
      var delimChar = (val.indexOf("/") != -1) ? "/" : "-";  
      var delim1 = val.indexOf(delimChar);  
      var delim2 = val.lastIndexOf(delimChar);  
      day = parseInt(val.substring(0,delim1),10);  
      mo = getMonth(val.substring(delim1+1,delim2),10);  
      yy = parseInt(val.substring(delim2+1),10);  
      testDate = new Date(yy,mo,day);  
      if (testDate.getDate() == day) {  
        if (testDate.getMonth() == mo) {  
          if (!testDate.getFullYear() == yy) {  
        	  "Please enter your Role";
      		document.getElementById("dobempty").innerHTML = cross + "Please enter date in given format";
      		dobCheck = false;
          }  
        }  
        else {  
        	"Please enter your Role";
    		document.getElementById("dobempty").innerHTML = cross + "Please enter date in given format";
    		dobCheck = false;
        }  
      }  
      else {  
    	  "Please enter your Role";
  		document.getElementById("dobempty").innerHTML = cross + "Please enter date in given format";
  		dobCheck = false;
      }  
    }  
    else {  
    	"Please enter your Role";
		document.getElementById("dobempty").innerHTML = cross + "Please enter date in given format";
		dobCheck = false;
    }  

    if (success)  {
    	document.getElementById("dobempty").innerHTML = tick;
		dobCheck = true;
		}
    else  
      fld.focus();  

    check(); 
  }
function notEmptyDob() {
	var elem = document.getElementById("dob");
	if (elem.value.length == 0) {
		"Please enter your Role";
		document.getElementById("dobempty").innerHTML = cross + "Please enter date in given format";
		dobCheck = false;
	} else {
		document.getElementById("dobempty").innerHTML = tick;
		dobCheck = true;
	}
	check();
}
function check() {
	if (idCheck == true && nameCheck == true) {
		document.getElementById("submit").innerHTML = "<input type='submit' value='Add' />";
	} else {
		document.getElementById("submit").innerHTML = "&nbsp;";
	}
}
function emptyValidate() {
	if (idCheck == false ||nameCheck==false ) {
		notEmptyUsername();
		notEmptyPassword();
		return false;
	} else {
		return true;
	}
}
