package com.hello.service.admin;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hello.dao.admin.AdminMapper;
import com.hello.facade.admin.AdminFacade;
import com.hello.pojo.admin.Admin;
import com.hello.pojo.role.Role;


@Service
public class AdminService implements AdminFacade {
	@Autowired
	private AdminMapper adminMapper;
	
	@Override
	public int add(Admin admin) {
		
		return adminMapper.insert(admin);
	}

	@Override
	public List<Admin> findAll() {
		List<Admin> list = new ArrayList<Admin>();
		list = adminMapper.findAll();
		return list;
	}

	@Override
	public Admin findAdminByUsername(String username) {
		
		return adminMapper.findAdminByUsername(username);
	}

	@Override
	public List<Role> getRoles(Integer id) {
		
		return adminMapper.getRoles(id);
	}
	
}
