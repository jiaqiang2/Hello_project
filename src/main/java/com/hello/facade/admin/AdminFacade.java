package com.hello.facade.admin;

import java.util.List;

import com.hello.pojo.admin.Admin;

public interface AdminFacade {
	int add(Admin admin);
	List<Admin> findAll();
}
