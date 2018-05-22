package com.nlu.util;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.nlu.entity.service.CpuLocalServiceUtil;
import com.nlu.entity.service.RamLocalServiceUtil;
import com.nlu.model.Data;

public class ScheduleSystemResource {
	private static ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
	public static double minRam = Double.MAX_VALUE;
	public static double maxRam = 0;
	public static double averRam = 0;
	public static double minCpu = Double.MAX_VALUE;
	public static double maxCpu = 0;
	public static double averCpu = 0;
	public static Data ram = new Data();
	public static Data cpu = new Data();
	public static Data heap = new Data();
	public static Data nonHeap = new Data();
	public static int count = 0;
	public static final int TIME_SECONDS = 10 * 60; // 10 minutes

	public static void start() {
		schedule = Executors.newScheduledThreadPool(1);
		Runnable pinger = new Runnable() {
			public void run() {
				if (count == TIME_SECONDS) {
					try {
						// save ram info into database
						RamLocalServiceUtil.addRam(new Date(), ram.getMin(), ram.getMax(), ram.getAverage(),
								new ServiceContext());
						CpuLocalServiceUtil.addCpu(new Date(), cpu.getMin(), cpu.getMax(), cpu.getAverage(),
								new ServiceContext());
						resetValue();
					} catch (PortalException | SystemException e) {
						e.printStackTrace();
					}
				} else {
					count++;
					setCpu(100 - SystemUtil.getCpuFree());
					setRam(100 - SystemUtil.getMemoryFree());
				}
			}
		};
		schedule.scheduleAtFixedRate(pinger, 10, 1, TimeUnit.SECONDS);
	}

	public static void deptroy() {
		schedule.shutdown();
	}

	public static void setRam(double value) {
		ram.setMin(value);
		ram.setMax(value);

	}

	public static void setCpu(double value) {
		cpu.setMin(value);
		cpu.setMax(value);
	}

	private static void resetValue() {
		ram.reset();
		cpu.reset();
	}

}
