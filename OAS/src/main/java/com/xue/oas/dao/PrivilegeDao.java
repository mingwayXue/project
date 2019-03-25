package com.xue.oas.dao;

import java.util.Collection;

import com.xue.oas.dao.base.BaseDao;
import com.xue.oas.domain.Privilege;
import com.xue.oas.domain.User;

public interface PrivilegeDao extends BaseDao<Privilege>{
	public Collection<Privilege> getPrvilegesByRid(Long rid);
	public Collection<Privilege> getFunctionsByUid(User user);
	public Collection<Privilege> getMenuitemsByUid(User user);
}
