package com.hello.pojo.admin;

import java.util.Arrays;

public class Callbackip extends BasePojo{
	
	private String[] ip_list;

	public String[] getIp_list() {
		return ip_list;
	}

	public void setIp_list(String[] ip_list) {
		this.ip_list = ip_list;
	}

	public Callbackip() {
		super();
	}

	public Callbackip(String[] ip_list) {
		super();
		this.ip_list = ip_list;
	}

	@Override
	public String toString() {
		return "Callbackip [ip_list=" + Arrays.toString(ip_list) + ", errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}
	
	
}
