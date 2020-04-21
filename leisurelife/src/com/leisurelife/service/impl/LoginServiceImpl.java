package com.leisurelife.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.service.LoginService;

public class LoginServiceImpl implements LoginService {

	@Override
	public List<Object> loginRequest(Map<String,Object> map) {
		LoginDao login=new LoginDaoImpl();
		List<Object> result =new ArrayList<Object>();
		result = login.loginRequest(map);
		return result;
	}

}
