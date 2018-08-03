package com.nlu.schedule;

import java.io.IOException;
import java.util.Date;

import org.hyperic.sigar.SigarException;

import com.liferay.portal.kernel.json.JSONException;
import com.nlu.alarm.AlarmNotify;
import com.nlu.model.AlarmName;
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
	public void run() {
		try {
			Date date = new Date();
			// get info
			double ram = SystemUtil.usage(SystemUtil.getMemoryFree(), SystemUtil.getMaxMemory());
			double cpu = SystemUtil.getCpuUsed();
			long heap = SystemUtil.getHeapMemoryUsed();
			long nonHeap = SystemUtil.getNonHeapMemoryUsed();
			// save info
			repo.setRamData(date, ram);
			repo.setCpuData(date, cpu);
			repo.setHeapData(date, heap);
			repo.setNonHeapData(date, nonHeap);
			repo.setNetworkData(NetworkUtil.getMetric());
			//alarm 
			AlarmNotify alarmNotify = new AlarmNotify();
			alarmNotify.checkNotify(AlarmName.Ram,date,SystemUtil.convertByteToGB(ram));
			alarmNotify.checkNotify(AlarmName.Cpu,date,cpu);
			alarmNotify.checkNotify(AlarmName.Heap,date,SystemUtil.convertByteToMB(heap));
			alarmNotify.checkNotify(AlarmName.NonHeap,date,SystemUtil.convertByteToMB(nonHeap));
		} catch (SigarException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
