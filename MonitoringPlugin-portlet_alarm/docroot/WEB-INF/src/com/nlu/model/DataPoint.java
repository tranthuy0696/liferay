package com.nlu.model;

public class DataPoint {
	private long x;
	private double y;

	public DataPoint(long x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
