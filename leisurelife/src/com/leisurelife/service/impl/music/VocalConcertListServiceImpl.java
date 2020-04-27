package com.leisurelife.service.impl.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.impl.music.VocalConcertListDaoImpl;
import com.leisurelife.dao.music.VocalConcertListDao;
import com.leisurelife.model.Concert;
import com.leisurelife.service.music.VocalConcertListService;

public class VocalConcertListServiceImpl implements VocalConcertListService {

	@Override
	public String vocalConcertListRequest(Map<String, Object> map) {
		VocalConcertListDao vcld = new VocalConcertListDaoImpl();
		List<Concert> source = new ArrayList<Concert>();
		Gson gson=new Gson();
		source = vcld.vocalConcertListRequest();
		// 创建一个map对象result存储需要返回前端的数据
		Map<String, Object> result = new HashMap<String, Object>();
		// 创建一个map对象re存储内层转换为json格式
		Map<String, Object> re;
		// 定义一个临时list存储内re转换完成后的json字符串
		List<Object> list = new ArrayList<Object>();
		if (source != null) {
			result.put("cmd", map.get("cmd").toString());
			result.put("code", "0");
			for (Concert so : source) {
				re = new HashMap<String, Object>();
				re.put("cid", so.getConcert_id());
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
