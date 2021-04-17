package com.auto.drAuto.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.tree.RowMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.auto.drAuto.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;


	public boolean insertUser(UserBean userBean) {
		int rows = stmt.update("insert into user(username,email,phone)" + " values(?,?,?)", userBean.getUserName(),
				userBean.getUserEmail(), userBean.getUserPhone());
		if (rows > 0) {
			return true;
		} else {
			return false;
		}
	}

	public String getUserByEmail(String email) {
		UserBean user = stmt.queryForObject("select * from users where email  like '" + email+"'",
				new BeanPropertyRowMapper<UserBean>(UserBean.class));
		return user.getUserEmail();
	}

//	public ArrayList<UserBean> listUsers() {
//
//		ArrayList<UserBean> list = (ArrayList<UserBean>) stmt.query("select * from users", (ResultSetExtractor<UserBean>) new Rm());
//		return list;
//	}
//
//	class Rm implements RowMapper {
//
//		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
//			UserBean bean = new UserBean();
//			bean.setUserName(rs.getString("username"));
//			bean.setUserEmail(rs.getString("email"));
//			bean.setUserPhone(rs.getString("phone"));
//			return bean;
//		}
//
//	}

}