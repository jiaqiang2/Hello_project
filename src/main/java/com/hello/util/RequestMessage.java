package com.hello.util;

import java.io.Serializable;

import com.hello.util.GatewayRequest;

/**
 * Created by qiong on 2016/3/9.
 */
public class RequestMessage<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	/** 业务实例 */
	//@NotNull		       
	private GatewayRequest gatewayRequest;
	/** 请求上下文 */
	//@NotNull
	private T requestContext;

	

	public GatewayRequest getGatewayRequest() {
		return gatewayRequest;
	}

	public void setGatewayRequest(GatewayRequest gatewayRequest) {
		this.gatewayRequest = gatewayRequest;
	}

	public T getRequestContext() {
		return requestContext;
	}

	public void setRequestContext(T requestContext) {
		this.requestContext = requestContext;
	}

	/**
	 * 请求合法性校验
	 */
	public void check() {
		// gatewayRequest.check();
	}

	@Override
	public String toString() {
		return "RequestMessage [gatewayRequest=" + gatewayRequest + ", requestContext=" + requestContext + "]";
	}

	
}
