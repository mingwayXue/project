package com.xue.oas.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xue.oas.action.base.BaseAction;
import com.xue.oas.domain.Department;
import com.xue.oas.service.DepartmentService;
@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	
	//这里继承的作用仅仅只是传入：listAction、updateUI、addUI、action2action、
	
	/**
	 * 查询
	 */
	public String showAllDepartment(){
		Collection<Department> departmentList = departmentService.queryEntry();
		ActionContext.getContext().put("departmentList", departmentList);
		return listAction;
	}
	/**
	 * 修改跳转页面
	 */
	public String updateUI(){
		Department department = departmentService.getEntryById(this.getModel().getDid());
		ActionContext.getContext().getValueStack().push(department);
		return updateUI;
	}
	/**
	 * 修改
	 */
	public String update(){
		Department department = departmentService.getEntryById(this.getModel().getDid());
		//将this.getModel()的数据复制给department
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.updateEntry(department);
		return action2action;
	}
	/**
	 * 跳转到增加的页面
	 */
	public String addUI(){
		return addUI;
	}
	/**
	 * 增加
	 */
	public String add(){
		Department department = new Department();
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.saveEntry(department);
		return action2action;
	}
	/**
	 * 删除
	 */
	public String delete(){
		this.departmentService.deleteEntry(this.getModel().getDid());
		return action2action;
	}
}
