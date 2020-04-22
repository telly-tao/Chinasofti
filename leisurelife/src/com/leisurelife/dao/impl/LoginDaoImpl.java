package com.leisurelife.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.leisurelife.controller.LoginController;
import com.leisurelife.dao.LoginDao;
import com.leisurelife.model.User;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class LoginDaoImpl implements LoginDao{
	private static Logger logger=Logger.getLogger(LoginDaoImpl.class);
	@Override
	public List<Object> loginRequest(Map<String, Object> map) {
		IDbUtil db=new DbUtil();
		User user=new User();
		List<Object> list=new ArrayList<Object>();
		String username=map.get("username").toString();
		String password=map.get("password").toString();
		//从数据库获取数据
		String sql="select * from user where username='"+username+"'and `password`=MD5('"+password+"');";
		ResultSet rs=db.query(sql);
		try {
			while(rs.next()) {
				user.setUserid(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUid(rs.getString("uid"));
				list.add(user);
			}
		} catch (SQLException e) {
			logger.error(e.getStackTrace());
		}
		db.closeQurey();
		return list;
	}

}
