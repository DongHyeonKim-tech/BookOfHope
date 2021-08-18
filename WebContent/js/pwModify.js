/**
 * @author 이수아
 */

function pwModify() {

	if (document.frm.memPwCheck.value == "") {
		alert("변경할 비밀번호를 입력해주세요.");
		return false;
	}
	if (document.frm.memPw.value != document.frm.memPwCheck.value) {
		alert("비밀번호가 일치하지 않습니다.");
		return false;
	}
	return true;
}