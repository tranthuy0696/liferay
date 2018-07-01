package com.nlu.schedule;

public class ScheduleCreate {
	public static final int TIME_GET_DATA = 2;
	public static final int TIME_SAVE_DATA = 60;
	RepoData repo;

	ScheduleGetData getData;
	ScheduleSaveData saveData;
	ScheduleExecute exeGetData;
	ScheduleExecute exeSaveData;

	public ScheduleCreate() {
		repo = new RepoData();
		getData = new ScheduleGetData(repo);
		saveData = new ScheduleSaveData(repo);
		exeGetData = new ScheduleExecute(getData, TIME_GET_DATA);
		exeSaveData = new ScheduleExecute(saveData, TIME_SAVE_DATA);
	}

	public void init() {
		exeGetData.start();
		exeSaveData.start();

	}

	public void deptroy() {
		exeGetData.shutDown();
		exeSaveData.shutDown();

	}

}
