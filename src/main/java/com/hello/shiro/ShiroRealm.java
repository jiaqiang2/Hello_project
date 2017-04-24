package com.hello.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.hello.service.admin.AdminService;

/**
 * 认证授权
 * @author Arien
 * @date 2017-4-24 下午04:56:58 
 */
public class ShiroRealm extends AuthorizingRealm{
	
	@Autowired
	AdminService adminService;
	
	/**
	 * shiro 授权认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("================ doGetAuthorizationInfo  shiro 授权认证   ===============    ");
		
		return null;
	}
	
	/**
	 * shiro 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		System.out.println("================ doGetAuthenticationInfo  shiro 登录认证   ===============    ");
		
		return null;
	}

}
