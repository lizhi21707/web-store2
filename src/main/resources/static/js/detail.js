function addToChart(itemid) {
	var result = confirm("确定添加到购物车？");
	if (result == true) {
		var count = document.getElementById("input-count").value;
		if (count == "" || isNaN(count)) {
			window.location.href = "addtochart.do?itemid=" + itemid
					+ "&count=1";
		} else {
			if (count <= 0) {
				count = 1;
			}
			window.location.href = "addtochart.do?itemid=" + itemid + "&count="
					+ count;
		}
	}
}

function addCount() {

	var current = document.getElementById("input-count").value;
	current++;
	document.getElementById("input-count").value = current;
}

function minusCount() {
	var current = document.getElementById("input-count").value;
	current--;
	if (current <= 0) {
		document.getElementById("input-count").value = 1;
	} else {
		document.getElementById("input-count").value = current;
	}

}