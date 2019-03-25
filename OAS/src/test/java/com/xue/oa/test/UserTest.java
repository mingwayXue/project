package com.xue.oa.test;

import java.util.Collection;

import org.junit.Test;

import com.xue.oas.domain.User;
import com.xue.oas.service.UserService;

public class UserTest extends SpringUtils{
	@Test
	public void testUserList(){
		UserService userService =  (UserService) applicationContext.getBean("userService");
		Collection<User> userList = userService.queryEntry();
		System.out.println(userList);
	}
}
