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
		//����һ��map����result�洢��Ҫ����ǰ�˵�����
		Map<String, Object> result = new HashMap<String, Object>();
		// ����һ��map����re�洢�ڲ�ת��Ϊjson��ʽ
		Map<String, Object> re;
		// ����һ����ʱlist�洢��reת����ɺ��json�ַ���
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
			//������ת��ΪJSON��ʽ
			String jsonString = gson.toJson(result);
			System.out.println("Service result:"+jsonString);
			return jsonString;
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//������ת��ΪJSON��ʽ
			return gson.toJson(result);
		}
	}

}
