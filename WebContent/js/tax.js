/**
 * @author koreakjm 김정민
 */

	function taxCheck() {
		
		
		if(document.frm.taxName.value == "") {
			alert("이름을 입력해 주세요.");
			return false;
		}
		
		if(document.frm.taxEmail.value == "") {
			alert("이메일을 입력해 주세요.");
			return false;
		}
		
		if(document.frm.taxPhone.value == "") {
			alert("연락처를 입력해 주세요.");
			return false;
		}
		
		alert("신청되었습니다.");
		return true;
	}



//url = notice?command=noticeCheckPassForm&noticeNum=${notice.noticeNum}
//name = 'update'
function open_win(url, name) {
	
	window.open(url, name, "width=500, height=230");
	
}

