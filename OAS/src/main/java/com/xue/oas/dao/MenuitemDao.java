package com.xue.oas.dao;

import java.util.Collection;

import com.xue.oas.dao.base.BaseDao;
import com.xue.oas.domain.Menuitem;

public interface MenuitemDao extends BaseDao<Menuitem>{
	//根据父节点获取子节点
	public Collection<Menuitem> getMenuitemTreeByPid(Long pid);
}
