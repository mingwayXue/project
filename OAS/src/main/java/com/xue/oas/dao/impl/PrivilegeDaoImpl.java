package com.xue.oas.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.xue.oas.dao.PrivilegeDao;
import com.xue.oas.dao.base.impl.BaseDaoImpl;
import com.xue.oas.domain.Privilege;
import com.xue.oas.domain.User;
@Repository("privilegeDao")
public class PrivilegeDaoImpl extends BaseDaoImpl<Privilege> implements PrivilegeDao{

	@Override
	public Collection<Privilege> getPrvilegesByRid(Long rid) {
		// TODO Auto-generated method stub
		Collection<Privilege> allPrivileges = this.hibernateTemplate.find("from Privilege");
		Collection<Privilege> rolePrivileges = this.hibernateTemplate.find("from Privilege p inner join fetch p.roles r where r.rid=?",rid);
		for(Privilege privilege:allPrivileges){
			for(Privilege privilege2:rolePrivileges){
				if(privilege.getId().longValue()==privilege2.getId().longValue()){
					privilege.setChecked(true);
				}
			}
		}
		return allPrivileges;
	}

	/**
	 * 根据用户提取该用户能够访问到的功能权限
	 */
	@Override
	public Collection<Privilege> getFunctionsByUid(User user) {
		if(user.getUsername().equals("admin")){//如果是admin用户，全部能够访问
			return this.hibernateTemplate.find("from Privilege p where p.type='2'");
		}else{
			StringBuffer buffer = new StringBuffer();
			buffer.append("from Privilege p inner join fetch p.roles r");
			buffer.append(" inner join fetch r.users u");
			buffer.append(" where u.uid=? and p.type='2'");
			return this.hibernateTemplate.find(buffer.toString(),user.getUid());
		}
	}

	/**
	 * 根据用户提取该用户能够访问到的菜单权限
	 */
	@Override
	public Collection<Privilege> getMenuitemsByUid(User user) {
		if(user.getUsername().equals("admin")){
			return this.hibernateTemplate.find("from Privilege p where p.type='1'");
		}else{
			StringBuffer buffer = new StringBuffer();
			buffer.append("from Privilege p inner join fetch p.roles r");
			buffer.append(" inner join fetch r.users u");
			buffer.append(" where u.uid=? and p.type='1'");
			return this.hibernateTemplate.find(buffer.toString(),user.getUid());
		}
	}

}
