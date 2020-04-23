package com.leisurelife.dao.movie;

import java.util.List;
import java.util.Map;

import com.leisurelife.model.Recommend;

public interface MovieCommentDao {
	public List<Recommend> movieCommentRequest(Map<String,Object> map);
}
