package com.xue.oas.action;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xue.oa.test.SpringUtils;
import com.xue.oas.action.base.BaseAction;
import com.xue.oas.domain.Department;
import com.xue.oas.domain.Role;
import com.xue.oas.domain.User;
import com.xue.oas.privilege.annotation.PrivilegeInfo;
import com.xue.oas.service.DepartmentService;
import com.xue.oas.service.RoleService;
import com.xue.oas.service.UserService;
import com.xue.oas.utils.OAutils;
@Controller("userAction")
@Scope("prototype")
public class UserAction extends BaseAction<User>{
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	@Resource(name="roleService")
	private RoleService roleService;
	//获取并赋值从from表单中传递过来的did和rids[]
	private Long did;
	private Long[] rids;
	//用户与角色的关系：被选中的角色的id字符串形式
	private String checkedStr;
	
	public String getCheckedStr() {
		return checkedStr;
	}
	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}
	public Long getDid() {
		return did;
	}
	public Long[] getRids() {
		return rids;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public void setRids(Long[] rids) {
		this.rids = rids;
	}
	/**
	 * 查询
	 * 注解@PrivilegeInfo(name="用户查询")的作用：
	 * 	当添加了此注解时，如果用户没有“用户查询”的权限，则会显示权限不足，不予查看
	 */
	@PrivilegeInfo(name="用户查询")
	public String showAllUser(){
		Collection<User> userList = userService.queryEntry();
		ActionContext.getContext().put("userList", userList);
		return listAction;
	}
	/**
	 * 跳转到增加用户的页面，此处需要传递department和role的选择列表过去
	 */
	public String addUI(){
		Collection<Department> depList = this.departmentService.queryEntry();
		Collection<Role> rList = this.roleService.queryEntry();
		ActionContext.getContext().put("depList", depList);
		ActionContext.getContext().put("rList", rList);
		return addUI;
	}
	/**
	 * 添加
	 */
	public String add(){
		//System.out.println("add()方法...执行...");
		//模型驱动赋值
		User user = new User();
		BeanUtils.copyProperties(this.getModel(), user);
		this.userService.saveUser(user, did, rids);
		return action2action;
	}
	/**
	 * 删除
	 */
	public String delete(){
		this.userService.deleteEntry(this.getModel().getUid());
		return action2action;
	}
	/**
	 * 跳转到更新页面，回显数据
	 */
	public String updateUI(){
		User user = this.userService.getEntryById(this.getModel().getUid());
		//获取did
		Department department = user.getDepartment();
		this.did = department.getDid();
		//实例化rids并获取rids
		Set<Role> roles = user.getRoles();
		this.rids = new Long[roles.size()];
		int index = 0;
		for(Role role : roles){
			this.rids[index] = role.getRid();
			index++;
		}
		//System.out.println(this.did + "|" + this.rids);
		//把user放入对象栈的栈顶
		ActionContext.getContext().getValueStack().push(user);
		//查出部门和岗位的所有数据
		Collection<Department> depList = this.departmentService.queryEntry();
		Collection<Role> rList = this.roleService.queryEntry();
		ActionContext.getContext().put("depList", depList);
		ActionContext.getContext().put("rList", rList);
		return updateUI;
	}
	/**
	 * 修改
	 */
	public String update(){
		User user = userService.getEntryById(this.getModel().getUid());
		//赋值最新的数据
		BeanUtils.copyProperties(this.getModel(), user);
		//重新建立用户与部门的联系
		Department department = this.departmentService.getEntryById(this.did);//在修改时，用户选择的部门
		user.setDepartment(department);
		//重新建立用户与角色之间的联系
		Set<Role> roles = this.roleService.getEntryByIds(this.rids);//修改时，用户选择的岗位
		user.setRoles(roles);
		this.userService.updateEntry(user);
		return action2action;
	}
	/**
	 * 建立用户与角色的关系
	 */
	public String buildUserAndRole(){
		String[] strs = this.checkedStr.split(",");
		Long[] rids = OAutils.convertLongs(strs);
		this.userService.bulidUserAndRole(this.getModel().getUid(), rids);
		return SUCCESS;
	}
	
}
