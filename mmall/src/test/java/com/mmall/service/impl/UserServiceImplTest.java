package com.mmall.service.impl;

import com.mmall.BaseTest;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.User;
import com.mmall.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**user接口测试
 * Created by Mingway on 2018/3/9.
 */
public class UserServiceImplTest extends BaseTest{

    @Autowired
    private IUserService iUserService;

    @Test
    public void login() throws Exception {
        ServerResponse<User> response = iUserService.login("admin", "admin");
        System.out.println(response);
    }

}