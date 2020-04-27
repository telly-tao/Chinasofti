package com.leisurelife.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.model.User;
import com.leisurelife.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private static Logger logger=Logger.getLogger(LoginServiceImpl.class);
	@Override
	public String loginRequest(Map<String,Object> map) {
		Gson gson=new Gson();
		LoginDao login=new LoginDaoImpl();
		List<User> source =new ArrayList<User>();
		//获取结果
		source = login.loginRequest(map);
		System.out.println(source.get(0).toString());
		logger.info(source.get(0));
		Map<String,Object> result =new HashMap<String,Object>();
		int code;
		if(source.get(0)!=null) {
			code=0;
		}
		else {
			code=1;
		}
		result.put("cmd",map.get("cmd"));
		result.put("code",code);
		System.out.println("service result:"+gson.toJson(result));
		//将数据转换为JSON格式
		String jsonString=gson.toJson(result);
		return jsonString;
	}

}
