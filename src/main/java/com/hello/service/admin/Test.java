package com.hello.service.admin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.commons.collections.MapUtils;
import org.apache.http.client.methods.HttpGet;
import org.springframework.http.HttpMethod;

import com.hello.pojo.admin.Access_token;
import com.hello.pojo.admin.Admin;
import com.hello.pojo.admin.BasePojo;
import com.hello.pojo.admin.Callbackip;
import com.hello.pojo.admin.Menu;
import com.hello.pojo.admin.MenuInfo;
import com.hello.pojo.admin.TextNotice;
import com.hello.util.API;
import com.hello.util.JsonUtils;
import com.hello.util.LoadUtil;
import com.hello.util.RestClientBuilder;
import com.thoughtworks.xstream.XStream;

public class Test {
	
	public static Object getAccess_token(String appID, String appsecret){
		String url = LoadUtil.getUrl(API.TOKEN + "&appid=" + appID + "&secret=" + appsecret);
		Object  obj = RestClientBuilder.exchange(url, HttpMethod.GET, null, Object.class);
		return obj;
	}
	
	public static Object getCallbackip(String access_token){
		String url = LoadUtil.getUrl(API.GETCALLBACKIP + "?access_token=" + access_token);
		Object  obj = RestClientBuilder.exchange(url, HttpMethod.GET, null, Object.class);
		return obj;
	}
	
	public static Object createMenu(String access_token, Menu button){
		String url = LoadUtil.getUrl(API.CREATEMENU + "?access_token=" + access_token);
		System.out.println("入参  "+button);
		Object  obj = RestClientBuilder.exchange(url, HttpMethod.POST, button, Object.class);
		return obj;
	}
	public static Object getMenu(String access_token) {
		String url = API.API_URL + API.GETMENU + "?access_token=" + access_token;
		Object obj = RestClientBuilder.exchange(url, HttpMethod.GET, null, Object.class);
		return obj;
	}
	public static Object deleteMenu(String access_token) {
		String url = API.DELETEMENU + "?access_token=" + access_token;
		Object obj = RestClientBuilder.exchange(url, HttpMethod.GET, null, Object.class);
		return obj;
	}
	public static Object createPersonalMenu(String access_token, Menu button){
		String url = LoadUtil.getUrl(API.PERSONALMENU + "?access_token=" + access_token);
		Object  obj = RestClientBuilder.exchange(url, HttpMethod.POST, button, Object.class);
		return obj;
	}
	public static void main(String[] args) {
//		Object oo = Test.getAccess_token("wx69b8aaa43aef3792","232cabf26803ecd338107e97c0dab714");
//		Test.all(oo, Access_token.class);
//		Object oo = Test.getCallbackip("tq2xM1mVbRGq-oFXEpD9W3GWPmqSXg9t53AO-gkZaO8nXL1Gz0ax1ULWJzU1M6eAjmSwCeBLTVqAyBAdpsS3f1aAlC7dYwB7ygjnpT8Q29_T0pN1vs98kZJhK3hwr89PCCIdABAFFL");
//		Test.all(oo, Callbackip.class);
		//消息文本测试
//		TextNotice textNotice = new TextNotice("292270301", "1", 1348831860, "text", "好久不见", 1);
//		
//		XStream xstream = new XStream(); 
//		xstream.alias("xml", TextNotice.class);
//		String xml = xstream.toXML(textNotice);         
//	    System.out.println(xml);
	    
		//获取菜单
//		Object oo = Test.getMenu("Bx2KVF0c_F7KvdJObOgTlFXWOoSux4sHAbHUhrQhavszV1cx9XAsCLhnOQODL2ALwdqSoRkyusbSRafB_QqOhz4DmoOwgaz-J8tZgdUde-oq9kYnXFIn1Rh20n-918plXMMeAJAPEE");
//		Test.all(oo, Menu.class);
		
		
		
	    //注解
//		Map<String, Object> map = new HashMap<String, Object>();
//    	map.put("id", 1);
//    	map.put("username", "aa");
//    	map.put("passwor", "bb");
//		AdminService adminService = new AdminService();
//		adminService.add(admin)
		
	    
		
		//创建菜单
		MenuInfo[] button = new MenuInfo[]{new MenuInfo(),new MenuInfo()};
		MenuInfo[] sub_button = new MenuInfo[]{new MenuInfo(),new MenuInfo(),new MenuInfo()};
		sub_button[0] = new MenuInfo("click", "", "歌曲", "SONG", "", null);
		sub_button[1] = new MenuInfo("view", "", "舞蹈", "", "http://www.soso.com/", null);
		sub_button[2] = new MenuInfo("view", "", "视频", "", "http://v.qq.com/", null);
		button[0] = new MenuInfo("click", "", "天气预报", "WEATHER", "", null);
		button[1] = new MenuInfo("", "", "菜单", "", "", sub_button);
		Menu bt = new Menu();
		bt.setButton(button);
		Object oo = Test.createMenu("-Jm8lXoENq9myQ8iJN9cP4abT8a54Nmh9U5lvT3aFElkih_rewxB4HUxdtQPfqOeQbapm5R7o09T_D1TIsozQwx9oY_pmDMwd7V07gRAxPgEecp7RRgmrM-MqnrXXX3_VCEfAEAOVX", bt);
		Test.all(oo, BasePojo.class);
		
//		Map<String, Admin> map = new HashMap<String, Admin>();
//		
//		Admin a = new Admin(1, "1", "2");
//		Admin b = new Admin(2, "3", "4");
//		Admin c = new Admin(3, "4", "5");
//		map.put("a", a);
//		map.put("b", b);
//		map.put("c", c);
//		for (String string : map.keySet()) {
//			//System.out.println(map.keySet());//返回key数组
//			System.out.println(MapUtils.getString(map, string));
//		}
//		Set<Admin> aa = new HashSet<Admin>(); 
//		
//		aa.add(c);
//		aa.add(a);
//		aa.add(b);
//		for (Admin admin : aa) {
//			System.out.println(admin.getPassword());
//		}
	}
	
	public static <T> void all(Object oo, Class<T> obj ){
		try {
			T object = JsonUtils.jsonToObject(oo, obj);
			System.out.println(object);
		} catch (Exception e) {
			System.out.println(oo);
			System.out.println("异常");
			e.printStackTrace();
		}
	}
	
	public static HttpGet getPostMethod(String url) {    
		HttpGet pmethod = new HttpGet(url);   
		pmethod.addHeader("Connection", "keep-alive");    
		pmethod.addHeader("Accept", "*/*");    
		pmethod.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");    
		pmethod.addHeader("Host", "qyapi.weixin.qq.com");    
		pmethod.addHeader("X-Requested-With", "XMLHttpRequest");    
		pmethod.addHeader("Cache-Control", "max-age=0");    
		pmethod.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");    
		return pmethod;    
	}
	
	
}
