package com.leisurelife.service.impl.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.impl.music.VocalConcertListDaoImpl;
import com.leisurelife.dao.music.VocalConcertListDao;
import com.leisurelife.model.Concert;
import com.leisurelife.service.music.VocalConcertDetailsService;

public class VocalConcertDetailsServiceImpl implements VocalConcertDetailsService {
	@Override
	public String vocalConcertDetailsRequest(Map<String, Object> map) {
		VocalConcertListDao vcld=new VocalConcertListDaoImpl();
		List<Concert> source = new ArrayList<Concert>();
		source = vcld.vocalConcertListRequest();
		Gson gson=new Gson();
		Map<String, Object> re = new HashMap<String, Object>();
		if (source != null) {
			re.put("cmd", map.get("cmd"));
			re.put("code", 0);
			for (Concert so : source) {
				if(Integer.parseInt(map.get("cid").toString())== so.getConcert_id()) {
					re.put("call", so.getCalls());
					re.put("mapx", so.getMapx());
					re.put("mapy", so.getMapy());
					re.put("price", so.getPrice());
					re.put("desc", so.getDescr());
				}
			}
			//将数据转换为JSON格式
			String jsonString = gson.toJson(re);
			System.out.println("vocalConcertDetails Service result:"+jsonString);
			return jsonString;
		} else {
			re.put("cmd", map.get("cmd"));
			re.put("code", 1);
			//将数据转换为JSON格式
			return gson.toJson(re);
		}
	}

}
