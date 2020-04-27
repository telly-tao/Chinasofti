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
import com.leisurelife.service.theatre.BeijingOperaDetialsService;

public class BeijingOperaDetialsServiceImpl implements BeijingOperaDetialsService {

	@Override
	public String beijingOperaDetialsRequest(Map<String, Object> map) {
		Gson gson =new Gson();
		BeijingOperaListDao bold = new BeijingOperaListDaoImpl();
		List<Pekingopera> source = new ArrayList<Pekingopera>();
		source = bold.beijingOperaListRequest();
		Map<String, Object> re = new HashMap<String, Object>();
		if (source != null) {
			re.put("cmd", map.get("cmd"));
			re.put("code", 0);
			for (Pekingopera so : source) {
				if(Integer.parseInt(map.get("pid").toString())== so.getPekingopera_id()) {
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
