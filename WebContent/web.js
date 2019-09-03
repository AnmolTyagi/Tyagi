function AuthenticationForm() {
	var authenticationStatus = true;
	var fname = document.forms["authentication"]["fname"].value;
	var lname = document.forms["authentication"]["lname"].value;
	var age = document.forms["authentication"]["age"].value;
	var radios = document.getElementsByName("gender");

	if (fname == "") {
		authenticationStatus = false;
	} else if (lname == "") {
		authenticationStatus = false;
	} else if (age == "") {
		authenticationStatus = false;
	}

	var len = radios.length;
	var chosen = "";

	for (i = 0; i < len; i++) {
		var gender = false;
		if (radios[i].checked) {
			gender = true;
			chosen = radios[i].value;
			break;
		}
	}

	if (!gender) {
		authenticationStatus = false;
	}

	if (!authenticationStatus) {
		alert("Form authentication fails.....");
	} else {
		alert("Form authentication Done.. ..");
	}

	return authenticationStatus;

}