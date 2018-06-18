package com.nlu.model;

import java.util.Date;

public class Data {
	private Date time;
	private double value;
	public Data(Date time, double value) {
		super();
		this.time = time;
		this.value = value;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	

}
