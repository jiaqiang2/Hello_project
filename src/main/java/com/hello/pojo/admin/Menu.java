package com.hello.pojo.admin;

import java.util.Arrays;

public class Menu extends BasePojo{
	
	private MenuInfo[] button;
	
	private PersonalMenuInfo matchrule; 
	
	private String menuid;

	public MenuInfo[] getButton() {
		return button;
	}

	public void setButton(MenuInfo[] button) {
		this.button = button;
	}

	public PersonalMenuInfo getMatchrule() {
		return matchrule;
	}

	public void setMatchrule(PersonalMenuInfo matchrule) {
		this.matchrule = matchrule;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

	public Menu(MenuInfo[] button, PersonalMenuInfo matchrule, String menuid) {
		super();
		this.button = button;
		this.matchrule = matchrule;
		this.menuid = menuid;
	}

	public Menu() {
		super();
	}

	@Override
	public String toString() {
		return "Menu [button=" + Arrays.toString(button) + ", matchrule=" + matchrule + ", menuid=" + menuid
				+ ", errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}

	
}
