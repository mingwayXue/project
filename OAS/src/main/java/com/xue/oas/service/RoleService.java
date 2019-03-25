package com.xue.oas.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import com.xue.oas.domain.Role;
import com.xue.oas.service.base.BaseService;

public interface RoleService extends BaseService<Role>{
	public Set<Role> getEntryByIds(Serializable[] ids);
	public Collection<Role> getRoleByUid(Long uid);
	public void buildRoleAndPrivilege(Long rid, Long[] ids);
}
