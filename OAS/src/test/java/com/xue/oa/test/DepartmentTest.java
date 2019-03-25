package com.xue.oa.test;

import org.junit.Test;

import com.xue.oas.action.DepartmentAction;
import com.xue.oas.domain.Department;
import com.xue.oas.service.DepartmentService;

public class DepartmentTest extends SpringUtils{
	@Test
	public void testDep(){
		DepartmentService departmentService = (DepartmentService) applicationContext.getBean("departmentService");
		Department dp = new Department();
		dp.setName("Java");
		dp.setDescription("Java Menage");
		departmentService.saveEntry(dp);
	}
	@Test 
	public void testDepAction(){
		DepartmentAction departmentAction = (DepartmentAction) applicationContext.getBean("departmentAction");
		System.out.println(departmentAction);
	}
	@Test//测试hibernate的懒加载机制
	public void testGetDepId(){
		DepartmentService departmentService = (DepartmentService) applicationContext.getBean("departmentService");
		Department department = departmentService.getEntryById(1L);
		System.out.println(department.getUsers());
	}
}
