package com.leisurelife.service.impl.movie;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.leisurelife.dao.impl.movie.MovieCommentSubmitDaoImpl;
import com.leisurelife.dao.movie.MovieCommentSubmitDao;

public class MovieCommentSubmitServiceImpl implements com.leisurelife.service.movie.MovieCommentSubmitService {

	@Override
	public String movieCommentSubmitRequest(Map<String, Object> map) {
		MovieCommentSubmitDao mcsd=new MovieCommentSubmitDaoImpl();
		int source = mcsd.movieCommentSubmitRequest(map);
		Map<String, Object> result = new HashMap<String, Object>();
		if (source != 0) {
			result.put("cmd", map.get("cmd"));
			result.put("code", 0);
			//将数据转换为JSON格式
			return JSON.toJSONString(result);
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//将数据转换为JSON格式
			return JSON.toJSONString(result);
		}
	}

}
