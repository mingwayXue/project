package com.xue.oas.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xue.oas.dao.PrivilegeDao;
import com.xue.oas.dao.base.BaseDao;
import com.xue.oas.domain.Privilege;
import com.xue.oas.domain.User;
import com.xue.oas.service.PrivilegeService;
import com.xue.oas.service.base.impl.BaseServiceImpl;
@Service("privilegeService")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService{
	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;
	
	@Override
	public BaseDao<Privilege> getBaseDao() {
		// TODO Auto-generated method stub
		return this.privilegeDao;
	}

	@Override
	public Collection<Privilege> getPrivilegesByRid(Long rid) {
		// TODO Auto-generated method stub
		return this.privilegeDao.getPrvilegesByRid(rid);
	}
	@Transactional(readOnly=true)
	public Collection<Privilege> getFunctionsByUid(User user) {
		return this.privilegeDao.getFunctionsByUid(user);
	}

	@Transactional(readOnly=true)
	public Collection<Privilege> getMenuitemsByUid(User user) {
		// TODO Auto-generated method stub
		return this.privilegeDao.getMenuitemsByUid(user);
	}

	//权限框架shiro的授权设置
	@Override
	public Collection<Privilege> getFunctions() {
		// TODO Auto-generated method stub
		return this.privilegeDao.queryEntry();
	}

}
