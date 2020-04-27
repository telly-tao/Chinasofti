package com.leisurelife.service.impl.delicious;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.delicious.DeliciousListDao;
import com.leisurelife.dao.impl.delicious.DeliciousListDaoImpl;
import com.leisurelife.dao.impl.movie.MovieListDaoImpl;
import com.leisurelife.dao.movie.MovieListDao;
import com.leisurelife.model.Delicacies;
import com.leisurelife.model.Movie;
import com.leisurelife.service.delicious.DeliciousListService;

public class DeliciousListServiceImpl implements DeliciousListService {

	@Override
	public String deliciousListRequest(Map<String, Object> map) {
		DeliciousListDao dld = new DeliciousListDaoImpl();
		Gson gson=new Gson();
		List<Delicacies> source = new ArrayList<Delicacies>();
		source = dld.deliciousListRequest();
		//����һ��map����result�洢��Ҫ����ǰ�˵�����
		Map<String, Object> result = new HashMap<String, Object>();
		// ����һ��map����re�洢�ڲ�ת��Ϊjson��ʽ
		Map<String, Object> re;
		// ����һ����ʱlist�洢��reת����ɺ��json�ַ���
		List<Object> list = new ArrayList<Object>();
		if (source != null) {
			result.put("cmd", map.get("cmd").toString());
			result.put("code", "0");
			for (Delicacies so : source) {
				re = new HashMap<String, Object>();
				re.put("did", so.getDelicacies_id());
				re.put("label", so.getLabel());
				re.put("addr", so.getAddress());
				re.put("avg", so.getAvgs());
				re.put("image", so.getImage());
				list.add(re);
			}
			result.put("list", list);
			//������ת��ΪJSON��ʽ
			String jsonString = gson.toJson(result);
			System.out.println("Service result:" + jsonString);
			return jsonString;
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//������ת��ΪJSON��ʽ
			return gson.toJson(result);
		}
	}

}
