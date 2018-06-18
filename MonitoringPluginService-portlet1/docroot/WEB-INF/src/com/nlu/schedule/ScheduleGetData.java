package com.nlu.schedule;

import java.io.IOException;

import com.liferay.portal.kernel.json.JSONException;
import com.nlu.util.SystemUtil;

public class ScheduleGetData implements Runnable {
	private RepoData repo;

	public ScheduleGetData(RepoData repo) {
		super();
		this.repo = repo;
	}

	public RepoData getRepo() {
		return repo;
	}

	public void setRepo(RepoData repo) {
		this.repo = repo;
	}

	@Override
	public void run(){
		repo.setRamData(SystemUtil.getMemoryFree());
		repo.setCpuData(SystemUtil.getCpuUsed());
		repo.setHeapData(SystemUtil.getHeapMemoryUsed());
		repo.setNonHeapData(SystemUtil.getNonHeapMemoryUsed());

	}

}
