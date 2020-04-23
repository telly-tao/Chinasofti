package com.leisurelife.dao.impl.movie;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.leisurelife.dao.impl.music.ConcertListDaoImpl;
import com.leisurelife.model.Movie;
import com.leisurelife.model.Music;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class MovieListDaoImpl implements com.leisurelife.dao.movie.MovieListDao {
	private static Logger logger=Logger.getLogger(MovieListDaoImpl.class);
	@Override
	public List<Movie> movieListRequest() {
		IDbUtil db =new DbUtil();
		String sql="select * from movie;";
		ResultSet rs=db.query(sql);
		
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
