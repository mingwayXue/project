package com.xue.oas.dao.base.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.xue.oas.dao.base.BaseDao;
//由于BaseDao不是具体实现的Dao，所以不需要加@Repository,即不能实例化BaseDaoImpl,
//最好是改成Abstract类，抽象类不能被实例化
public abstract class BaseDaoImpl<T> implements BaseDao<T>{
	@Resource(name="hibernateTemplate")
	public HibernateTemplate hibernateTemplate;
	
	//传入的泛型类
	private Class entityClass;
	//entityClass的标识符的名称
	private String identifierPropertyName;
	/**
	 * 此方法是由spring容器调用的，在构造函数之前，对象方法之后
	 */
	@PostConstruct
	public void init(){
		//使用反射的机制获取entityClass的标识符属性的名称
		identifierPropertyName = this.hibernateTemplate.getSessionFactory().getClassMetadata(entityClass).getIdentifierPropertyName();
	}
	
	public BaseDaoImpl(){
		//获得泛型对象...:this.getClass().getGenericSuperclass() = BaseDaoImpl<T>
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		//得到BaseDaoImpl<T>的参数部分：T
		this.entityClass = (Class) type.getActualTypeArguments()[0];
	}
	
	@Override
	public void saveEntry(T t) {
		this.hibernateTemplate.save(t);
	}

	@Override
	public void deleteEntry(Serializable id) {
		T t = (T) this.hibernateTemplate.get(this.entityClass, id);
		this.hibernateTemplate.delete(t);
	}

	@Override
	public void updateEntry(T t) {
		this.hibernateTemplate.update(t);
	}

	@Override
	public Collection<T> queryEntry() {
		
		return this.hibernateTemplate.find("from " + this.entityClass.getName());
	}

	@Override
	public T getEntryById(Serializable id) {
		
		return (T) this.hibernateTemplate.get(this.entityClass, id);
	}
	@Override
	public Set<T> getEntryByIds(Serializable[] ids){
		StringBuffer buffer = new StringBuffer();
		buffer.append("from "+this.entityClass.getName());
		buffer.append(" where "+this.identifierPropertyName + " in(");
		for(int i=0; i<ids.length; i++){
			if(i == ids.length-1){
				buffer.append(ids[i]);
			}else{
				buffer.append(ids[i]+",");
			}
		}
		buffer.append(")");
		return new HashSet<T>(this.hibernateTemplate.find(buffer.toString()));
	}
	public T queryEntryByProperty(final Map<String, Object> map){
		final StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("from "+this.entityClass.getName());
		stringBuffer.append(" where 1=1");
		for(Entry<String, Object> entry:map.entrySet()){
			stringBuffer.append(" and "+entry.getKey()+"=:"+entry.getKey());
		}
		return this.hibernateTemplate.execute(new HibernateCallback<T>() {
			@Override
			public T doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery(stringBuffer.toString());
				for(Entry<String, Object> entry:map.entrySet()){
					query.setParameter(entry.getKey(), entry.getValue());
				}
				return (T)query.uniqueResult();
			}
		});
	}

}
