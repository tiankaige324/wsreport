package com.wsxd.main.entity;

import com.wsxd.main.utils.Md5ToolUtil;
import com.wsxd.main.utils.PropertyUtil;
import com.wsxd.main.utils.RandomUtil;

/**
 * 
 * @author lenovo
 *
 */
public class BaseReqBean {

	private String clientId=PropertyUtil.getProperty("clientId");
	private String roundStr=RandomUtil.generateString(10);
	private String appKey=PropertyUtil.getProperty("appKey");
	private String token=Md5ToolUtil.getMd5Code("clientId="+this.clientId+"&roundStr="+this.roundStr+"&appKey="+this.appKey);
	private String reqId;
	private String sign;
	
	
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getRoundStr() {
		return roundStr;
	}
	public void setRoundStr(String roundStr) {
		this.roundStr = roundStr;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getReqId() {
		return reqId;
	}
	public void setReqId(String reqId) {
		this.reqId = reqId;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
}
