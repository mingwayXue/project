package com.xue.oas.action.base;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.springframework.beans.BeanUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xue.oas.service.base.BaseService;

public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>{
	//注入BaseService,不能使用容器注入，这里使用抽象类的抽象方法注入
	//public abstract BaseService<T> getBaseService();
	//传入的泛型的具体类
	private Class modelDrivenClass;
	//定义Action中的传递属性值：
	public static final String LISTACTION = "listAction";//跳转到列表页面的常量
	public static final String UPDATEUI = "updateUI";//跳转到更新页面的常量
	public static final String ADDUI = "addUI";//跳转到增加页面的常量
	public static final String ACTION2ACTION = "action2action";//action跳转到action
	
	public String listAction = LISTACTION;
	public String updateUI = UPDATEUI;
	public String addUI = ADDUI;
	public String action2action = ACTION2ACTION;
	
	//实例化的类
	private T t;
	//获取action的url中的id
	private Long id;
	public void setId(Long id) {
		this.id = id;
	}
	
	public BaseAction(){
		//构造函数，实现泛型类的具体传入到：modelDrivenClass
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.modelDrivenClass = (Class) type.getActualTypeArguments()[0];
		try {
			//实例化传入的泛型类
			this.t = (T) this.modelDrivenClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//模型驱动必须实现的方法
	@Override
	public T getModel() {
		return this.t;
	}
	
	//查询
	//执行增删改查时，需要传入相应的T的service，但是又不能直接注入，所以使用getBaseService()方法来注入相应的service
	public String showData(){
		//Collection<T> dataList = this.getBaseService().queryEntry();
		//System.out.println(dataList.size());
		ActionContext.getContext().put("dataList", null);
		return "list";
	}
	//跳转到增加的页面
	public String addUI(){
		return "addUI";
	}
	//增加
	public String add() throws InstantiationException, IllegalAccessException{
		Object obj = this.modelDrivenClass.newInstance();
		BeanUtils.copyProperties(this.getModel(), obj);
		T t = (T) obj;
		//this.getBaseService().saveEntry(t);
		return "action2action";
	}
	
//	//跳转到更新页面
//	public String updateUI(){
//		//T t = this.getBaseService().getEntryById(this.id);
//		ActionContext.getContext().getValueStack().push(t);
//		return "updateUI";
//	}
//	//更新
//	public String update(){
//		
//		return "";
//	}

}
