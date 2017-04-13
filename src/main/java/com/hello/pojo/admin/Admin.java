package com.hello.pojo.admin;

import com.hello.annotation.Column;

public class Admin {
    private Integer id;
    
    @Column("username")
    private String user;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

	

	public Admin(Integer id, String user, String password) {
		super();
		this.id = id;
		this.user = user;
		this.password = password;
	}

	public Admin() {
		System.out.println("我是admin");
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", user=" + user + ", password=" + password + "]";
	}
    
    
}