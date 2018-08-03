package com.nlu.entity.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import com.nlu.entity.model.Alarm;
import com.nlu.entity.model.impl.AlarmImpl;

public class AlarmFinderImpl extends BasePersistenceImpl<Alarm> implements AlarmFinder {
	public static String GET_ALARM_BY_TIME = AlarmFinder.class.getName()
			+ ".getAlarmByTime";
	public List<Alarm> getAlarmByTime(int value,String name) {
	Session session = null;
	SQLQuery q =null;
	List<Alarm> alarm =new ArrayList<Alarm>();
	try {
		session = openSession();
		String sql = CustomSQLUtil.get(GET_ALARM_BY_TIME);
		sql = StringUtil.replace(sql, "[$value]", value+"");
		sql = StringUtil.replace(sql, "[$name]", name);
		System.out.println(sql);
		q = session.createSQLQuery(sql);
            q.addEntity("Alarm", AlarmImpl.class);
            alarm = (List<Alarm>)q.list();

	} catch (Exception e) {
		try {
			throw new SystemException(e);
		} catch (SystemException se) {
			se.printStackTrace();
		}
	} finally {
		closeSession(session);
	}
	return alarm;

	}

}
