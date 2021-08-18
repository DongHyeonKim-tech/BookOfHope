/**
 * @author koreakjm 김정민
 */

	function noticeCheck() {
		
		if(document.frm.noticeTitle.value == "") {
			alert("제목을 입력해 주세요.");
			document.frm.noticeTitle.focus();
			return false;
		}
		
		if(document.frm.noticeContent.value == "") {
			alert("내용을 입력해 주세요.");
			document.frm.noticeContent.focus();
			return false;
		}
		
		return true;
	}



//url = notice?command=noticeCheckPassForm&noticeNum=${notice.noticeNum}
//name = 'update'
function open_win(url, name) {
	
	window.open(url, name, "width=500, height=230");
	
}

