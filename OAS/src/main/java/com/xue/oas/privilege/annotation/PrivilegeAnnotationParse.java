package com.xue.oas.privilege.annotation;

import java.lang.reflect.Method;

//权限的注解解析器
public class PrivilegeAnnotationParse {
	public static String parse(Class targetClass,String methodName) throws Exception{
		String privilegeName = "";
		Method method = targetClass.getMethod(methodName);
		//该方法上存在PrivilegeInfo注解
		if(method.isAnnotationPresent(PrivilegeInfo.class)){
			PrivilegeInfo privilegeInfo = method.getAnnotation(PrivilegeInfo.class);
			privilegeName = privilegeInfo.name();
		}
		return privilegeName;
	}
}
