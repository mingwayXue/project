package com.xue.oas.domain;

import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

public class Privilege {
	private Long id;
	private Long pid;//权限的父节点
	private String name;
	private String description;
	private Boolean checked;
	private String icon;
	private String url; 	//这个是点击菜单跳转的url
	private String target;  //这个是url中的target属性
	private Set<Role> roles;
	private String type;//"1"代表菜单  "2"代表页面上的操作元素
	private Boolean isParent; //是否为父节点
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	//该注解的含义是：在本对象转化成json字符串时，可以忽略该属性（不加载），解决内存溢出的问题
	//@JSON(serialize=false)
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getIsParent() {
		return isParent;
	}
	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}
	
}
