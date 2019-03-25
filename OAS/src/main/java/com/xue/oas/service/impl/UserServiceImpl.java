package com.xue.oas.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xue.oas.dao.DepartmentDao;
import com.xue.oas.dao.RoleDao;
import com.xue.oas.dao.UserDao;
import com.xue.oas.dao.base.BaseDao;
import com.xue.oas.domain.Department;
import com.xue.oas.domain.Role;
import com.xue.oas.domain.User;
import com.xue.oas.service.UserService;
import com.xue.oas.service.base.impl.BaseServiceImpl;
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	@Resource(name = "userDao")
	private UserDao userDao;
	@Resource(name = "departmentDao")
	private DepartmentDao departmentDao;
	@Resource(name = "roleDao")
	private RoleDao roleDao;
	
	@Override
	public BaseDao<User> getBaseDao() {
		return this.userDao;
	}
	//多表添加数据
	@Transactional
	public void saveUser(User user, Long did, Long[] ids) {
		//建立用户与部门的联系
		Department department = this.departmentDao.getEntryById(did);
		user.setDepartment(department);
		//建立用户与岗位的关系
		Set<Role> roles = this.roleDao.getEntryByIds(ids);
		user.setRoles(roles);
		this.userDao.saveEntry(user);
	}
	//建立user与role的关系
	@Transactional
	public void bulidUserAndRole(Long uid, Long[] rids) {
		User user = this.userDao.getEntryById(uid);
		Set<Role> roles = this.roleDao.getEntryByIds(rids);
		user.setRoles(roles);
		//这里仅仅只是update更新操作，没有清空，即当选择框没有选择角色时，并不能清空..
		this.userDao.updateEntry(user);
	}

}
