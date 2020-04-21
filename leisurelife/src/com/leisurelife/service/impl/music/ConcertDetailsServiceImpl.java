package com.leisurelife.service.impl.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.dao.impl.music.ConcertDetailsDaoImpl;
import com.leisurelife.dao.music.ConcertDetailsDao;
import com.leisurelife.service.music.ConcertDetailsService;

public class ConcertDetailsServiceImpl implements ConcertDetailsService {

	@Override
	public List<Object> concertDetailsRequest(Map<String, Object> map) {
		ConcertDetailsDao cdd=new ConcertDetailsDaoImpl();
		List<Object> result =new ArrayList<Object>();
		result = cdd.concertDetailsRequest(map);
		return result;
	}

}
