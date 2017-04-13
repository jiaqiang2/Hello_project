package com.hello.util;

public class API {
	
	public final static String API_URL = "https://api.weixin.qq.com/cgi-bin/";      //基础
	
	public final static String TOKEN = "token?grant_type=client_credential";        //获取接口调用凭证
	
	public final static String GETCALLBACKIP = "getcallbackip";                     //获取微信服务器IP地址
	
	public final static String CREATEMENU = "menu/create";
	
	public final static String PERSONALMENU = "menu/addconditional";
	
	public final static String GETMENU ="menu/get";
	
	public final static String DELETEMENU = "menu/delete";
}
