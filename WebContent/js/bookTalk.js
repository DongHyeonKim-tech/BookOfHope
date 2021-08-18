/**
 * @author 박동준
 */

function bookTalkCheck() {

	if (document.frm.talkName.value == "") {
		alert("도서명을 입력해 주세요.");
		document.frm.talkName.focus();
		return false;
	}

	if (document.frm.writer.value == "") {
		alert("저자를 입력해 주세요.");
		document.frm.writer.focus();
		return false;
	}

	if (document.frm.talkPublisher.value == "") {
		alert("출판사를 입력해 주세요.");
		document.frm.talkPublisher.focus();
		return false;
	}

	if (document.frm.talkDate.value == "") {
		alert("모임 일자를 입력해 주세요.");
		document.frm.talkDate.focus();
		return false;
	}

	return true;
}

function open_win(url, name) {

	window.open(url, name, "width=500, height=230");

}
