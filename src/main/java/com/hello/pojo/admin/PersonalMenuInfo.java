package com.hello.pojo.admin;

public class PersonalMenuInfo{
	
	private String group_id;  // 	用户分组id，可通过用户分组管理接口获取 
	private String sex;       // 	性别：男（1）女（2），不填则不做匹配
	private String client_platform_type; //客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配 
	private String country;   // 	国家信息
	private String province;  // 	省份信息
	private String city;      //    城市信息
	private String language;  //    语言信息
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClient_platform_type() {
		return client_platform_type;
	}
	public void setClient_platform_type(String client_platform_type) {
		this.client_platform_type = client_platform_type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public PersonalMenuInfo(String group_id, String sex, String client_platform_type, String country, String province,
			String city, String language) {
		super();
		this.group_id = group_id;
		this.sex = sex;
		this.client_platform_type = client_platform_type;
		this.country = country;
		this.province = province;
		this.city = city;
		this.language = language;
	}
	public PersonalMenuInfo() {
		super();
	}
	@Override
	public String toString() {
		return "PersonalMenuInfo [group_id=" + group_id + ", sex=" + sex + ", client_platform_type="
				+ client_platform_type + ", country=" + country + ", province=" + province + ", city=" + city
				+ ", language=" + language + "]";
	}
	
	
}	
