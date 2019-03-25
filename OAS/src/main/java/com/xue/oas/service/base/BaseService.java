package com.xue.oas.service.base;

import java.io.Serializable;
import java.util.Collection;

public interface BaseService<T> {
	public void saveEntry(T t);
	public void deleteEntry(Serializable id);
	public void updateEntry(T t);
	public Collection<T> queryEntry();
	public T getEntryById(Serializable id);
}
