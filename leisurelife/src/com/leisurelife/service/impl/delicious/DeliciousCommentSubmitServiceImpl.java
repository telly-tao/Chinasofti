package com.leisurelife.service.impl.delicious;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.impl.movie.MovieCommentSubmitDaoImpl;
import com.leisurelife.dao.movie.MovieCommentSubmitDao;
import com.leisurelife.service.delicious.DeliciousCommentSubmitService;

public class DeliciousCommentSubmitServiceImpl implements DeliciousCommentSubmitService {

	@Override
	public String deliciousCommentSubmitRequest(Map<String, Object> map) {
		MovieCommentSubmitDao mcsd=new MovieCommentSubmitDaoImpl();
		Gson gson=new Gson();
		int source = mcsd.movieCommentSubmitRequest(map);
		Map<String, Object> result = new HashMap<String, Object>();
		if (source == 1) {
			result.put("cmd", map.get("cmd"));
			result.put("code", 0);
			//将数据转换为JSON格式
			return gson.toJson(result);
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//将数据转换为JSON格式
			return gson.toJson(result);
		}
	}

}
