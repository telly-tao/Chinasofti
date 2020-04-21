package com.leisurelife.service.impl.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.dao.impl.movie.MoviceDetialsDaoImpl;
import com.leisurelife.dao.movie.MoviceDetialsDao;
import com.leisurelife.service.movie.MoviceDetialsService;

public class MoviceDetialsServiceImpl implements MoviceDetialsService {

	@Override
	public List<Object> moviceDetialsRequest(Map<String, Object> map) {
		MoviceDetialsDao mdd=new MoviceDetialsDaoImpl();
		List<Object> result =new ArrayList<Object>();
		result = mdd.moviceDetialsRequest(map);
		return result;
	}

}
