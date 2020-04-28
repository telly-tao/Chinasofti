package com.leisurelife.dao.impl.theatre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.leisurelife.dao.theatre.ModernDramaListDao;
import com.leisurelife.model.Play;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class ModernDramaListDaoImpl implements ModernDramaListDao {

	@Override
	public List<Play> modernDramaListRequest() {
		Logger logger = Logger.getLogger(BeijingOperaListDaoImpl.class);
		// 连接操作数据库工具
		IDbUtil db = new DbUtil();
		String sql = "select * from play;";
		ResultSet rs = db.query(sql);
		// 用于存放数据的list
		List<Play> result = new ArrayList<Play>();
		try {
			while (rs.next()) {
				Play play = new Play();
				play.setPlay_id(rs.getInt("play_id"));
				play.setAddress(rs.getString("address"));
				play.setCalls(rs.getString("calls"));
				play.setDescr(rs.getString("descr"));
				play.setImage(rs.getString("image"));
				play.setMapx(rs.getString("mapx"));
				play.setMapy(rs.getString("mapy"));
				play.setName(rs.getString("name"));
				play.setPrice(rs.getString("price"));
				play.setTime(rs.getString("time"));
				result.add(play);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		} finally {
			db.closeQurey();
		}
		System.out.println("Dao result:" + result);
		return result;
	}

}
