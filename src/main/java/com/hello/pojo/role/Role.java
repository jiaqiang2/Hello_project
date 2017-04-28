package com.hello.pojo.role;

import java.util.List;

import com.hello.pojo.menu.Menu;

public class Role {
	
	private Integer roleId;			// 角色ID
	
	private String roleName;		// 角色名称
	
	private Integer rpId;			// 上级角色ID
	
	private String remark;			// 角色说明
	
	private Integer statu;			// 角色状态
	
	private List<Menu> menus;	// 资源集合

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRpId() {
		return rpId;
	}

	public void setRpId(Integer rpId) {
		this.rpId = rpId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getStatu() {
		return statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	public List<Menu> getMenuList() {
		return menus;
	}

	public void setMenuList(List<Menu> menus) {
		this.menus = menus;
	}

	public Role() {
		super();
	}

	public Role(Integer roleId, String roleName, Integer rpId, String remark,
			Integer statu, List<Menu> menus) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.rpId = rpId;
		this.remark = remark;
		this.statu = statu;
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", rpId="
				+ rpId + ", remark=" + remark + ", statu=" + statu
				+ ", menus=" + menus + "]";
	}

}
