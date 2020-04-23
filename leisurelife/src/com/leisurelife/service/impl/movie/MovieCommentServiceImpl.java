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
import com.leisurelife.util.ConvertToJson;

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
		Map<String, Object> re = new HashMap<String, Object>();
		//定义一个临时list存储内re转换完成后的json字符串
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
			
			ConvertToJson json=new ConvertToJson();
			//将数据转换为JSON格式
			String jsonString = json.ConvertToJSON(result.toString());
			System.out.println("Service result:"+jsonString);
			return jsonString;
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//将数据转换为JSON格式
			return JSON.toJSONString(result);
		}
	}


}
