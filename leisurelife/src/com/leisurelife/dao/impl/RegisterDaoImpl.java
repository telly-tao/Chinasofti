package com.leisurelife.dao.impl;

import java.util.Map;
import java.util.UUID;

import com.leisurelife.dao.RegisterDao;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class RegisterDaoImpl implements RegisterDao {

	@Override
	public int registerRequest(Map<String, Object> map) {
		IDbUtil db=new DbUtil();
		//���������б�
		String username=map.get("username").toString();
		String password=map.get("password").toString();
		String uid=UUID.randomUUID().toString();
		String sql ="insert into user (username,password,uid) values('"+username+"','"+password+"','"+uid+"')";
		//��ȡִ�н��
		int result=db.update(sql);
		System.out.println("sql:"+sql+"ִ�н��:"+result);
		return result;
	}

}
