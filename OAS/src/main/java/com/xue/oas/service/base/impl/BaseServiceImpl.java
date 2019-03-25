package com.xue.oas.service.base.impl;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import com.xue.oas.dao.base.BaseDao;
import com.xue.oas.service.base.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
	/*在此不能直接实现注入BaseDao<T>，因为其中的T不明确。
	@Resource(name="baseDao")
	private BaseDao<T> baseDao;
	*/
	//这里采用谁继承BaseServiceImpl抽象类，谁就实现此方法，用来获取相应的BaseDao
	public abstract BaseDao<T> getBaseDao();
	
	@Transactional(readOnly=false)
	public void saveEntry(T t) {
		this.getBaseDao().saveEntry(t);
	}

	@Transactional(readOnly=false)
	public void deleteEntry(Serializable id) {
		this.getBaseDao().deleteEntry(id);
	}

	@Transactional(readOnly=false)
	public void updateEntry(T t) {
		this.getBaseDao().updateEntry(t);
	}

	@Transactional(readOnly=true)
	public Collection<T> queryEntry() {
		return this.getBaseDao().queryEntry();
	}

	@Transactional(readOnly=true)
	public T getEntryById(Serializable id) {
		return this.getBaseDao().getEntryById(id);
	}
	
}
