package com.leisurelife.dao.delicious;

import java.util.List;
import java.util.Map;

import com.leisurelife.model.Recommend;

public interface DeliciousCommentDao {
	public List<Recommend> deliciousCommentRequest(Map<String,Object> map);
}
