package com.leisurelife.dao.impl.movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.leisurelife.dao.movie.MovieCommentDao;
import com.leisurelife.model.Recommend;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class MovieCommentDaoImpl implements MovieCommentDao {
	private static Logger logger=Logger.getLogger(MovieListDaoImpl.class);
	@Override
	public List<Recommend> movieCommentRequest(Map<String, Object> map) {
		IDbUtil db =new DbUtil();
		int type=Integer.parseInt( map.get("type").toString());
		int mid=Integer.parseInt( map.get("mid").toString());
		String sql="select * from Recommend where tid="+mid+" and type="+1+";";
		ResultSet rs=db.query(sql);
		List<Recommend> result=new ArrayList<Recommend>();
		try {
			while(rs.next()) {
				Recommend recommend=new Recommend();
				recommend.setRecid(rs.getInt("recid"));
				recommend.setUsername(rs.getString("username"));
				recommend.setTid(rs.getInt("tid"));
				recommend.setType(rs.getInt("type"));
				recommend.setContent(rs.getString("content"));
				recommend.setTime(rs.getString("time"));
				result.add(recommend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
		finally {
			db.closeQurey();
		}
		return result;
	}

}
