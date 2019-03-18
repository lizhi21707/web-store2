function checkForm() {

	var flag = true;

	var itemTitle = document.getElementById("item-title-input").value;
	if(itemTitle.length < 2 || itemTitle.length > 80) {
		document.getElementById("title-hint").style.display = "block";
		flag = false;
	}

	var itemAbstract = document.getElementById("item-abstract-input").value;
	if(itemAbstract.length < 2 || itemAbstract.length > 140) {
		document.getElementById("abstract-hint").style.display = "block";
		flag = false;
	}

	var itemPrice = document.getElementById("item-price-input").value;
	if(itemPrice < 0) {
		document.getElementById("price-hint").style.display = "block";
		flag = false;
	}

	var itemTotal = document.getElementById("item-total-input").value;
	if(itemTotal.length < 2 || itemTotal.length > 1000) {
		document.getElementById("total-hint").style.display = "block";
		flag = false;
	}

	return flag;

}

function getPhotoSize(obj) {
	var fileSize = 0;
	var isIE = /msie/i.test(navigator.userAgent) && !window.opera;
	if(isIE && !obj.files) {
		var filePath = obj.value;
		var fileSystem = new ActiveXObject("Scripting.FileSystemObject");
		var file = fileSystem.GetFile(filePath);
		fileSize = file.Size;
	} else {
		fileSize = obj.files[0].size;
	}
	fileSize = Math.round(fileSize / 1024 * 100) / 100; //单位为KB
	if(fileSize >= 1024) {
		document.getElementById("file-hint").style.display = "block";
		document.getElementById("inputFile").value = "";
		return false;
	}
	
	return true;
}

function to_change() {
	var obj = document.getElementsByName('imgRadio');
	for(var i = 0; i < obj.length; i++) {
		if(obj[i].checked == true) {
			if(obj[i].value == 'file') {
				document.getElementById('file-block').style.display = "block";
				document.getElementById('url-block').style.display = "none";
			} else if(obj[i].value == 'url') {
				document.getElementById('url-block').style.display = "block";
				document.getElementById('file-block').style.display = "none";
			}
		}
	}
}