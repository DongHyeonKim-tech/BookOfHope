function eventCheck() {

	if (document.frm.eventName.value == "") {
		alert("제목을 입력해 주세요.");
		return false;
	}

	if (document.frm.eventPlace.value == "") {
		alert("장소를 입력해 주세요.");
		return false;
	}

	if (document.frm.eventDate.value == "") {
		alert("일자를 입력해 주세요.");
		return false;
	}

	if (document.frm.eventContents.value == "") {
		alert("내용을 입력해 주세요.");
		return false;
	}

	return true;
}

// name = 'update'
function open_win(url, name) {

	window.open(url, name, "width=500, height=230");

}