/**
 * @author 박동준
 */

	function bookstoreCheck() {
		
		
		if(document.frm.bookstoreTitle.value == "") {
			alert("책방을 입력해 주세요.");
			return false;
		}
		
		if(document.frm.bookstoreContent.value == "") {
			alert("책방 주소를 입력해 주세요.");
			return false;
		}
		return true;
	}


function open_win(url, name) {
	
	window.open(url, name, "width=500, height=230");
	
}

