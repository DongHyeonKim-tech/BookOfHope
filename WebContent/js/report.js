/**
 * @author 이수아
 */

function reportCheck() {

	if (document.frm.bookTitle.value == "") {
		alert("책을 선택해 주세요.");
		document.frm.selectBook.focus();
		return false;
	}
	if (document.frm.writer.value == "") {
		alert("책을 선택해 주세요.");
		document.frm.selectBook.focus();
		return false;

	}
	if (document.frm.publisher.value == "") {
		alert("책을 선택해 주세요.");
		document.frm.selectBook.focus();
		return false;

	}
	if (document.frm.reportTitle.value == "") {
		alert("제목을 입력해 주세요.");
		document.frm.reportTitle.focus();
		return false;

	}
	if (document.frm.reportContent.value == "") {
		alert("내용을 입력해 주세요.");
		document.frm.reportContent.focus();
		return false;
	}

	return true;
}
