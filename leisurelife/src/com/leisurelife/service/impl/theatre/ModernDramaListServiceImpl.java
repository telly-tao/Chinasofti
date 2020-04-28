package com.leisurelife.service.impl.theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.impl.theatre.ModernDramaListDaoImpl;
import com.leisurelife.dao.theatre.ModernDramaListDao;
import com.leisurelife.model.Play;
import com.leisurelife.service.theatre.ModernDramaListService;

public class ModernDramaListServiceImpl implements ModernDramaListService {

	@Override
	public String modernDramaListRequest(Map<String, Object> map) {
		ModernDramaListDao mdld = new ModernDramaListDaoImpl();
		List<Play> source = new ArrayList<Play>();
		Gson gson=new Gson();
		source = mdld.modernDramaListRequest();
		// ����һ��map����result�洢��Ҫ����ǰ�˵�����
		Map<String, Object> result = new HashMap<String, Object>();
		// ����һ��map����re�洢�ڲ�ת��Ϊjson��ʽ
		Map<String, Object> re;
		// ����һ����ʱlist�洢��reת����ɺ��json�ַ���
		List<Object> list = new ArrayList<Object>();
		if (source != null) {
			result.put("cmd", map.get("cmd").toString());
			result.put("code", "0");
			for (Play so : source) {
				re = new HashMap<String, Object>();
				re.put("cid", so.getPlay_id());
				re.put("name", so.getName());
				re.put("image", so.getImage());
				re.put("time", so.getTime());
				re.put("addr", so.getAddress());
				list.add(re);
			}
			result.put("list", list);
			// ������ת��ΪJSON��ʽ
			String jsonString = gson.toJson(result);
			System.out.println("Service result:" + jsonString);
			return jsonString;
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			// ������ת��ΪJSON��ʽ
			return gson.toJson(result);
		}
	}

}
