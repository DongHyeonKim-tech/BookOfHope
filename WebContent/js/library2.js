/**
 * @author 이수아
 */

function libraryCheck() {

	if (document.frm.libraryTitle.value == "") {
		alert("도서관 명을 입력해 주세요.");
		return false;
	}

	if (document.frm.libraryContent.value == "") {
		alert("도서관 위치를 입력해 주세요.");
		return false;

	}
	if (document.frm.libraryUrl.value == "") {
		alert("도서관 URL를 입력해 주세요.");
		return false;
	}
	
	return true;
}

