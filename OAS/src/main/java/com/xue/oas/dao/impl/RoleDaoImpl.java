package com.xue.oas.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.xue.oas.dao.RoleDao;
import com.xue.oas.dao.base.impl.BaseDaoImpl;
import com.xue.oas.domain.Role;
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role> implements RoleDao{

	@Override
	public Collection<Role> getRoleByUid(Long uid) {
		/**
		 * 1、加载所有角色
		 * 2、加载用户能访问的角色
		 * 3、遍历所有角色，查看当前遍历的角色是否有用户能访问的，如果有，则设置checked属性为true
		 */
		Collection<Role> allRoleList = this.hibernateTemplate.find("from Role");
		Collection<Role> userRoleList = this.hibernateTemplate.find("from Role r inner join fetch r.users u where u.uid=?",uid);
		//遍历
		for(Role role1 : allRoleList){
			for(Role role2 : userRoleList){
				if(role1.getRid().longValue() == role2.getRid().longValue()){
					role1.setChecked(true);
				}
			}
		}
		return allRoleList;
	}

}
