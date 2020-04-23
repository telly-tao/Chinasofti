package com.leisurelife.service.impl.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.leisurelife.dao.impl.music.ConcertListDaoImpl;
import com.leisurelife.dao.music.ConcertListDao;
import com.leisurelife.model.Music;
import com.leisurelife.service.music.ConcertListService;
import com.leisurelife.util.ConvertToJson;

public class ConcertListServiceImpl implements ConcertListService {

	@Override
	public String concertListRequest(Map<String, Object> map) {
		ConcertListDao cld = new ConcertListDaoImpl();
		List<Music> source = new ArrayList<Music>();
		source = cld.concertListRequest();
		//创建一个map对象result存储需要返回前端的数据
		Map<String, Object> result = new HashMap<String, Object>();
		// 创建一个map对象re存储内层转换为json格式
		Map<String, Object> re = new HashMap<String, Object>();
		// 定义一个临时list存储内re转换完成后的json字符串
		List<String> list = new ArrayList<String>();

		if (source != null) {
			result.put("cmd", map.get("cmd"));
			result.put("code", 0);
			for (Music so : source) {
				re.put("mid", so.getMusicid());
				re.put("name", so.getName());
				re.put("image", so.getImage());
				re.put("time", so.getTime());
				re.put("addr", so.getAddress());
				list.add(JSON.toJSONString(re));
			}
			result.put("list", list);
			//将数据转换为JSON格式
			ConvertToJson json=new ConvertToJson();
			String jsonString = json.ConvertToJSON(result.toString());
			System.out.println("Service result:"+jsonString);
			return jsonString;
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//将数据转换为JSON格式
			return JSON.toJSONString(result);
		}
		
	}

}
