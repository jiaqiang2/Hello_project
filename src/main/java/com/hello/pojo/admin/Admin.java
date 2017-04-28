package com.hello.pojo.admin;

import java.util.List;

import com.hello.annotation.Column;
import com.hello.pojo.role.Role;
import com.hello.util.Date;

public class Admin {
	
    private Integer userId;			// 用户ID
    
    private String loginName;		// 昵称
    
    @Column("username")
    private String user;			// 账户

    private String password;		// 密码
    
    private String cardNo;			// 身份编号
    
    private Integer age;			// 年龄
    
    private char sex; 				// 性别
    
    private String phone;			// 电话
    
    private String imgUrl;			// 头像URL
    
    private Date lastLogin;			// 上次登录时间
    
    private Integer statu;			// 用户状态
    
    private Integer flag;			// 标志位： 0 未删除；1 已删除
    
    private List<Role> roles;		// 角色集合

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Integer getStatu() {
		return statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Admin() {
		super();
	}

	public Admin(Integer userId, String loginName, String user,
			String password, String cardNo, Integer age, char sex,
			String phone, String imgUrl, Date lastLogin, Integer statu,
			Integer flag, List<Role> roles) {
		super();
		this.userId = userId;
		this.loginName = loginName;
		this.user = user;
		this.password = password;
		this.cardNo = cardNo;
		this.age = age;
		this.sex = sex;
		this.phone = phone;
		this.imgUrl = imgUrl;
		this.lastLogin = lastLogin;
		this.statu = statu;
		this.flag = flag;
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Admin [userId=" + userId + ", loginName=" + loginName
				+ ", user=" + user + ", password=" + password + ", cardNo="
				+ cardNo + ", age=" + age + ", sex=" + sex + ", phone=" + phone
				+ ", imgUrl=" + imgUrl + ", lastLogin=" + lastLogin
				+ ", statu=" + statu + ", flag=" + flag + ", roles=" + roles
				+ "]";
	}
    
    

}