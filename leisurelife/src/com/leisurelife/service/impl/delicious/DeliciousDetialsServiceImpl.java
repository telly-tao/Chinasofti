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
import com.leisurelife.model.Hotedetail;
import com.leisurelife.model.Movie;
import com.leisurelife.service.delicious.DeliciousDetialsService;

public class DeliciousDetialsServiceImpl implements DeliciousDetialsService {

	@Override
	public String deliciousDetialsRequest(Map<String, Object> map) {
		Gson gson=new Gson();
		DeliciousListDao dld = new DeliciousListDaoImpl();
		List<Delicacies> source = new ArrayList<Delicacies>();
		List<Hotedetail> source2 = new ArrayList<Hotedetail>();
		source = dld.deliciousListRequest();
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> re;
		if (source != null) {
			result.put("cmd", map.get("cmd"));
			result.put("code", 0);
			for (Delicacies so : source) {
				if(Integer.parseInt(map.get("mid").toString())== so.getDelicacies_id()) {
					result.put("call", so.getCalls());
					result.put("mapx",so.getMapx());
					result.put("mapy",so.getMapy());
				}
			}
			List<Object> list = new ArrayList<Object>();
			for (Hotedetail so : source2){
				re = new HashMap<String, Object>();
				re.put("name", so.getName());
				re.put("mage", so.getImage());
				re.put("oprice", so.getOldprice());
				re.put("nprice", so.getNewprice());
				list.add(re);
			}
			result.put("list", list);
			//将数据转换为JSON格式
			String jsonString = gson.toJson(result);
			System.out.println("Service result:"+jsonString);
			return jsonString;
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//将数据转换为JSON格式
			return  gson.toJson(result);
		}
	}

}
