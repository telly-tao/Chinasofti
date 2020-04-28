package com.leisurelife.service.impl.theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.impl.theatre.ModernDramaListDaoImpl;
import com.leisurelife.dao.theatre.ModernDramaListDao;
import com.leisurelife.model.Play;
import com.leisurelife.service.theatre.ModernDramaListService;

public class ModernDramaListServiceImpl implements ModernDramaListService {

	@Override
	public String modernDramaListRequest(Map<String, Object> map) {
		ModernDramaListDao mdld = new ModernDramaListDaoImpl();
		List<Play> source = new ArrayList<Play>();
		Gson gson=new Gson();
		source = mdld.modernDramaListRequest();
		// 创建一个map对象result存储需要返回前端的数据
		Map<String, Object> result = new HashMap<String, Object>();
		// 创建一个map对象re存储内层转换为json格式
		Map<String, Object> re;
		// 定义一个临时list存储内re转换完成后的json字符串
		List<Object> list = new ArrayList<Object>();
		if (source != null) {
			result.put("cmd", map.get("cmd").toString());
			result.put("code", "0");
			for (Play so : source) {
				re = new HashMap<String, Object>();
				re.put("cid", so.getPlay_id());
				re.put("name", so.getName());
				re.put("image", so.getImage());
				re.put("time", so.getTime());
				re.put("addr", so.getAddress());
				list.add(re);
			}
			result.put("list", list);
			// 将数据转换为JSON格式
			String jsonString = gson.toJson(result);
			System.out.println("Service result:" + jsonString);
			return jsonString;
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			// 将数据转换为JSON格式
			return gson.toJson(result);
		}
	}

}
