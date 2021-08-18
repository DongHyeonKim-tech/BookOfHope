function readBookCheck() {

	if (document.frm.bookName.value == "") {
		alert("책 제목을 입력해 주세요.");
		document.frm.bookName.focus();
		return false;
	}
	if (document.frm.writer.value == "") {
		alert("작가의 이름을 입력해 주세요.");
		document.frm.writer.focus();
		return false;
	}
	if (document.frm.publisher.value == "") {
		alert("출판사를 입력해 주세요.");
		document.frm.publisher.focus();
		return false;
	}
	if (document.frm.publishDate.value == "") {
		alert("출판 연도를 입력해주세요.");
		document.frm.publishDate.focus();
		return false;
	}
	if (document.frm.readBookContents.value == "") {
		alert("내용을 입력해주세요.");
		document.frm.readBookContents.focus();
		return false;
	}

	return true;
}

function open_win(url, name) {

	window.open(url, name, "width=500, height=230");

}