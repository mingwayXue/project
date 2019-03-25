package com.xue.oas.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xue.oas.dao.DepartmentDao;
import com.xue.oas.dao.base.BaseDao;
import com.xue.oas.domain.Department;
import com.xue.oas.service.DepartmentService;
import com.xue.oas.service.base.impl.BaseServiceImpl;
@Service("departmentService")
public class DepartmentServiceImpl extends BaseServiceImpl<Department> implements DepartmentService{
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	@Override
	public BaseDao<Department> getBaseDao() {
		// TODO Auto-generated method stub
		return this.departmentDao;
	}

}
