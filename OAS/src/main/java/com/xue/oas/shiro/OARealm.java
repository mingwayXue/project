package com.xue.oas.shiro;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.xue.oas.domain.Privilege;
import com.xue.oas.domain.User;
import com.xue.oas.service.LoginService;
import com.xue.oas.service.PrivilegeService;
import com.xue.oas.service.UserService;

public class OARealm extends AuthorizingRealm{
	@Resource(name="loginService")
	private LoginService loginService;
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	@Resource(name="userService")
	private UserService userService;
	
	/**
	 * 完成授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//根据用户获取权限，把用户能够访问到的权限封装在authorizationInfo对象中
		User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
		Collection<Privilege> privileges =  null;
		if(user.getUsername().equals("admin")){
			privileges = this.privilegeService.getFunctions();
		}else{
			//这里加载角色树...
			privileges = this.privilegeService.getFunctionsByUid(user);
		}
		for(Privilege privilege:privileges){
			authorizationInfo.addStringPermission(privilege.getName());
		}
		return authorizationInfo;
	}

	/**
	 * 完成认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
		User user = this.loginService.getUserByUsername(usernamePasswordToken.getUsername());
		if(user==null){
			return null;
		}else{
			SecurityUtils.getSubject().getSession().setAttribute("user", user);
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
			return authenticationInfo;
		}
	}

}
