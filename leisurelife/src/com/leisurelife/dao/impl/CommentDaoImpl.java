package com.leisurelife.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.leisurelife.dao.CommentDao;
import com.leisurelife.model.Recommend;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class CommentDaoImpl implements CommentDao {
	@Override
	public List<Recommend> commentRequest(Map<String, Object> map) {
		Logger logger=Logger.getLogger(CommentDaoImpl.class);
		IDbUtil db =new DbUtil();
		System.out.println("map:"+map);
		//提取传过来的数据执行对数据库操作返回结果集
		int type=Integer.parseInt( map.get("type").toString());
		int tid=Integer.parseInt( map.get("mid").toString());
		System.out.println("map:"+map);
		System.out.println("type:"+type);
		String sql="select * from Recommend where tid="+tid+" and type="+type+";";
		ResultSet rs=db.query(sql);
		//将从数据库获取的数据集存取模型对象列表中
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
		System.out.println("commentDao:"+result);
		return result;
	}

}
