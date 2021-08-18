/**
 * @author 박동준
 */

	function donationCheck() {
		
		
		if(document.frm.payName.value == "") {
			alert("후원자 이름을 입력해 주세요.");
			return false;
		}
		if(document.frm.payEmail.value == "") {
			alert("이메일을 입력해 주세요.");
			return false;
		}
		if(document.frm.payMobileNumber.value == "") {
			alert("핸드폰 번호를 입력해 주세요.");
			return false;
		}
		if(document.frm.payBank.value == "") {
			alert("은행을 선택해 주세요.");
			return false;
		}
		
		if(document.frm.bankName.value == "") {
			alert("예금주를 입력해 주세요.");
			return false;
		}
		if(document.frm.payBankNum.value == "") {
			alert("계좌번호를 입력해 주세요.");
			return false;
		}
		if(document.frm.payFee.value == "") {
			alert("금액을 입력해 주세요.");
			return false;
		}
		if(document.frm.paySponsor.value == "") {
			alert("후원방식을 선택해 주세요.");
			return false;
		}
		
		return true;
	}


function open_win(url, name) {
	
	window.open(url, name, "width=500, height=230");
	
}

