package com.hello.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.hello.facade.admin.AdminFacade;
import com.hello.pojo.admin.Admin;
import com.hello.pojo.menu.Menu;
import com.hello.pojo.role.Role;

/**
 * 认证授权
 * @author Arien
 * @date 2017-4-24 下午04:56:58 
 */
public class ShiroRealm extends AuthorizingRealm{
	
	@Autowired
	@Qualifier("adminService")
	private AdminFacade adminFacade;
	
	/**
	 * shiro 授权认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("================ doGetAuthorizationInfo  shiro 授权认证   ===============    ");
		
		//获取当前用户的登录名    等价于principals.fromRealm(this.getName()).iterator().next();
		String currentUseranme = (String) super.getAvailablePrincipal(principals);
		System.out.println("当前用户名："+currentUseranme);
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		SimpleAuthorizationInfo authorizationInfo = null;
		if(null != session){
			Admin admin = (Admin) session.getAttribute("currentSubject");
			
			List<String> roleNames = new ArrayList<String>();
			Set<String> permissions = new HashSet<String>();
			
			List<Role> roles = adminFacade.getRoles(admin.getUserId());
			for (Role role : roles) {
				roleNames.add(role.getRoleName());
				if(null != role.getMenuList()){
					for (Menu menu : role.getMenuList()) {
						permissions.add(menu.getMenuName());
					}
				}
			}
			
			authorizationInfo = new SimpleAuthorizationInfo();
			authorizationInfo.addRoles(roleNames);
			authorizationInfo.setStringPermissions(permissions);
		}
		return authorizationInfo;
	}
	
	/**
	 * shiro 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("================ doGetAuthenticationInfo  shiro 登录认证   ===============    ");
		UsernamePasswordToken uToken = (UsernamePasswordToken) token;
		String user = uToken.getUsername();
		Admin admin = adminFacade.findAdminByUsername(user);
		if(null != admin){
			Subject currentSubject = SecurityUtils.getSubject();
			if(null != currentSubject){
				Session session = currentSubject.getSession();
				session.setAttribute("currentSubject", admin);
			}
			System.out.println("Token信息： "+uToken.toString());
			System.out.println("用户信息： "+ admin.getUser()+ "====="+admin.getPassword()+"====="+getName());
			return new SimpleAuthenticationInfo(admin.getUser(), admin.getPassword(), getName());
		}
		return null;
	}

}
