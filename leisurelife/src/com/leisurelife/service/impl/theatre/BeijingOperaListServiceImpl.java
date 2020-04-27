package com.leisurelife.service.impl.theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.impl.music.ConcertListDaoImpl;
import com.leisurelife.dao.impl.theatre.BeijingOperaListDaoImpl;
import com.leisurelife.dao.music.ConcertListDao;
import com.leisurelife.dao.theatre.BeijingOperaListDao;
import com.leisurelife.model.Music;
import com.leisurelife.model.Pekingopera;
import com.leisurelife.service.theatre.BeijingOperaListService;

public class BeijingOperaListServiceImpl implements BeijingOperaListService {

	@Override
	public String beijingOperaListRequest(Map<String, Object> map) {
		BeijingOperaListDao bold = new BeijingOperaListDaoImpl();
		List<Pekingopera> source = new ArrayList<Pekingopera>();
		source = bold.beijingOperaListRequest();
		Gson gson=new Gson();
		//创建一个map对象result存储需要返回前端的数据
		Map<String, Object> result = new HashMap<String, Object>();
		// 创建一个map对象re存储内层转换为json格式
		Map<String, Object> re;
		// 定义一个临时list存储内re转换完成后的json字符串
		List<Object> list = new ArrayList<Object>();

		if (source != null) {
			result.put("cmd", map.get("cmd").toString());
			result.put("code", "0");
			for (Pekingopera so : source) {
				re = new HashMap<String, Object>();
				re.put("pid", so.getPekingopera_id());
				re.put("name", so.getName());
				re.put("image", so.getImage());
				re.put("time", so.getTime());
				re.put("addr", so.getAddress());
				list.add(re);
			}
			result.put("list", list);
			//将数据转换为JSON格式
			String jsonString = gson.toJson(result);
			System.out.println("Service result:"+jsonString);
			return jsonString;
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//将数据转换为JSON格式
			return gson.toJson(result);
		}
	}

}
