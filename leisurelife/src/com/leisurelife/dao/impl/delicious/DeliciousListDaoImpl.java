package com.leisurelife.dao.impl.delicious;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.leisurelife.dao.delicious.DeliciousListDao;
import com.leisurelife.model.Delicacies;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class DeliciousListDaoImpl implements DeliciousListDao {
	private static Logger logger=Logger.getLogger(DeliciousListDaoImpl.class);
	@Override
	public List<Delicacies> deliciousListRequest() {
		IDbUtil db =new DbUtil();
		//��ȡ������������ִ�ж����ݿ�������ؽ����
		String sql="select * from delicacies;";
		ResultSet rs=db.query(sql);
		SimpleDateFormat ft=new SimpleDateFormat("yyyy");
		//���������б�
		//�������ݿ��ȡ�����ݼ���ȡģ�Ͷ����б���
		List<Delicacies> result=new ArrayList<Delicacies>();
		try {
			while(rs.next()) {
				Delicacies delicacies=new Delicacies();
				delicacies.setDelicacies(rs.getInt("delicacies_id"));
				delicacies.setAvgs(rs.getInt("avgs"));
				delicacies.setName(ft.parse(rs.getString("name")));
				delicacies.setAddress(rs.getString("address"));
				delicacies.setCalls(rs.getString("calls"));
				delicacies.setImage(rs.getString("image"));
				delicacies.setMapx(rs.getString("mapx"));
				delicacies.setMapy(rs.getString("mapy"));
				delicacies.setLabel(rs.getString("label"));
				result.add(delicacies);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		finally {
			db.closeQurey();
		}
		return result;
	}

}
