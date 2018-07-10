package com.nlu.entity.service.persistence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.nlu.entity.model.Cpu;
import com.nlu.entity.model.Ram;
import com.nlu.entity.model.SessionRequest;
import com.nlu.entity.model.impl.RamImpl;
import com.nlu.entity.model.impl.SessionRequestImpl;
import com.nlu.model.DataSession;

public class SessionRequestFinderImpl  extends BasePersistenceImpl<SessionRequest> implements SessionRequestFinder{
	public static String DELETE_SESSION_REQUEST_BY_DATE=SessionRequestFinder.class.getName()+".deleteSessionRequestByDate";
	public static String SEARCH_SESSION_REQUEST_BY_DATE=SessionRequestFinder.class.getName()+".searchSessionRequestByDate";
	public static String GET_REPORT_SESSION_REQUEST_BY_DATE=SessionRequestFinder.class.getName()+".getReportSessionRequestByDate";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
	public void deleteSessionRequestByDate(int numberDate){
		Session session = null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(DELETE_SESSION_REQUEST_BY_DATE);
			sql = StringUtil.replace(sql, "[$dateInput$]", sdf.format(new Date()));
			sql = StringUtil.replace(sql, "[$soNgay$]", numberDate+"");
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
	public List<SessionRequest> searchSessionRequestByDate(String date) {
		Session session = null;
		SQLQuery q =null;
		List<SessionRequest> sessionRequests=new ArrayList<SessionRequest>();
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(SEARCH_SESSION_REQUEST_BY_DATE);
			sql = StringUtil.replace(sql, "[$date$]", date);
			System.out.println(sql);
			q = session.createSQLQuery(sql);
	            q.addEntity("SessionRequest", SessionRequestImpl.class);
	            sessionRequests = (List<SessionRequest>)q.list();

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		
		return sessionRequests;
	}
	public List getListSessionRequestReportByDate(String columnName, String date){
		Session session = null;
		SQLQuery q =null;
		try {
			session = openSession();
			String sql = CustomSQLUtil.get(GET_REPORT_SESSION_REQUEST_BY_DATE);
			sql = StringUtil.replace(sql, "[$date$]", date);
			sql=StringUtil.replace(sql, "[$columnName$]", columnName);
			System.out.println("query: "+sql);
			q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addScalar("name", Type.STRING);
			q.addScalar("numbers",Type.INTEGER);
			QueryPos pos=QueryPos.getInstance(q);
			return (List)q.list();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
		
	}
}
