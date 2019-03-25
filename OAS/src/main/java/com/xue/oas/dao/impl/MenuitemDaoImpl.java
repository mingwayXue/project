package com.xue.oas.dao.impl;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import com.xue.oas.dao.MenuitemDao;
import com.xue.oas.dao.base.impl.BaseDaoImpl;
import com.xue.oas.domain.Menuitem;
@Repository("menuitemDao")
public class MenuitemDaoImpl extends BaseDaoImpl<Menuitem> implements MenuitemDao{

	@Override
	public Collection<Menuitem> getMenuitemTreeByPid(Long pid) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Menuitem where pid=?", pid);
	}

}
