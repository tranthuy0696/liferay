package com.nlu.schedule.session;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.nlu.model.SessionUser;
import com.nlu.service.SaveDataService;
import com.nlu.util.FileUtil;

public class ScheduleSessionSaveData implements Runnable {
	List<SessionUser> data;
	FileUtil fileUtil = new FileUtil();
	SaveDataService saveDataService=new SaveDataService();
	public ScheduleSessionSaveData(List<SessionUser> sessionsNow) {
		super();
		this.data = sessionsNow;
	}

	@Override
	public void run() {
		try {
			String pathSession = fileUtil.getPathSaveDataMonitor(FileUtil.PATH_SESSIONREQUEST);
			long time=new Date().getTime();
			if(data.size()!=0)
			time=data.get(0).getTime().getTime();
			long login=0;
			long logout=0;
			for (SessionUser sessionUser : data) {
				if (sessionUser.isLogin()) {
					login+=1;
				} else {
					logout+=1;
				}
			}
			saveDataService.saveDataSessionRequest(fileUtil, login, logout, time, pathSession);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

}
