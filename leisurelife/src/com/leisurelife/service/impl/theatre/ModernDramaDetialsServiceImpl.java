package com.leisurelife.service.impl.theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.impl.music.VocalConcertListDaoImpl;
import com.leisurelife.dao.impl.theatre.ModernDramaListDaoImpl;
import com.leisurelife.dao.music.VocalConcertListDao;
import com.leisurelife.dao.theatre.ModernDramaListDao;
import com.leisurelife.model.Concert;
import com.leisurelife.model.Play;
import com.leisurelife.service.theatre.ModernDramaDetialsService;

public class ModernDramaDetialsServiceImpl implements ModernDramaDetialsService {

	@Override
	public String modernDramaDetialsRequest(Map<String, Object> map) {
		ModernDramaListDao mdld = new ModernDramaListDaoImpl();
		List<Play> source = new ArrayList<Play>();
		source = mdld.modernDramaListRequest();
		Gson gson=new Gson();
		Map<String, Object> re = new HashMap<String, Object>();
		if (source != null) {
			re.put("cmd", map.get("cmd"));
			re.put("code", 0);
			for (Play so : source) {
				if(Integer.parseInt(map.get("cid").toString())== so.getPlay_id()) {
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
