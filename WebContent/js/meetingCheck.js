/**
 * @author 정원 독서모임 신청확인란 유효성검사 빈칸이 발생했을 때 return 값과 체크박스 선택검사
 */

function meetingCheck() {

	if (document.frm.metName.value == "") {
		alert("독서모임명을 입력하세요.");
		return false;
	}
	/*
	 * if (document.frm.metIntro.value == "") { alert("독서모임소개글을 입력하세요."); return
	 * false; }
	 */
	if (document.frm.represent.value == "") {
		alert("대표자명을 입력하세요.");
		document.frm.represent.focus();
		return false;
	}
	
	if (document.frm.metGreeting.value == "") {
		alert("모임 인사말을 입력하세요.");
		document.frm.metGreeting.focus();
		return false;
	}
	
	if (document.frm.metPlace.value == "") {
		alert("모임 활동 지역을 선택해주세요.");
		document.frm.metPlace.focus();
		return false;
	}

	if (document.frm.keyword.value == "") {
		alert("카테고리를 선택해주세요.");
		return false;
	}

	return true;
}

// checkbox 유효성 검사
function checkSub() {

	var boxCount = 0;
	var checkboxs = document.getElementsByName("checkSub[]");
	var url = "meeting?command=meetingApply";

	for (var i = 0; i < checkboxs.length; i++) {
		if (eval(checkboxs[i].checked) == true) {
			boxCount++;
		}
		if (boxCount <= 0) {
			alert("활동주제를 선택해주세요.");
			return;
		} else {
			document.checkSub.submit(url);
		}
	}

}