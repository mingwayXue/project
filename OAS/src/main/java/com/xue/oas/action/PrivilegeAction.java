package com.xue.oas.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.xue.oas.action.base.BaseAction;
import com.xue.oas.domain.Privilege;
import com.xue.oas.domain.User;
import com.xue.oas.service.PrivilegeService;

@Controller("privilegeAction")
@Scope("prototype")
public class PrivilegeAction extends BaseAction<Privilege>{
	@Resource(name="privilegeService")
	private PrivilegeService privilegeService;
	
	private Long rid;
	
	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}


	public String showPrivlegeTreeByRid(){
		Collection<Privilege> privileges = this.privilegeService.getPrivilegesByRid(rid);
		ActionContext.getContext().getValueStack().push(privileges);
		return SUCCESS;
	}
	
	public String showMenuitemsTreeByUid(){
		//从session中把当前用户提取出来
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("user");
		//获取当前用户能够访问到的菜单
		Collection<Privilege> privileges = this.privilegeService.getMenuitemsByUid(user);
		ActionContext.getContext().getValueStack().push(privileges);
		return SUCCESS;
	}
}
	