package com.leisurelife.dao.impl.delicious;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.leisurelife.dao.delicious.HotedetailDao;
import com.leisurelife.model.Hotedetail;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class HotedetailDaoImpl implements HotedetailDao {
	private static Logger logger=Logger.getLogger(DeliciousListDaoImpl.class);
	@Override
	public List<Hotedetail> hotedetailDaoRequest() {
		IDbUtil db =new DbUtil();
		//��ȡ������������ִ�ж����ݿ�������ؽ����
		String sql="select * from hotedetail;";
		ResultSet rs=db.query(sql);
		//���������б�
		//�������ݿ��ȡ�����ݼ���ȡģ�Ͷ����б���
		List<Hotedetail> result=new ArrayList<Hotedetail>();
		try {
			while(rs.next()) {
				Hotedetail hotedetail=new Hotedetail();
				hotedetail.setPk_id(rs.getInt("pk_id"));
				hotedetail.setFk_id(rs.getInt("fk_id"));
				hotedetail.setName(rs.getString("name"));
				hotedetail.setImage(rs.getString("image"));
				hotedetail.setNewprice(rs.getInt("newprice"));
				hotedetail.setOldprice(rs.getInt("oldprice"));
				result.add(hotedetail);
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
