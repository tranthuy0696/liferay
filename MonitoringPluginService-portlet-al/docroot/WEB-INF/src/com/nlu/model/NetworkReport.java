package com.nlu.model;

public class NetworkReport {
	private String time;
	private double down;
	private double up;
	
	public NetworkReport(String time, double down, double up) {
		super();
		this.time = time;
		this.down = down;
		this.up = up;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getDown() {
		return down;
	}
	public void setDown(double down) {
		this.down = down;
	}
	public double getUp() {
		return up;
	}
	public void setUp(double up) {
		this.up = up;
	}
	
}
