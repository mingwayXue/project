package com.xue.oa.test;

import java.util.Collection;

import org.junit.Test;

import com.xue.oas.action.PersonAction;
import com.xue.oas.domain.Menuitem;
import com.xue.oas.domain.Person;
import com.xue.oas.service.MenuitemService;
import com.xue.oas.service.PersonService;

public class PersonTest extends SpringUtils{
	@Test
	public void testPersonService(){
		PersonService personService = (PersonService)applicationContext.getBean("personService");
		Person person = new Person();
		person.setName("xue");
		person.setDescription("lala");
		personService.saveEntry(person);
	}
	@Test
	public void testPersonAction(){
		PersonAction personAction = (PersonAction) applicationContext.getBean("personAction");
		personAction.showData();
	}
	@Test
	public void testMenuitem(){
		MenuitemService menuitemService = (MenuitemService) applicationContext.getBean("menuitemService");
		//System.out.println(menuitemService.getMenuitemTreeByPid(1L));
		Collection<Menuitem> ll = menuitemService.getMenuitemTreeByPid(1L);
		System.out.println("...");
	}
}
