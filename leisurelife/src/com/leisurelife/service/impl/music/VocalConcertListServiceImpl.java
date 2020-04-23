package com.leisurelife.service.impl.music;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.dao.impl.music.ConcertListDaoImpl;
import com.leisurelife.dao.impl.music.VocalConcertListDaoImpl;
import com.leisurelife.dao.music.ConcertListDao;
import com.leisurelife.dao.music.VocalConcertListDao;
import com.leisurelife.model.Concert;
import com.leisurelife.model.Music;
import com.leisurelife.service.music.VocalConcertListService;
import com.leisurelife.util.ConvertToJSON;

public class VocalConcertListServiceImpl implements VocalConcertListService {

	@Override
	public String vocalConcertListRequest(Map<String, Object> map) {
	
		VocalConcertListDao vcld = new VocalConcertListDaoImpl();
			List<Concert> source = new ArrayList<Concert>();
			source = vcld.vocalConcertListRequest();
			Map<String, Object> result = new HashMap<String, Object>();
			Map<String, Object> re = new HashMap<String, Object>();
			List<String> list=new ArrayList<String>();
			
			if (source != null) {
				result.put("cmd", map.get("cmd"));
				result.put("code", 0);
				for (Concert so : source) {
					re.put("mid", so.getConcert_id());
					re.put("name", so.getName());
					re.put("image", so.getImage());
					re.put("time", so.getTime());
					re.put("addr", so.getAddress());
					list.add(JSON.toJSONString(re));
				}
				result.put("list", list);
				
				ConvertToJSON json=new ConvertToJSON();
				String jsonString = json.ConvertToJSON(result.toString());
				System.out.println("Service result:"+jsonString);
				return jsonString;
			} else {
				result.put("cmd", map.get("cmd"));
				result.put("code", 1);
				return JSON.toJSONString(result);
			}
	}
}
