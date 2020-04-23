package com.leisurelife.dao.impl.movie;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.leisurelife.dao.movie.MovieCommentDao;
import com.leisurelife.dao.movie.MovieCommentSubmitDao;
import com.leisurelife.model.Recommend;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class MovieCommentSubmitDaoImpl implements MovieCommentSubmitDao {
	private static Logger logger=Logger.getLogger(MovieListDaoImpl.class);
	@Override
	public int movieCommentSubmitRequest(Map<String, Object> map) {
		MovieCommentDaoImpl movieCommentDao;
		IDbUtil db =new DbUtil();
		Date d=new Date();
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
		//¡–
		String date=ft.format(d);
		int mid=Integer.parseInt(map.get("mid").toString());
		int type=Integer.parseInt(map.get("type").toString());
		String content=map.get("content").toString();
		String username=map.get("username").toString();
		//sql”Ôæ‰
		String sql="insert into Recommend(username,time,content,type,tid) values (username='"+username+"',"
				+ "time="+date+",content='"+content+"',type="+type+",tid="+mid+");";
		int result=db.update(sql);
		return result;
	}

}
