package com.nlu.model;

public class DataReport {
	private String time;
	private double value;

	public DataReport(String time, double value) {
		this.time = time;
		this.value = value;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
