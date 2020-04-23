package com.leisurelife.dao.impl.music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.leisurelife.dao.music.ConcertListDao;
import com.leisurelife.model.Music;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class ConcertListDaoImpl implements ConcertListDao {
	private static Logger logger=Logger.getLogger(ConcertListDaoImpl.class);
	@Override
	public List<Music> concertListRequest() {
		
		IDbUtil db =new DbUtil();
		String sql="select * from music;";
		ResultSet rs=db.query(sql);
		
		List<Music> result=new ArrayList<Music>();
		try {
			while(rs.next()) {
				Music music=new Music();
				music.setMusicid(rs.getInt("musicid"));
				music.setAddress(rs.getString("address"));
				music.setCalls(rs.getString("calls"));
				music.setDescr(rs.getString("descr"));
				music.setImage(rs.getString("image"));
				music.setMapx(rs.getString("mapx"));
				music.setMapy(rs.getString("mapy"));
				music.setName(rs.getString("name"));
				music.setPrice(rs.getString("price"));
				music.setTime(rs.getString("time"));
				result.add(music);
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
