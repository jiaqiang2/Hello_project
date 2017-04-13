package com.hello.pojo.admin;

public class BasePojo {
	
	public String errcode;
	
	public String errmsg;

	public BasePojo() {
		super();
	}

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public BasePojo(String errcode, String errmsg) {
		super();
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "BasePojo [errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}

	
	
}
