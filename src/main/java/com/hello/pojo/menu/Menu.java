package com.hello.pojo.menu;

public class Menu {
	
	private Integer menuId;         // 资源ID
	
	private String menuName;        // 资源名称
	
	private String menuType; 		// 资源类型
	
	private Integer mpId;			// 上级资源ID
	
	private String pageUrl;			// 资源url
	
	private String description;		// 资源描述
	
	private String statu;			// 资源状态

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public Integer getMpId() {
		return mpId;
	}

	public void setMpId(Integer mpId) {
		this.mpId = mpId;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	public Menu() {
		super();
	}

	public Menu(Integer menuId, String menuName, String menuType, Integer mpId,
			String pageUrl, String description, String statu) {
		super();
		this.menuId = menuId;
		this.menuName = menuName;
		this.menuType = menuType;
		this.mpId = mpId;
		this.pageUrl = pageUrl;
		this.description = description;
		this.statu = statu;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName
				+ ", menuType=" + menuType + ", mpId=" + mpId + ", pageUrl="
				+ pageUrl + ", description=" + description + ", statu=" + statu
				+ "]";
	}
	
}
