package com.leisurelife.service.impl.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
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
			//������ת��ΪJSON��ʽ
			String jsonString = JSON.toJSONString(re);
			System.out.println("vocalConcertDetails Service result:"+jsonString);
			return jsonString;
		} else {
			re.put("cmd", map.get("cmd"));
			re.put("code", 1);
			//������ת��ΪJSON��ʽ
			return JSON.toJSONString(re);
		}
	}

}
