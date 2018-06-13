package com.nlu.schedule.session;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.nlu.entity.service.SessionRequestLocalServiceUtil;
import com.nlu.model.SessionUser;

public class ScheduleSessionSaveData implements Runnable {
	List<SessionUser> data;

	public ScheduleSessionSaveData(List<SessionUser> sessionsNow) {
		super();
		this.data = sessionsNow;
	}

	@Override
	public void run() {
		try {
			for (SessionUser sessionRequest : data) {

				SessionRequestLocalServiceUtil.addSessionRequest(sessionRequest.getId(), sessionRequest.getTime(),sessionRequest.getIp() , sessionRequest.getBrowser(), sessionRequest.getSystem(),sessionRequest.isLogin(), new ServiceContext());

			}
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

}
