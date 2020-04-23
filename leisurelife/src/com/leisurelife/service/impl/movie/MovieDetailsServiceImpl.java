package com.leisurelife.service.impl.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.leisurelife.dao.impl.movie.MovieListDaoImpl;
import com.leisurelife.dao.movie.MovieListDao;
import com.leisurelife.model.Movie;
import com.leisurelife.service.movie.MovieDetailsService;

public class MovieDetailsServiceImpl implements MovieDetailsService {

	@Override
	public String moviceDetialsRequest(Map<String, Object> map) {
		MovieListDao mdd=new MovieListDaoImpl();
		List<Movie> source = new ArrayList<Movie>();
		source = mdd.movieListRequest();
		Map<String, Object> re = new HashMap<String, Object>();
		if (source != null) {
			re.put("cmd", map.get("cmd"));
			re.put("code", 0);
			for (Movie so : source) {
				if(Integer.parseInt(map.get("mid").toString())== so.getMovieid()) {
					re.put("desc", so.getDescr());
					re.put("tlong",so.getTimelong());
				}
			}
			//将数据转换为JSON格式
			String jsonString = JSON.toJSONString(re);
			System.out.println("Service result:"+jsonString);
			return jsonString;
		} else {
			re.put("cmd", map.get("cmd"));
			re.put("code", 1);
			//将数据转换为JSON格式
			return JSON.toJSONString(re);
		}
	}

}
