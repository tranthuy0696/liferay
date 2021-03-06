package com.nlu.schedule.session;

import java.io.File;

import com.nlu.schedule.ScheduleExecute;
import com.nlu.util.FileUtil;

public class ScheduleSessionInit {
	public static final int TIME_GET_DATA = 2;
	ScheduleExecute scheExe;
	ScheduleSessionGetData scheRun;

	public ScheduleSessionInit() {
		scheRun = new ScheduleSessionGetData();
		scheExe = new ScheduleExecute(scheRun, TIME_GET_DATA);
	}
	public void init() {
		scheExe.start();

	}

	public void deptroy() {
		scheExe.shutDown();

	}

}
