package com.leisurelife.service.impl.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.dao.impl.movie.MovieCommentSubmitDaoImpl;
import com.leisurelife.dao.movie.MovieCommentSubmitDao;

public class MovieCommentSubmitServiceImpl implements com.leisurelife.service.movie.MovieCommentSubmitService {

	@Override
	public List<Object> movieCommentSubmitRequest(Map<String, Object> map) {
		MovieCommentSubmitDao mcsd=new MovieCommentSubmitDaoImpl();
		List<Object> result =new ArrayList<Object>();
		result = mcsd.movieCommentSubmitRequest(map);
		return result;
	}

}
