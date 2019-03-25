package com.xue.oas.dao.impl;

import org.springframework.stereotype.Repository;

import com.xue.oas.dao.DepartmentDao;
import com.xue.oas.dao.base.impl.BaseDaoImpl;
import com.xue.oas.domain.Department;
@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

}
