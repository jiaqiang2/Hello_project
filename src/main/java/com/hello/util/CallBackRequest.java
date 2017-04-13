package com.hello.util;

import java.io.Serializable;
import java.util.List;

/**
 * 回调基类 Created by zxh,2016年7月18日
 *
 */
public class CallBackRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serviceName;
	private String timestamp;
	private String account;
	private List<Date> data;
	private String signature;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public List<Date> getData() {
		return data;
	}

	public void setData(List<Date> data) {
		this.data = data;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
