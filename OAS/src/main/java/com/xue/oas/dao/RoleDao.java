package com.xue.oas.dao;

import java.util.Collection;

import com.xue.oas.dao.base.BaseDao;
import com.xue.oas.domain.Role;

public interface RoleDao extends BaseDao<Role>{
	public Collection<Role> getRoleByUid(Long uid);
}
