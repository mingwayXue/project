package com.xue.oas.action;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.xue.oas.action.base.BaseAction;
import com.xue.oas.domain.Menuitem;
import com.xue.oas.service.MenuitemService;
@Controller("menuitemAction")
@Scope("prototype")
public class MenuitemAction extends BaseAction<Menuitem>{
	@Resource(name="menuitemService")
	private MenuitemService menuitemService;
	/** 1、一次性加载树的方式
	 * 查询
	 * @return
	 */
	public String showMenuitems(){
		Collection<Menuitem> mList = this.menuitemService.queryEntry();
		//这步很关键，将数据放入栈顶，ajax就可以动态加载出数据
		ActionContext.getContext().getValueStack().push(mList);
		return SUCCESS;
	}
	/** 2、动态加载树的方式
	 * 通过父节点获取子节点
	 */
	public String showMenuitemTreeByPid(){
		Collection<Menuitem> mList = this.menuitemService.getMenuitemTreeByPid(this.getModel().getPid());
		ActionContext.getContext().getValueStack().push(mList);
		return SUCCESS;
	}
}
