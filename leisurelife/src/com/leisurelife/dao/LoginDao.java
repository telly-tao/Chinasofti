package com.leisurelife.dao;

import java.util.List;
import java.util.Map;

public interface LoginDao {
	public List<Object> loginRequest(Map<String,Object> map);
}
