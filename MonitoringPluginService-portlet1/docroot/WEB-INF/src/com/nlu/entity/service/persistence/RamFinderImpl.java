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

	public List<Ram> getRamByDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Session session = null;
		SQLQuery q =null;
		List<Ram> rams=new ArrayList<Ram>();
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_RAM_BY_DATE);
			sql = StringUtil.replace(sql, "dateInput", sdf.format(date));
			System.out.println(sql);
			q = session.createSQLQuery(sql);
//			System.out.println(q.list().size());
//			System.out.println(q.list());
	            q.addEntity("Ram", RamImpl.class);
//			Iterator<Ram> iter = q.list().iterator();
//			if (iter.hasNext()) {
//				Ram r = iter.next();
//				rs.add(r);
//			}
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

}
