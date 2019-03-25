package com.xue.oas.dao.impl;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xue.oas.dao.PersonDao;
import com.xue.oas.dao.base.impl.BaseDaoImpl;
import com.xue.oas.domain.Person;
@Repository("personDao")
public class PersonDaoImpl extends BaseDaoImpl<Person> implements PersonDao{
	/*由于实现了BaseDaoImpl，所以不需要实现注解及其方法.
	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void savePerson(Person person) {
		this.hibernateTemplate.save(person);
	}
	*/
	
}
