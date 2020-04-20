package com.telly.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/db_test?useUnicode=true&characterEncoding=UTF8";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	//public void DbUtil(){}
	private Connection getConnection() {
		Connection conn = null;
		try {
			// 加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			// 创建连接对象
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 
	 * @param sql
	 * @return 查询结果集
	 * 
	 */
	Connection con = null;
	Statement smt = null;
	public ResultSet query(String sql) {
		// 连接数据库时，需提供数据库的地址、用户名、密码
		
		ResultSet rs = null;
		try {
			// 创建连接对象
			con = getConnection();
			// 创建适配器
			smt = con.createStatement();
			// 创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
			rs = smt.executeQuery(sql);
			// int rs=smt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return rs;
	}
	public void closeQurey() {
		try {
			smt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param sql
	 * @return 是否更新成功
	 */
	public int update(String sql) {
		Connection con =null;
		Statement smt=null;
		int result=0;
		try {
			//创建连接对象
			con =getConnection();
			//设置非自动提交
			con.setAutoCommit(false);
			//创建适配器
			smt=con.createStatement();
			//创建并获取数据集executeQuery执行不做修改的操作，返回数据集，executeUpdate执行对数据有改动的语句，返回受影响的条数。
			result=smt.executeUpdate(sql);
			//提交事务
			con.commit();

		}catch (Exception e) {
			try {
				//回滚事务
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(e);

		}
		finally {
			closeStatement(smt);
			closeConnection(con);
		}
		return result;
	}
	
	
	/**
	 * 关闭适配器
	 * @param s
	 */
	public static void closeStatement(Statement s) {
		try {
			s.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 关闭连接
	 * @param c
	 */
	public static void closeConnection(Connection c) {
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
