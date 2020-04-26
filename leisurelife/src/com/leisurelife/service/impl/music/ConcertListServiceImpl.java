package com.leisurelife.service.impl.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.impl.music.ConcertListDaoImpl;
import com.leisurelife.dao.music.ConcertListDao;
import com.leisurelife.model.Music;
import com.leisurelife.service.music.ConcertListService;

public class ConcertListServiceImpl implements ConcertListService {

	@Override
	public String concertListRequest(Map<String, Object> map) {
		ConcertListDao cld = new ConcertListDaoImpl();
		List<Music> source = new ArrayList<Music>();
		source = cld.concertListRequest();
		Gson gson=new Gson();
		//创建一个map对象result存储需要返回前端的数据
		Map<String, Object> result = new HashMap<String, Object>();
		// 创建一个map对象re存储内层转换为json格式
		Map<String, Object> re;
		// 定义一个临时list存储内re转换完成后的json字符串
		List<Object> list = new ArrayList<Object>();

		if (source != null) {
			result.put("cmd", map.get("cmd"));
			result.put("code", 0);
			for (Music so : source) {
				re = new HashMap<String, Object>();
				re.put("mid", so.getMusicid());
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
