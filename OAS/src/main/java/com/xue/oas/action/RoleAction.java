package com.xue.oas.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xue.oas.action.base.BaseAction;
import com.xue.oas.domain.Role;
import com.xue.oas.service.RoleService;
import com.xue.oas.utils.OAutils;
@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	@Resource(name="roleService")
	private RoleService roleService;
	private Long uid;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
	//
	private String checkedStr;
	
	public String getCheckedStr() {
		return checkedStr;
	}

	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}
	//用户设置角色中，回显数据（回显全选框）
	public String showRoleTree(){
		Collection<Role> rList = this.roleService.getRoleByUid(uid);
		ActionContext.getContext().getValueStack().push(rList);
		return SUCCESS;
	}
	public String showAllRole(){
		Collection<Role> roleList = this.roleService.queryEntry();
		ActionContext.getContext().put("roleList", roleList);
		return listAction;
	}
	
	public String buildRoleAndPrivilege(){
		String[] ss = this.checkedStr.split(",");
		Long[] ids = OAutils.convertLongs(ss);
		this.roleService.buildRoleAndPrivilege(this.getModel().getRid(), ids);
		return SUCCESS;
	}
}
