package com.nlu.schedule;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.nlu.service.MonitorDirectory;

public class ScheduleCreate {
	public static final int TIME_GET_DATA = 2;
	public static final int TIME_SAVE_DATA = 60;
	RepoData repo;

	ScheduleGetData getData;
	ScheduleSaveData saveData;
	ScheduleExecute exeGetData;
	ScheduleExecute exeSaveData;
	Thread monitorDirectory;

	public ScheduleCreate() {
		repo = new RepoData();
		getData = new ScheduleGetData(repo);
		saveData = new ScheduleSaveData(repo);
		exeGetData = new ScheduleExecute(getData, TIME_GET_DATA);
		exeSaveData = new ScheduleExecute(saveData, TIME_SAVE_DATA);
		try {
			monitorDirectory=new Thread(new MonitorDirectory());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void init() {
		exeGetData.start();
		exeSaveData.start();
		monitorDirectory.start();

	}

	public void deptroy() {
		exeGetData.shutDown();
		exeSaveData.shutDown();

	}

}
