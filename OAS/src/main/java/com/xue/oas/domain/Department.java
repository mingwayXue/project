package com.xue.oas.domain;

import java.io.Serializable;
import java.util.Set;

//部门表
public class Department implements Serializable{
	//部门与用户是一对多的关系
	private Long did;
	private String name;
	private String description;
	private Set<User> users;
	public Long getDid() {
		return did;
	}
	public void setDid(Long did) {
		this.did = did;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
