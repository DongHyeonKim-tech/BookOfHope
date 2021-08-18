/**
 * @author koreakjm 김정민
 */

	function metboardCheck() {
		
		
		if(document.frm.metBrdName.value == "") {
			alert("제목을 입력해 주세요.");
			return false;
		}
		
		if(document.frm.metBrdContent.value == "") {
			alert("내용을 입력해 주세요.");
			return false;
		}
		
		return true;
	}



//url = notice?command=noticeCheckPassForm&noticeNum=${notice.noticeNum}
//name = 'update'
function open_win(url, name) {
	
	window.open(url, name, "width=500, height=230");
	
}

