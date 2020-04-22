package com.leisurelife.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public Map<String,Object> loginRequest(Map<String,Object> map) {
		
		LoginDao login=new LoginDaoImpl();
		List<Object> source =new ArrayList<Object>();
		//获取结果
		source = login.loginRequest(map);
		System.out.println(":"+source.get(0));
		
		Map<String,Object> result =new HashMap<String,Object>();
		int cmd;
		int code;
		if(source.get(0)!=null) {
			cmd=0;
			code=0;
			result.put("cmd",cmd);
			result.put("code",code);
		}
		System.out.println("service result:"+result);
		return result;
	}

}
