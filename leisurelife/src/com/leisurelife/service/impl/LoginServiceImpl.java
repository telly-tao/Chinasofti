package com.leisurelife.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.model.User;
import com.leisurelife.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private static Logger logger=Logger.getLogger(LoginServiceImpl.class);
	@Override
	public String loginRequest(Map<String,Object> map) {
		
		LoginDao login=new LoginDaoImpl();
		List<User> source =new ArrayList<User>();
		//获取结果
		source = login.loginRequest(map);
		System.out.println(source.get(0));
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
		System.out.println("service result:"+JSON.toJSONString(result));
		String jsonString=JSON.toJSONString(result);
		return jsonString;
	}

}
