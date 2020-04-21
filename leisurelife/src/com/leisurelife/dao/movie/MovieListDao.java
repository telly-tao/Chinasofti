package com.leisurelife.dao.movie;

import java.util.List;
import java.util.Map;

public interface MovieListDao {
	public List<Object> movieListRequest(Map<String,Object> map);
}
