package com.leisurelife.service.impl.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.dao.impl.music.VocalConcertDetailsDaoImpl;
import com.leisurelife.dao.impl.music.VocalConcertListDaoImpl;
import com.leisurelife.dao.music.VocalConcertDetailsDao;
import com.leisurelife.dao.music.VocalConcertListDao;
import com.leisurelife.service.music.VocalConcertDetailsService;

public class VocalConcertDetailsServiceImpl implements VocalConcertDetailsService {

	@Override
	public List<Object> vocalConcertDetailsRequest(Map<String, Object> map) {
		VocalConcertDetailsDao vcdd=new VocalConcertDetailsDaoImpl();
		List<Object> result =new ArrayList<Object>();
		result = vcdd.vocalConcertDetailsRequest(map);
		return result;
	}

}
