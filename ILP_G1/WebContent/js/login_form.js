var usernameCheck = false;
var passwordCheck = false;
var cross = "<img src='./images/cross.png'>";
var tick = "<img src='./images/tick.png'>";
function notEmptyUsername() {
	var elem = document.getElementById("userName");
	if (elem.value.length == 0) {
		document.getElementById("userempty").innerHTML = cross + "Please enter your Username";
		usernameCheck = false;
	} else {
		document.getElementById("userempty").innerHTML = tick;
		usernameCheck = true;
	}
	check();
}
function notEmptyPassword() {
	var elem = document.getElementById("password");
	if (elem.value.length == 0) {
		"Please enter your Password";
		document.getElementById("passempty").innerHTML = cross + "Please enter your Password";
		passwordCheck = false;
	} else {
		document.getElementById("passempty").innerHTML = tick;
		passwordCheck = true;
	}
	check();
}
function notEmptyRole() {
	var elem = document.getElementById("role");
	if (elem.value.length == 0) {
		"Please enter your Role";
		document.getElementById("roleempty").innerHTML = cross + "Please enter your Role";
		roleCheck = false;
	} else {
		document.getElementById("roleempty").innerHTML = tick;
		roleCheck = true;
	}
	check();
}
function check() {
	if (usernameCheck == true && passwordCheck == true) {
		document.getElementById("submit").innerHTML = "<input type='submit' value='Login' />";
	} else {
		document.getElementById("submit").innerHTML = "&nbsp;";
	}
}
function emptyValidate() {
	if (usernameCheck == false || passwordCheck == false) {
		notEmptyUsername();
		notEmptyPassword();
		return false;
	} else {
		return true;
	}
}
