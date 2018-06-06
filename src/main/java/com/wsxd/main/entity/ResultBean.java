package com.wsxd.main.entity;
/**
 * 
 * @author lenovo
 *
 */
public class ResultBean {
	private String clientId;
	private String appKey;
	private String roundStr;
	private String reqId;
	private String resultCode;
	private String resultMsg;
	private String sign;
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getRoundStr() {
		return roundStr;
	}
	public void setRoundStr(String roundStr) {
		this.roundStr = roundStr;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	@Override
	public String toString() {
		return "Result [clientId=" + this.clientId + ", appKey=" + this.appKey + ", roundStr=" + this.roundStr + ", reqId=" + this.reqId + ", resultCode=" + this.resultCode + ", resultMsg=" + this.resultMsg + ", sign=" + this.sign + "]";
	}
}
