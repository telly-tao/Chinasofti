package com.leisurelife.service.impl.music;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.leisurelife.dao.LoginDao;
import com.leisurelife.dao.impl.LoginDaoImpl;
import com.leisurelife.dao.impl.music.VocalConcertListDaoImpl;
import com.leisurelife.dao.music.VocalConcertListDao;
import com.leisurelife.service.music.VocalConcertListService;

public class VocalConcertListServiceImpl implements VocalConcertListService {

	@Override
	public List<Object> vocalConcertListRequest(Map<String, Object> map) {
		VocalConcertListDao vcld=new VocalConcertListDaoImpl();
		List<Object> result =new ArrayList<Object>();
		result = vcld.vocalConcertListRequest(map);
		return result;
	}

}
