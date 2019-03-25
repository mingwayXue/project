package com.xue.oas.dao.impl;


import org.springframework.stereotype.Repository;

import com.xue.oas.dao.LoginDao;
import com.xue.oas.dao.base.impl.BaseDaoImpl;
import com.xue.oas.domain.User;
@Repository("loginDao")
public class LoginDaoImpl extends BaseDaoImpl<User> implements LoginDao{

}
