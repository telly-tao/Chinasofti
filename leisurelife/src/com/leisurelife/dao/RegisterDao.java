package com.leisurelife.dao;

import java.util.List;
import java.util.Map;

import com.leisurelife.model.User;

public interface RegisterDao {
	public int registerRequest(Map<String,Object> map);
}
