package com.xue.oas.service;

import com.xue.oas.domain.User;

public interface LoginService {
	public User login(String username, String password);

	public User getUserByUsername(String username);
}
