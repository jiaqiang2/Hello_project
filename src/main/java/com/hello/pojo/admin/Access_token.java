package com.hello.pojo.admin;

public class Access_token extends BasePojo {
	
	private String access_token;   //获取到的凭证
	
	private int expires_in;     //凭证有效时间，单位：秒 

	public Access_token() {
		super();
	}

	public Access_token(String access_token, int expires_in) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public int getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "Access_token [access_token=" + access_token + ", expires_in=" + expires_in + ", errcode=" + errcode
				+ ", errmsg=" + errmsg + "]";
	}

	

	
}
