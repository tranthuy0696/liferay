package com.nlu.entity.service.persistence;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.nlu.entity.model.Cpu;
import com.nlu.entity.model.NonHeap;

public class NonHeapFinderImpl  extends BasePersistenceImpl<NonHeap> implements NonHeapFinder{
	public static String DELETE_NON_HEAP_BY_DATE=RamFinder.class.getName()+".deleteNonHeapByDate";
	public void deleteNonHeapByDate(int numberDate){
		Session session = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(DELETE_NON_HEAP_BY_DATE);
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
