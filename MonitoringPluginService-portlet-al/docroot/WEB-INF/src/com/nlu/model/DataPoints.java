package com.nlu.model;

public class DataPoints {
	private long x;
	private double y1;
	private double y2;

	public DataPoints(long x, double y1, double y2) {
		super();
		this.x = x;
		this.y1 = y1;
		this.y2 = y2;
	}

	public DataPoints() {
		super();
	}

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

}
