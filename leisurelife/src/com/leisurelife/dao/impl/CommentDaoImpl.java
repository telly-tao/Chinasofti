package com.leisurelife.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.leisurelife.dao.CommentDao;
import com.leisurelife.dao.impl.movie.MovieListDaoImpl;
import com.leisurelife.model.Recommend;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class CommentDaoImpl implements CommentDao {
	@Override
	public List<Recommend> commentRequest(Map<String, Object> map) {
		Logger logger=Logger.getLogger(CommentDaoImpl.class);
		IDbUtil db =new DbUtil();
		//��ȡ������������ִ�ж����ݿ�������ؽ����
		int type=Integer.parseInt( map.get("type").toString());
		type=1;
		int mid=Integer.parseInt( map.get("mid").toString());
		String sql="select * from Recommend where tid="+mid+" and type="+type+";";
		ResultSet rs=db.query(sql);
		//�������ݿ��ȡ�����ݼ���ȡģ�Ͷ����б���
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
