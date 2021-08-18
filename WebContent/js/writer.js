/**
 * @author 박동준
 */

	function writerCheck() {
		
		
		if(document.frm.writerName.value == "") {
			alert("작가 이름을 입력해 주세요.");
			return false;
		}
		if(document.frm.writerBook1.value == "") {
			alert("도서 이름을 입력해 주세요.");
			return false;
		}
	
		return true;
	}

	
function open_win(url, name) {
	
	window.open(url, name, "width=500, height=230");
	
}

