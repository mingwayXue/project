package com.xue.oas.service;

import java.util.Collection;

import com.xue.oas.domain.Privilege;
import com.xue.oas.domain.User;
import com.xue.oas.service.base.BaseService;

public interface PrivilegeService extends BaseService<Privilege>{

	public Collection<Privilege> getPrivilegesByRid(Long rid);
	
	public Collection<Privilege> getFunctionsByUid(User user);

	public Collection<Privilege> getMenuitemsByUid(User user);

	public Collection<Privilege> getFunctions();

}
