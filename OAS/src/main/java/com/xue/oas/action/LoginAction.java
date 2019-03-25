package com.xue.oas.action;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xue.oas.action.base.BaseAction;
import com.xue.oas.domain.Privilege;
import com.xue.oas.domain.User;
import com.xue.oas.service.LoginService;
import com.xue.oas.service.PrivilegeService;
@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction<User>{
	@Resource(name="loginService")
	private LoginService loginService;
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	
	//普通方法实现用户的登陆和相关角色树的查询
//	public String login(){
//		User user = this.loginService.login(this.getModel().getUsername(), this.getModel().getPassword());
//		if(user == null){//用户名或者密码错误
//			this.addActionError("用户名或密码错误！！！");
//			return "login";
//		}else{//登录成功
//			//根据用户id，查找用户所拥有的权限（功能权限和菜单权限），再把功能权限放在session中（因为菜单权限只用一次，所以不需要放在session中）。
//			Collection<Privilege> privileges = this.privilegeService.getFunctionsByUid(user);
//			//把用户能访问到的功能权限privileges放入session中
//			ServletActionContext.getRequest().getSession().setAttribute("functions", privileges);
//			ServletActionContext.getRequest().getSession().setAttribute("user", user);
//			return "index";
//		}
//	}
	//shiro框架实现认证...(没实现加载角色树)
	public String login(){
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = 
					new UsernamePasswordToken(
								this.getModel().getUsername(),
								this.getModel().getPassword());
		try{
			subject.login(token);
		}catch(UnknownAccountException e){
			e.printStackTrace();
			this.addActionError("该用户名不存在");
			return INPUT;
		}catch(AuthenticationException e){
			e.printStackTrace();
			this.addActionError("密码不对");
			return INPUT;
		}
		return "index";
	}
}
