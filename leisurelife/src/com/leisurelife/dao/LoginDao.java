package com.leisurelife.dao;

import java.util.List;
import java.util.Map;

import com.leisurelife.model.User;

public interface LoginDao {
	public List<User> loginRequest(Map<String, Object> map);
}
