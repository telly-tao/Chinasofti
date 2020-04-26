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
		//��ȡӰ��Dao����
		MovieCommentDao mcd=new MovieCommentDaoImpl();
		//����һ��list���ڽ���Ӱ������
		List<Recommend> source = new ArrayList<Recommend>();
		source = mcd.movieCommentRequest(map);
		//����һ��map����result�洢��Ҫ����ǰ�˵�����
		Map<String, Object> result = new HashMap<String, Object>();
		//����һ��map����re�洢�ڲ�ת��Ϊjson��ʽ
		Map<String, Object> re;
		//����һ����ʱlist�洢��reת����ɺ��json�ַ���
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
			//������ת��ΪJSON��ʽ
			String jsonString = gson.toJson(result);
			System.out.println("Service result:"+jsonString);
			return jsonString;
		} else {
			result.put("cmd", map.get("cmd"));
			result.put("code", 1);
			//������ת��ΪJSON��ʽ
			return gson.toJson(result);
		}
	}


}
