function returnPrevious() {
	// var xmlhttp
	// if (window.XMLHttpRequest) {
	// xmlhttp = new XMLHttpRequest;
	// } else {
	// xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	// }
	//
	// xmlhttp.onreadystatechange = function() {
	// if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
	// document.getElementById("items").style.display = "none";
	// }
	// }
	window.history.go(-1);
}

function buy() {
	window.location.href = "buy.do";
}