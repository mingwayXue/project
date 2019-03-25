package com.xue.oas.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import com.xue.oas.domain.Role;

public interface BaseDao<T> {
	public void saveEntry(T t);
	public void deleteEntry(Serializable id);
	public void updateEntry(T t);
	public Collection<T> queryEntry();
	public T getEntryById(Serializable id);
	//此处是实现通过id的集合获取相应对象的集合
	public Set<T> getEntryByIds(Serializable[] ids);
	//通过属性查找类
	public T queryEntryByProperty(final Map<String, Object> map);
}
