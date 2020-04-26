package com.leisurelife.service.impl.movie;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.impl.movie.MovieCommentSubmitDaoImpl;
import com.leisurelife.dao.movie.MovieCommentSubmitDao;

public class MovieCommentSubmitServiceImpl implements com.leisurelife.service.movie.MovieCommentSubmitService {
	@Override
	public String movieCommentSubmitRequest(Map<String, Object> map) {
		MovieCommentSubmitDao mcsd=new MovieCommentSubmitDaoImpl();
		Gson gson=new Gson();
		int source = mcsd.movieCommentSubmitRequest(map);
		Map<String, Object> result = new HashMap<String, Object>();
		if (source == 1) {
			result.put("cmd", map.get("cmd"));
			result.put("code", 0);
			//������ת��ΪJSON��ʽ
			return gson.toJson(result);
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//������ת��ΪJSON��ʽ
			return gson.toJson(result);
		}
	}

}
