package com.leisurelife.dao.impl.movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.leisurelife.model.Movie;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class MovieListDaoImpl implements com.leisurelife.dao.movie.MovieListDao {
	private static Logger logger=Logger.getLogger(MovieListDaoImpl.class);
	@Override
	public List<Movie> movieListRequest() {
		IDbUtil db =new DbUtil();
		//提取传过来的数据执行对数据库操作返回结果集
		String sql="select * from movie;";
		ResultSet rs=db.query(sql);
		//将从数据库获取的数据集存取模型对象列表中
		List<Movie> result=new ArrayList<Movie>();
		try {
			while(rs.next()) {
				Movie movie=new Movie();
				movie.setMovieid(rs.getInt("movieid"));
				movie.setName(rs.getString("name"));
				movie.setDescr(rs.getString("descr"));
				movie.setImage(rs.getString("image"));
				movie.setPlayer(rs.getString("player"));
				movie.setTimelong(rs.getString("timelong"));
				movie.setType(rs.getString("type"));
				
				result.add(movie);
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
