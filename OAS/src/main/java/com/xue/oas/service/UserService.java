package com.xue.oas.service;

import com.xue.oas.domain.User;
import com.xue.oas.service.base.BaseService;

public interface UserService extends BaseService<User>{

	public void saveUser(User user, Long did, Long[] ids);
	public void bulidUserAndRole(Long uid, Long[] rids);
}
