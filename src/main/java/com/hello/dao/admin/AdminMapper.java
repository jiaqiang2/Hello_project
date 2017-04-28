package com.hello.dao.admin;

import java.util.List;

import com.hello.pojo.admin.Admin;
import com.hello.pojo.role.Role;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin admin);

    int updateByPrimaryKey(Admin admin);
    
    Admin findAdminByUsername(String username);

	List<Admin> findAll();
	
	List<Role> getRoles(Integer id);
}