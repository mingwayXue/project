package com.xue.oas.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.xue.oas.action.base.BaseAction;
import com.xue.oas.domain.Person;
import com.xue.oas.service.PersonService;
import com.xue.oas.service.base.BaseService;

@Controller("personAction")
@Scope("prototype")
public class PersonAction extends BaseAction<Person>{
	@Resource(name="personService")
	private PersonService personService;
	
	/*
	@Override
	public BaseService<Person> getBaseService() {
		return this.personService;
	}
	*/

}
