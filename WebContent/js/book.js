/**
 * @author 박동준
 */

	function bookCheck() {
		
		
		if(document.frm.bookTitle.value == "") {
			alert("책 제목을 입력해 주세요.");
			return false;
		}
		if(document.frm.isbn.value == "") {
			alert("ISBN을 입력해 주세요.");
			return false;
		}
		if(document.frm.bookKeyword1.value == "") {
			alert("키워드를 입력해 주세요.");
			return false;
		}
		if(document.frm.publisher.value == "") {
			alert("출판사를 입력해 주세요.");
			return false;
		}
		
		
		return true;
	}


function open_win(url, name) {
	
	window.open(url, name, "width=500, height=230");
	
}

