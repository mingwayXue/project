package com.xue.oas.dao.impl;

import org.springframework.stereotype.Repository;

import com.xue.oas.dao.UserDao;
import com.xue.oas.dao.base.impl.BaseDaoImpl;
import com.xue.oas.domain.User;
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

}
