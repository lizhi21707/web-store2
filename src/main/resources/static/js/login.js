function checkForm() {

	var username = document.getElementById("username").value;
	if (username.length < 5) {
		document.getElementById("username").value = "";
		document.getElementById("username").placeholder = "用户名至少5位";

		return false;
	}

	var password = document.getElementById("password").value;
	if (password.length < 5) {
		document.getElementById("password").value = "";
		document.getElementById("password").placeholder = "密码至少5位";

		return false;
	}
	var md5_password = hex_md5(password);
	document.getElementById("password").value = md5_password;

	return true;

}