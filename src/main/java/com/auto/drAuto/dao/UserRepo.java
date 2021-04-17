package com.auto.drAuto.dao;

import org.springframework.data.repository.CrudRepository;

import com.auto.drAuto.bean.UserBean;

public interface UserRepo extends CrudRepository<UserBean, Long>{
	
}
