package com.nlu.entity.service.persistence;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.nlu.entity.model.Ram;
import com.nlu.entity.model.impl.RamImpl;

public class RamFinderImpl extends BasePersistenceImpl<Ram> implements RamFinder {
	public static String GET_RAM_BY_DATE = RamFinder.class.getName()
			+ ".getRamByDate";
	public static String DELETE_RAM_BY_DATE=RamFinder.class.getName()+".deleteRamByDate";

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	public List<Ram> getRamByDate(Date date) {
		Session session = null;
		SQLQuery q =null;
		List<Ram> rams=new ArrayList<Ram>();
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_RAM_BY_DATE);
			sql = StringUtil.replace(sql, "dateInput", sdf.format(date));
			System.out.println(sql);
			q = session.createSQLQuery(sql);
	            q.addEntity("Ram", RamImpl.class);
	            rams = (List<Ram>)q.list();

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
//		return new ArrayList<Ram>();
		return rams;
	}
	public void deleteRamByDate(int numberDate){
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(DELETE_RAM_BY_DATE);
			sql = StringUtil.replace(sql, "[$dateInput$]", sdf.format(new Date()));
			sql = StringUtil.replace(sql, "[$soNgay$]", numberDate+"");
			System.out.println(sql);
			session.createSQLQuery(sql);

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
	}

}
