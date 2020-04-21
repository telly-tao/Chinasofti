package com.leisurelife.service.impl.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.dao.impl.movie.MovieListDaoImpl;
import com.leisurelife.dao.movie.MovieListDao;
import com.leisurelife.service.movie.MovieListService;

public class MovieListServiceImpl implements MovieListService {

	@Override
	public List<Object> movieListRequest(Map<String, Object> map) {
		MovieListDao mld=new MovieListDaoImpl();
		List<Object> result =new ArrayList<Object>();
		result = mld.movieListRequest(map);
		return result;
	}

}
