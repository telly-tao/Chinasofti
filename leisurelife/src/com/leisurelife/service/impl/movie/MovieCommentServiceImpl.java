package com.leisurelife.service.impl.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.dao.impl.movie.MovieCommentDaoImpl;
import com.leisurelife.dao.movie.MovieCommentDao;
import com.leisurelife.service.movie.MovieCommentService;

public class MovieCommentServiceImpl implements MovieCommentService {

	@Override
	public List<Object> movieCommentRequest(Map<String, Object> map) {
		MovieCommentDao mcd=new MovieCommentDaoImpl();
		List<Object> result =new ArrayList<Object>();
		result = mcd.movieCommentRequest(map);
		return result;
	}

}
