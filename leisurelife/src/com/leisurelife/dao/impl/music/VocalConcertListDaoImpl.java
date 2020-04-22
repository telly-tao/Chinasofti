package com.leisurelife.dao.impl.music;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.leisurelife.model.Concert;
import com.leisurelife.model.Music;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class VocalConcertListDaoImpl implements com.leisurelife.dao.music.VocalConcertListDao {
	private static Logger logger=Logger.getLogger(ConcertListDaoImpl.class);
	@Override
	public List<Concert> vocalConcertListRequest() {
		IDbUtil db =new DbUtil();
		String sql="select * from concert;";
		ResultSet rs=db.query(sql);
		
		List<Concert> result=new ArrayList<Concert>();
		try {
			while(rs.next()) {
				Concert concert=new Concert();
				concert.setConcert_id(rs.getInt("concert_id"));
				concert.setAddress(rs.getString("address"));
				concert.setCalls(rs.getString("calls"));
				concert.setDescr(rs.getString("descr"));
				concert.setImage(rs.getString("image"));
				concert.setMapx(rs.getString("mapx"));
				concert.setMapy(rs.getString("mapy"));
				concert.setName(rs.getString("name"));
				concert.setPrice(rs.getString("price"));
				concert.setTime(rs.getString("time"));
				result.add(concert);
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
