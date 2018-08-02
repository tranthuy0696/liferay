package com.nlu.model;

public class DataAlarm {
	private long time;
	private String name;
	/**
	 * gia tri thuc
	 */
	private double value;
	/**
	 * gia tri quy dinh vuot se gui alarm
	 */
	private double valueAlarm;
	private boolean status;

	/**
	 * contructor to save data
	 * 
	 * @param time
	 * @param name
	 * @param value
	 * @param valueAlarm
	 */
	public DataAlarm(long time, String name, double value, double valueAlarm) {
		super();
		this.time = time;
		this.name = name;
		this.value = value;
		this.valueAlarm = valueAlarm;
	}

	/**
	 * contructor to get data
	 * 
	 * @param time
	 * @param name
	 * @param value
	 * @param valueAlarm
	 * @param status
	 */
	public DataAlarm(long time, String name, double value, double valueAlarm,
			boolean status) {
		super();
		this.time = time;
		this.name = name;
		this.value = value;
		this.valueAlarm = valueAlarm;
		this.status = status;
	}

	public DataAlarm() {
		super();
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getValueAlarm() {
		return valueAlarm;
	}

	public void setValueAlarm(double valueAlarm) {
		this.valueAlarm = valueAlarm;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DataAlarm [time=" + time + ", name=" + name + ", value=" + value + ", valueAlarm=" + valueAlarm
				+ ", status=" + status + "]";
	}


}
