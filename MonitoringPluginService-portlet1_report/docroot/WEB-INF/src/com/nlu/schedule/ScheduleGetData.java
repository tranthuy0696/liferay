package com.nlu.schedule;

import java.io.IOException;

import org.hyperic.sigar.SigarException;

import com.liferay.portal.kernel.json.JSONException;
import com.nlu.util.NetworkUtil;
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
		try{
		repo.setRamData(SystemUtil.usage(SystemUtil.getMemoryFree(),SystemUtil.getMaxMemory()));
		repo.setCpuData(SystemUtil.getCpuUsed());
		repo.setHeapData(SystemUtil.getHeapMemoryUsed());
		repo.setNonHeapData(SystemUtil.getNonHeapMemoryUsed());
		repo.setNetworkData(NetworkUtil.getMetric());
		}
		 catch (SigarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
