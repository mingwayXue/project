package com.xue.oa.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class SessionFactoryTest extends SpringUtils{

	@Test
	public void testSessionFactory(){
		SessionFactory sessionFactory = (SessionFactory) applicationContext.getBean("sessionFactory");
		
	}
}
