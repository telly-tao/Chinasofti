package com.leisurelife.service.impl.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.leisurelife.dao.impl.movie.MovieCommentDaoImpl;
import com.leisurelife.dao.movie.MovieCommentDao;
import com.leisurelife.model.Recommend;
import com.leisurelife.service.movie.MovieCommentService;
import com.leisurelife.util.ConvertToJSON;

public class MovieCommentServiceImpl implements MovieCommentService {

	@Override
	public String movieCommentRequest(Map<String, Object> map) {
		MovieCommentDao mcd=new MovieCommentDaoImpl();
		List<Recommend> source = new ArrayList<Recommend>();
		source = mcd.movieCommentRequest(map);
		Map<String, Object> result = new HashMap<String, Object>();
		Map<String, Object> re = new HashMap<String, Object>();
		List<String> list=new ArrayList<String>();
		
		if (source != null) {
			result.put("cmd", map.get("cmd"));
			result.put("code", 0);
			for (Recommend so : source) {
				re.put("tid", so.getTid());
				re.put("username", so.getUsername());
				re.put("type", so.getType());
				re.put("time", so.getTime());
				re.put("content", so.getContent());
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
