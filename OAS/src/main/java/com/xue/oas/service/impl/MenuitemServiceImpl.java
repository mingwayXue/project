package com.xue.oas.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xue.oas.dao.MenuitemDao;
import com.xue.oas.dao.base.BaseDao;
import com.xue.oas.domain.Menuitem;
import com.xue.oas.service.MenuitemService;
import com.xue.oas.service.base.impl.BaseServiceImpl;
@Service("menuitemService")
public class MenuitemServiceImpl extends BaseServiceImpl<Menuitem> implements MenuitemService{

	@Resource(name="menuitemDao")
	private MenuitemDao menuitemDao;
	
	@Override
	public BaseDao<Menuitem> getBaseDao() {
		// TODO Auto-generated method stub
		return this.menuitemDao;
	}

	@Override
	public Collection<Menuitem> getMenuitemTreeByPid(Long pid) {
		// TODO Auto-generated method stub
		return this.menuitemDao.getMenuitemTreeByPid(pid);
	}

}
