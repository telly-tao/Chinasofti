package com.leisurelife.dao.impl.theatre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.leisurelife.dao.theatre.BeijingOperaListDao;
import com.leisurelife.model.Pekingopera;
import com.leisurelife.util.DbUtil;
import com.leisurelife.util.IDbUtil;

public class BeijingOperaListDaoImpl implements BeijingOperaListDao {

	@Override
	public List<Pekingopera> beijingOperaListRequest() {
		Logger logger = Logger.getLogger(BeijingOperaListDaoImpl.class);
		// ��ȡ������������ִ�ж����ݿ�������ؽ����
		IDbUtil db = new DbUtil();
		String sql = "select * from pekingopera;";
		ResultSet rs = db.query(sql);
		// �������ݿ��ȡ�����ݼ���ȡģ�Ͷ����б���
		List<Pekingopera> result = new ArrayList<Pekingopera>();
		try {
			while (rs.next()) {
				Pekingopera pekingopera = new Pekingopera();
				pekingopera.setPekingopera_id(rs.getInt("pekingopera_id"));
				pekingopera.setAddress(rs.getString("address"));
				pekingopera.setCalls(rs.getString("calls"));
				pekingopera.setDescr(rs.getString("descr"));
				pekingopera.setImage(rs.getString("image"));
				pekingopera.setMapx(rs.getString("mapx"));
				pekingopera.setMapy(rs.getString("mapy"));
				pekingopera.setName(rs.getString("name"));
				pekingopera.setPrice(rs.getString("price"));
				pekingopera.setTime(rs.getString("time"));
				result.add(pekingopera);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		} finally {
			db.closeQurey();
		}
		return result;
	}

}
