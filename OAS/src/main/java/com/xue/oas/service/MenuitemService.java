package com.xue.oas.service;

import java.util.Collection;

import com.xue.oas.domain.Menuitem;
import com.xue.oas.service.base.BaseService;

public interface MenuitemService extends BaseService<Menuitem>{
	public Collection<Menuitem> getMenuitemTreeByPid(Long pid);
}
