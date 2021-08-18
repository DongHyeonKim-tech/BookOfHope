/**
 * @author Kim Jong Uk
 */

function popupOpen() {
	var popUrl = "popup.jsp"; // 팝업창에 출력될 url

	var popOption = "width=550, height=400, resizable=no, scrollbars=no, status=no;"; // 팝업창
																						// 옵션(optoin)
	window.open(popUrl, "", popOption);

}

function sendToParent(){
	window.opener.document.frm.memId.value = document.frm.memId.value;
	self.close();
	
}

function characterCheck() {
    var RegExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=]/gi;//정규식 구문
    var hangle = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
    var obj = document.getElementsByName("memId")[0]
    var han = document.getElementsByName("memId")[0]
    if (RegExp.test(obj.value)) {
    	alert("특수문자는 입력 불가능합니다.")
        obj.value = obj.value.substring(0, obj.value.length - 1);//특수문자를 지우는 구문
        
    }
    if(hangle.test(han.value)){
    	alert("한글은 입력 불가능합니다.")
    	han.value = han.value.substring(0, han.value.length - 1);
    }
}





