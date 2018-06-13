package com.nlu.schedule;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.nlu.entity.service.CpuLocalServiceUtil;
import com.nlu.entity.service.HeapLocalServiceUtil;
import com.nlu.entity.service.NonHeapLocalServiceUtil;
import com.nlu.entity.service.RamLocalServiceUtil;
import com.nlu.model.Data;

public class ScheduleSaveData implements Runnable {
	private RepoData repo;

	public ScheduleSaveData(RepoData repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void run() {
		try {
			for (Data data : repo.getRamData()) {
				RamLocalServiceUtil.addRam(data.getTime(), data.getValue(), new ServiceContext());
			}
			for (Data data : repo.getCpuData()) {
				CpuLocalServiceUtil.addCpu(data.getTime(), data.getValue(), new ServiceContext());
			}
			for (Data data : repo.getHeapData()) {
				HeapLocalServiceUtil.addHeap(data.getTime(), data.getValue(), new ServiceContext());
			}
			for (Data data : repo.getNonHeapData()) {
				NonHeapLocalServiceUtil.addNonHeap(data.getTime(), data.getValue(), new ServiceContext());
			}
			
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public RepoData getRepo() {
		return repo;
	}

	public void setRepo(RepoData repo) {
		this.repo = repo;
	}

}
