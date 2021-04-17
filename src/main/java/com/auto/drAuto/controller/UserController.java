package com.auto.drAuto.controller;

import java.util.ArrayList;
import java.util.Optional;

import javax.sound.midi.Soundbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auto.drAuto.bean.ResponseBean;
import com.auto.drAuto.bean.UserBean;
import com.auto.drAuto.dao.UserDao;
import com.auto.drAuto.dao.UserRepo;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;

	@Autowired
	UserRepo repo;

	@PostMapping("/create-user")
	public ResponseBean<UserBean> addUser(@RequestBody UserBean userBean) {
		System.out.println(userBean);
		UserBean addedUser = repo.save(userBean);
		ResponseBean<UserBean> responseBean = new ResponseBean<>();
		responseBean.setObj(addedUser);
		responseBean.setMessage("user added");
		responseBean.setStatusCode(201);
		return new ResponseBean<>();
	}

	@GetMapping("/get-users")
	public ArrayList<UserBean> listUsers() {
		return (ArrayList<UserBean>) repo.findAll();
	}

	@GetMapping("/get-user/{phone}")
	public ResponseBean<UserBean> getUser(@PathVariable("phone") long phone) {
		Optional<UserBean> userBean = repo.findById(phone);
		ResponseBean<UserBean> responseBean = new ResponseBean<>();
		responseBean.setObj(userBean.get());
		responseBean.setMessage("successful");
		responseBean.setStatusCode(201);
		return responseBean;
	}
	
	@DeleteMapping("/delete-user/{phone}")
	public ResponseBean<UserBean> deleteUser(@PathVariable("phone") long phone) {
		repo.deleteById(phone);
		ResponseBean<UserBean> responseBean = new ResponseBean<>();
		responseBean.setObj(null);
		responseBean.setMessage("successfully deleted");
		responseBean.setStatusCode(201);
		return responseBean;
	}
}
