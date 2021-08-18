/**
 * @author 박동준
 */

	function todayBookCheck() {
		
		
		if(document.frm.bookBrdTitle.value == "") {
			alert("이달의 책 제목을 입력해 주세요.");
			return false;
		}
		if(document.frm.bookTitle.value == "") {
			alert("책을 선택해주세요.");
			document.frm.selectBook.focus();
			return false;
		}
		if(document.frm.writer.value == "") {
			alert("책을 선택해주세요.");
			return false;
		}
		if(document.frm.publisher.value == "") {
			alert("책을 선택해주세요.");
			return false;
		}
		if(document.frm.bookBrdContent.value == "") {
			alert("내용을 입력해 주세요.");
			return false;
		}
		//에러
		if(document.frm.imgPath.value == "") {
			alert("파일 업로드를 해주세요.");
			return false;
		}
		
		return true;
	}

	
function open_win(url, name) {
	
	window.open(url, name, "width=500, height=230");
	
}

