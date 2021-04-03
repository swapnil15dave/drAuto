package com.auto.drAuto.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.auto.drAuto.bean.UserBean;

@Repository
public class UserDao {
	
	@Autowired
	JdbcTemplate stmt;
	
	
	
	public boolean insertUser(UserBean userBean)
	{
		int rows = stmt.update("insert into user(username,email,phone)"
				+ " values(?,?,?)",userBean.getUserName(),userBean.getUserEmail(),userBean.getUserPhone());
		if(rows>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
