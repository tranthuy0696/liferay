package com.nlu.schedule;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleExecute {
	private ScheduledExecutorService schedule;
	private Runnable program;
	private int scheduleTime;

	public ScheduleExecute(Runnable program, int scheduleTime) {
		super();
		this.schedule = Executors.newScheduledThreadPool(1);
		this.program = program;
		this.scheduleTime = scheduleTime;
	}

	public void start() {
		schedule.scheduleAtFixedRate(this.program, 10, this.scheduleTime, TimeUnit.SECONDS);

	}

	public void shutDown() {
		schedule.shutdown();
	}

}
