package com.leisurelife.service.impl.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.dao.impl.music.ConcertListDaoImpl;
import com.leisurelife.dao.music.ConcertListDao;
import com.leisurelife.service.music.ConcertListService;

public class ConcertListServiceImpl implements ConcertListService {

	@Override
	public List<Object> concertListRequest(Map<String, Object> map) {
		ConcertListDao cld=new ConcertListDaoImpl();
		List<Object> result =new ArrayList<Object>();
		result = cld.concertListRequest(map);
		return result;
	}

}
