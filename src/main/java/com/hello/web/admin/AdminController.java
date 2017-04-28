package com.hello.web.admin;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.facade.admin.AdminFacade;
import com.hello.pojo.admin.Admin;

@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Autowired
	@Qualifier("adminService")
	private AdminFacade adminFacade;
	@RequestMapping(value="add")
	Object add(Admin admin){
		adminFacade.add(admin);
		return "/adminList.jsp";
	}
	
	
	/**
	 * 查询用户
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="find")
	@ResponseBody
	public Object findAll()throws Exception{
		List<Admin> adminList = adminFacade.findAll();
		System.err.println(adminList.size()+"----------------------------------");
		Map<String,Object> map = new LinkedHashMap<String,Object>();
		map.put("total", adminList.size());
		map.put("rows", adminList);
		return map;
		
	}
}
