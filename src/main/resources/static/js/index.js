function hideItem() {
	var divStyle = document.getElementById("bought").style.display
	if (divStyle == "" || divStyle == "block") {
		document.getElementById("bought").style.display = "none";
	} else {
		document.getElementById("bought").style.display = "block";
	}
}