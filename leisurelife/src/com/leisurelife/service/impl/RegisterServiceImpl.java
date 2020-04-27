package com.leisurelife.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.RegisterDao;
import com.leisurelife.dao.impl.RegisterDaoImpl;
import com.leisurelife.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
	@Override
	public String registerRequest(Map<String, Object> map) {
		Gson gson=new Gson();
		RegisterDao register=new RegisterDaoImpl();
		//��ȡ���
		int source = register.registerRequest(map);
		Map<String,Object> result =new HashMap<String,Object>();
		if (source == 1) {
			result.put("cmd", map.get("cmd"));
			result.put("code", 0);
			//������ת��ΪJSON��ʽ
			return gson.toJson(result);
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//������ת��ΪJSON��ʽ
			return gson.toJson(result);
		}
	}

}
