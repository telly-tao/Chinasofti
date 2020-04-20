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
			// ����������
			Class.forName("com.mysql.jdbc.Driver");
			// �������Ӷ���
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 
	 * @param sql
	 * @return ��ѯ�����
	 * 
	 */
	Connection con = null;
	Statement smt = null;
	public ResultSet query(String sql) {
		// �������ݿ�ʱ�����ṩ���ݿ�ĵ�ַ���û���������
		
		ResultSet rs = null;
		try {
			// �������Ӷ���
			con = getConnection();
			// ����������
			smt = con.createStatement();
			// ��������ȡ���ݼ�executeQueryִ�в����޸ĵĲ������������ݼ���executeUpdateִ�ж������иĶ�����䣬������Ӱ���������
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
	 * @return �Ƿ���³ɹ�
	 */
	public int update(String sql) {
		Connection con =null;
		Statement smt=null;
		int result=0;
		try {
			//�������Ӷ���
			con =getConnection();
			//���÷��Զ��ύ
			con.setAutoCommit(false);
			//����������
			smt=con.createStatement();
			//��������ȡ���ݼ�executeQueryִ�в����޸ĵĲ������������ݼ���executeUpdateִ�ж������иĶ�����䣬������Ӱ���������
			result=smt.executeUpdate(sql);
			//�ύ����
			con.commit();

		}catch (Exception e) {
			try {
				//�ع�����
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
	 * �ر�������
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
	 * �ر�����
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
