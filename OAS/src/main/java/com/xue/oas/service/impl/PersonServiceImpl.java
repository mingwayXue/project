package com.xue.oas.service.impl;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.xue.oas.dao.PersonDao;
import com.xue.oas.dao.base.BaseDao;
import com.xue.oas.domain.Person;
import com.xue.oas.service.PersonService;
import com.xue.oas.service.base.impl.BaseServiceImpl;

@Service("personService")
public class PersonServiceImpl extends BaseServiceImpl<Person> implements PersonService {
	@Resource(name="personDao")
	private PersonDao personDao;
	
	@Override//此处实现了personDao的注入，注入到BaseServiceImpl中
	public BaseDao<Person> getBaseDao() {
		return this.personDao;
	}
	/*
	@Transactional(readOnly = false)//该注解可以使用在方法上和类上，在类上时表示，类下面所有方法都是事务级别的
	public void savePerson(Person person) {
		this.personDao.savePerson(person);
	}
	*/

}
