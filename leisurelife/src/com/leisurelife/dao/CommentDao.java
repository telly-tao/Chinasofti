package com.leisurelife.dao;

import java.util.List;
import java.util.Map;

import com.leisurelife.model.Recommend;

public interface CommentDao {
	public List<Recommend> commentRequest(Map<String,Object> map);
}
