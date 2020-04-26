package com.leisurelife.service.impl.movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.leisurelife.dao.impl.movie.MovieCommentDaoImpl;
import com.leisurelife.dao.movie.MovieCommentDao;
import com.leisurelife.model.Recommend;
import com.leisurelife.service.movie.MovieCommentService;

public class MovieCommentServiceImpl implements MovieCommentService {

	@Override
	public String movieCommentRequest(Map<String, Object> map) {
		//获取影评Dao对象
		MovieCommentDao mcd=new MovieCommentDaoImpl();
		//创建一个list用于接收影评数据
		List<Recommend> source = new ArrayList<Recommend>();
		source = mcd.movieCommentRequest(map);
		//创建一个map对象result存储需要返回前端的数据
		Map<String, Object> result = new HashMap<String, Object>();
		//创建一个map对象re存储内层转换为json格式
		Map<String, Object> re;
		//定义一个临时list存储内re转换完成后的json字符串
		List<Object> list=new ArrayList<Object>();
		Gson gson=new Gson();
		if (source != null) {
			result.put("cmd", map.get("cmd"));
			result.put("code", 0);
			for (Recommend so : source) {
				re = new HashMap<String, Object>();
				re.put("tid", so.getTid());
				re.put("username", so.getUsername());
				re.put("type", so.getType());
				re.put("time", so.getTime());
				re.put("content", so.getContent());
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
			return gson.toJson(result);
		}
	}


}
