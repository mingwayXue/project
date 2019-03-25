package com.xue.oas.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xue.oas.dao.LoginDao;
import com.xue.oas.domain.User;
import com.xue.oas.service.LoginService;
@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Resource(name="loginDao")
	private LoginDao loginDao;
	
	@Override
	public User login(String username, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username",	username);
		map.put("password", password);
		return this.loginDao.queryEntryByProperty(map);
	}

	//权限框架shiro的认证设置..
	@Override
	public User getUserByUsername(String username) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("username", username);
		return this.loginDao.queryEntryByProperty(map);
	}

}
