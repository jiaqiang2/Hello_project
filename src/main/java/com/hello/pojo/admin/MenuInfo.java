package com.hello.pojo.admin;

import java.util.Arrays;

public class MenuInfo {
	
	private String type;
	private String media_id;
	private String name;
	private String key;
	private String url;
	private MenuInfo[] sub_button;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public MenuInfo[] getSub_button() {
		return sub_button;
	}
	public void setSub_button(MenuInfo[] sub_button) {
		this.sub_button = sub_button;
	}
	public MenuInfo() {
		super();
	}
	
	
	public MenuInfo(String type, String media_id, String name, String key, String url, MenuInfo[] sub_button) {
		super();
		this.type = type;
		this.media_id = media_id;
		this.name = name;
		this.key = key;
		this.url = url;
		this.sub_button = sub_button;
	}
	@Override
	public String toString() {
		return "MenuInfo [type=" + type + ", media_id=" + media_id + ", name=" + name + ", key=" + key + ", url=" + url
				+ ", sub_button=" + Arrays.toString(sub_button) + "]";
	}
	
	
	
}
