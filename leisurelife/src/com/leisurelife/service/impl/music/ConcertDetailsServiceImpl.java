package com.leisurelife.service.impl.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.impl.music.ConcertListDaoImpl;
import com.leisurelife.dao.music.ConcertListDao;
import com.leisurelife.model.Music;
import com.leisurelife.service.music.ConcertDetailsService;

public class ConcertDetailsServiceImpl implements ConcertDetailsService {
	@Override
	public String concertDetailsRequest(Map<String, Object> map) {
		Gson gson =new Gson();
		ConcertListDao cld = new ConcertListDaoImpl();
		List<Music> source = new ArrayList<Music>();
		source = cld.concertListRequest();
		Map<String, Object> re = new HashMap<String, Object>();
		if (source != null) {
			re.put("cmd", map.get("cmd"));
			re.put("code", 0);
			for (Music so : source) {
				if(Integer.parseInt(map.get("mid").toString())== so.getMusicid()) {
					re.put("call", so.getCalls());
					re.put("mapx", so.getMapx());
					re.put("mapy", so.getMapy());
					re.put("price", so.getPrice());
					re.put("desc", so.getDescr());
				}
			}
			//将数据转换为JSON格式
			String jsonString = gson.toJson(re);
			System.out.println("Service result:"+jsonString);
			return jsonString;
		} else {
			re.put("cmd", map.get("cmd"));
			re.put("code", 1);
			//将数据转换为JSON格式
			return gson.toJson(re);
		}
	}

}
