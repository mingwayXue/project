package com.xue.oas.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xue.oas.dao.PrivilegeDao;
import com.xue.oas.dao.RoleDao;
import com.xue.oas.dao.base.BaseDao;
import com.xue.oas.domain.Privilege;
import com.xue.oas.domain.Role;
import com.xue.oas.service.RoleService;
import com.xue.oas.service.base.impl.BaseServiceImpl;
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService{
	
	@Resource(name="roleDao")
	private RoleDao roleDao;
	
	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;
	
	@Override
	public BaseDao<Role> getBaseDao() {
		// TODO Auto-generated method stub
		return this.roleDao;
	}

	@Override
	public Set<Role> getEntryByIds(Serializable[] ids) {
		return this.roleDao.getEntryByIds(ids);
	}

	@Override
	public Collection<Role> getRoleByUid(Long uid) {
		// TODO Auto-generated method stub
		return this.roleDao.getRoleByUid(uid);
	}

	@Transactional
	public void buildRoleAndPrivilege(Long rid, Long[] ids) {
		Role role = this.roleDao.getEntryById(rid);
		Set<Privilege> privileges = this.privilegeDao.getEntryByIds(ids);
		//建立role与privilege之间的关系
		role.setPrivileges(privileges);
		this.roleDao.updateEntry(role);
	}

}
