package com.leisurelife.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.SubmitDao;
import com.leisurelife.dao.impl.SubmitDaoImpl;
import com.leisurelife.service.SubmitService;

public class SubmitServiceImpl implements SubmitService {

	@Override
	public String submitRequest(Map<String, Object> map) {
		SubmitDao sd=new SubmitDaoImpl();
		Gson gson=new Gson();
		int source = sd.submitRequest(map);
		Map<String, Object> result = new HashMap<String, Object>();
		if (source == 1) {
			result.put("cmd", map.get("cmd"));
			result.put("code", 0);
			//将数据转换为JSON格式
			return gson.toJson(result);
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//将数据转换为JSON格式
			return gson.toJson(result);
		}
	}

}
