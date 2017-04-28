package com.hello.facade.admin;

import java.util.List;

import com.hello.pojo.admin.Admin;
import com.hello.pojo.role.Role;

public interface AdminFacade {
	int add(Admin admin);
	List<Admin> findAll();
	Admin findAdminByUsername(String username);
	List<Role> getRoles(Integer id);
}
