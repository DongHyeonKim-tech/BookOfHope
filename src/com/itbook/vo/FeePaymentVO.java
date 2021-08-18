package com.itbook.vo;

/**
 * �썑�썝踰덊샇
 * �썑�썝�옄紐�
 * �썑�썝�옄�씠硫붿씪
 * �썑�썝�옄�쟾�솕踰덊샇
 * �썑�썝�옄�슦�렪踰덊샇
 * �썑�썝�옄 �냼�냽
 * �썑�썝�옄 吏곴툒
 * �썑�썝�옄 硫붿꽭吏�
 * ���뻾
 * 湲덉븸
 * �썑�썝諛⑸쾿
 * 怨꾩쥖踰덊샇
 * @author �젙�썝
 *
 */

public class FeePaymentVO{
	private String payNum; 
	private String payName; 
	private String payEmail; 
	private String payMobileNumber; 
	private String payZipcode; 
	private String payAttach;
	private String payPosition;
	private String payMessage; 
	private String payBank; 
	private String payFee; 
	private String paySponsor; 
	private String payBankNum; 
	private String bankName;
	private String memNum;
	public String getPayNum() {
		return payNum;
	}
	public void setPayNum(String payNum) {
		this.payNum = payNum;
	}
	public String getPayName() {
		return payName;
	}
	public void setPayName(String payName) {
		this.payName = payName;
	}
	public String getPayEmail() {
		return payEmail;
	}
	public void setPayEmail(String payEmail) {
		this.payEmail = payEmail;
	}
	public String getPayMobileNumber() {
		return payMobileNumber;
	}
	public void setPayMobileNumber(String payMobileNumber) {
		this.payMobileNumber = payMobileNumber;
	}
	public String getPayZipcode() {
		return payZipcode;
	}
	public void setPayZipcode(String payZipcode) {
		this.payZipcode = payZipcode;
	}
	public String getPayAttach() {
		return payAttach;
	}
	public void setPayAttach(String payAttach) {
		this.payAttach = payAttach;
	}
	public String getPayPosition() {
		return payPosition;
	}
	public void setPayPosition(String payPosition) {
		this.payPosition = payPosition;
	}
	public String getPayMessage() {
		return payMessage;
	}
	public void setPayMessage(String payMessage) {
		this.payMessage = payMessage;
	}
	public String getPayBank() {
		return payBank;
	}
	public void setPayBank(String payBank) {
		this.payBank = payBank;
	}
	public String getPayFee() {
		return payFee;
	}
	public void setPayFee(String payFee) {
		this.payFee = payFee;
	}
	public String getPaySponsor() {
		return paySponsor;
	}
	public void setPaySponsor(String paySponsor) {
		this.paySponsor = paySponsor;
	}
	public String getPayBankNum() {
		return payBankNum;
	}
	public void setPayBankNum(String payBankNum) {
		this.payBankNum = payBankNum;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getMemNum() {
		return memNum;
	}
	public void setMemNum(String memNum) {
		this.memNum = memNum;
	}
	
	@Override
	public String toString() {
		return "FeePaymentVO [payNum=" + payNum + ", payName=" + payName + ", payEmail=" + payEmail
				+ ", payMobileNumber=" + payMobileNumber + ", payZipcode=" + payZipcode + ", payAttach=" + payAttach
				+ ", payPosition=" + payPosition + ", payMessage=" + payMessage + ", payBank=" + payBank + ", payFee="
				+ payFee + ", paySponsor=" + paySponsor + ", payBankNum=" + payBankNum + ", bankName=" + bankName
				+ ", memNum=" + memNum + "]";
	}
	


	
}

