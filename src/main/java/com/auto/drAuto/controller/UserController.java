package com.auto.drAuto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auto.drAuto.bean.ResponseBean;
import com.auto.drAuto.bean.UserBean;
import com.auto.drAuto.dao.UserDao;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;
	
	@PostMapping(value="/createUser")
	public ResponseBean<?> addUser(UserBean userBean)
	{		System.out.println(userBean.getUserPhone());
			userDao.insertUser(userBean);
			ResponseBean<UserBean> responseBean = new ResponseBean<>();
			responseBean.setObj(userBean);
			responseBean.setMessage("user added");
			responseBean.setStatusCode(201);
			return responseBean;
	}
}
