package com.itbook.vo;

import java.sql.Timestamp;


/**�냽�꽦
 * �쉶�썝�뀒�씠釉�
 * �쉶�썝踰덊샇
 * �쉶�썝�븘�씠�뵒
 * �쉶�썝鍮꾨�踰덊샇
 * 二쇰�쇰벑濡앸쾲�샇
 * �씠由�
 * �쟾�솕踰덊샇
 * �씠硫붿씪
 * 沅뚰븳
 * 媛��엯�씪�옄
**/
public class MemberVO {
	
	private String memNum;
	private String memId;
	private String memPw;
	private String jumin;
	private String memName;
	private String adr;
	private String adr2;
	private String phone;
	private String email;
	private String authority;
	private Timestamp signDate;
	//private String metNum;
	
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public String getAdr2() {
		return adr2;
	}
	public void setAdr2(String adr2) {
		this.adr2 = adr2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Timestamp getSignDate() {
		return signDate;
	}
	public void setSignDate(Timestamp signDate) {
		this.signDate = signDate;
	}
	@Override
	public String toString() {
		return "MemberVO [memNum=" + memNum + ", memId=" + memId + ", memPw=" + memPw + ", jumin=" + jumin
				+ ", memName=" + memName + ", adr=" + adr + ", adr2=" + adr2 + ", phone=" + phone + ", email=" + email
				+ ", authority=" + authority + ", signDate=" + signDate + "]";
	}
	

	
	
	




	
	



	
	
}
