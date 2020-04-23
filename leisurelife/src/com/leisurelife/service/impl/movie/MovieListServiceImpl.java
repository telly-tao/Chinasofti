package com.leisurelife.service.impl.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.leisurelife.dao.impl.movie.MovieListDaoImpl;
import com.leisurelife.dao.movie.MovieListDao;
import com.leisurelife.model.Movie;
import com.leisurelife.service.movie.MovieListService;
import com.leisurelife.util.ConvertToJSON;

public class MovieListServiceImpl implements MovieListService {

	@Override
	public String movieListRequest(Map<String, Object> map) {
		MovieListDao mld = new MovieListDaoImpl();
		List<Movie> source = new ArrayList<Movie>();
		source = mld.movieListRequest();
		//����һ��map����result�洢��Ҫ����ǰ�˵�����
		Map<String, Object> result = new HashMap<String, Object>();
		// ����һ��map����re�洢�ڲ�ת��Ϊjson��ʽ
		Map<String, Object> re = new HashMap<String, Object>();
		// ����һ����ʱlist�洢��reת����ɺ��json�ַ���
		List<String> list = new ArrayList<String>();

		if (source != null) {
			result.put("cmd", map.get("cmd"));
			result.put("code", 0);
			for (Movie so : source) {
				re.put("mid", so.getMovieid());
				re.put("name", so.getName());
				re.put("type", so.getType());
				re.put("player", so.getPlayer());
				re.put("image", so.getImage());
				list.add(JSON.toJSONString(re));
			}
			result.put("list", list);
			//������ת��ΪJSON��ʽ
			ConvertToJSON json = new ConvertToJSON();
			String jsonString = json.ConvertToJSON(result.toString());
			System.out.println("Service result:" + jsonString);
			return jsonString;
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//������ת��ΪJSON��ʽ
			return JSON.toJSONString(result);
		}

	}

}
