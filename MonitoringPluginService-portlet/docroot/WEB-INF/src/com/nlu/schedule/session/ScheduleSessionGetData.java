package com.nlu.schedule.session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.nlu.model.SessionUser;
import com.nlu.util.GetApi;
import com.nlu.util.SystemUtil;

public class ScheduleSessionGetData implements Runnable {
	private List<SessionUser> oldSessions = new ArrayList<>();
	private static final Log _log = LogFactoryUtil.getLog(GetApi.class.getName());

	@Override
	public void run() {
		try {
			List<SessionUser> sessionsNow = SystemUtil.getInfoSession();
			if (!compareInfoSession(oldSessions, sessionsNow)) {
				ScheduleSessionSaveData saveData = new ScheduleSessionSaveData(sessionsNow);
				new Thread(saveData).start();
			}
			oldSessions = sessionsNow;
		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean compareInfoSession(List<SessionUser> oldSessions, List<SessionUser> newSessions) {
		if (oldSessions.size() != newSessions.size()) {
			return false;
		} else {
			oldSessions.removeAll(newSessions);
			return oldSessions.isEmpty();
		}

	}

	public static void main(String[] args) {
		try {
			System.out.println(SystemUtil.getInfoSession());
			// List<SessionUser> sessionsNow = SystemUtil.getInfoSession();
			//List<SessionUser> sessionsOld = SystemUtil.getInfoSession();
			// compareInfoSession(sessionsNow, sessionsOld);

		} catch (JSONException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
