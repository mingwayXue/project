package com.xue.oas.interceptor;

import java.util.Collection;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.xue.oas.domain.Privilege;
import com.xue.oas.domain.User;
import com.xue.oas.privilege.annotation.PrivilegeAnnotationParse;

public class PrivilegeInterceptor implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/*
		 *实现的方法：1、获取用户能够访问到的功能权限
		 *		   2、获取访问当前请求的方法中的权限
		 *         3、查看当前用户的权限是否包含当前请求的方法的权限
		 *         		如果包含，则继续访问
		 *         		如果不包含，则跳转到错误页面 
		 */
		Collection<Privilege> privileges = (List<Privilege>) ServletActionContext.getRequest().getSession().getAttribute("functions");
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		//获取当前请求方法名(代理对象的方法名)
		String methodName = invocation.getProxy().getMethod();
		//当前请求的Action的class形式
		Class targetClass = invocation.getAction().getClass();
		String privilegeName = PrivilegeAnnotationParse.parse(targetClass, methodName);
		boolean flag = false;
		if(privilegeName.equals("")){//action中的方法上没有写注解，或者写了注解，但是属性name的值为""
			//此处设置成flag = false会更好理解
			flag = true;
		}else if(user.getUsername().equals("admin")){//如果当前用户是admin
			flag = true;
		}else{
			for(Privilege privilege : privileges){
				if(privilege.getName().equals(privilegeName)){//当前用户的权限是否包含当前请求的方法的权限
					flag = true;
					break;
				}
			}
		}
		if(flag){
			//放行
			return invocation.invoke();
		}else{
			ActionContext.getContext().getValueStack().push("权限不足，没有办法访问...");
			//跳转错误页面
			return "error";
		}
	}

}
