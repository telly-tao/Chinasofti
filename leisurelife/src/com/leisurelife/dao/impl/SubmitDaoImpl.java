package com.leisurelife.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.leisurelife.dao.SubmitDao;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class SubmitDaoImpl implements SubmitDao {
	@Override
	public int submitRequest(Map<String, Object> map) {
		IDbUtil db =new DbUtil();
		Date d=new Date();
		SimpleDateFormat ft=new SimpleDateFormat("yyyy-MM-dd");
		//接收数据列表
		String date=ft.format(d);
		int mid=Integer.parseInt(map.get("mid").toString());
		int type=Integer.parseInt(map.get("type").toString());
		String content=map.get("content").toString();
		String username=map.get("username").toString();
		//sql语句
		String sql="insert into Recommend(username,time,content,type,tid) values ('"+username+"',"
				+ "'"+date+"','"+content+"',"+type+","+mid+");";
		//获取执行结果
		int result=db.update(sql);
		System.out.println("sql:"+sql+"执行结果:"+result);
		return result;
	}

}
