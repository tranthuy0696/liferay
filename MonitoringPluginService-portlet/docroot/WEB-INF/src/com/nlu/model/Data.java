package com.nlu.model;

public class Data {
	private double min;
	private double max;
	private double average;
	public Data(double min, double max, double average) {
		super();
		this.min = min;
		this.max = max;
		this.average = average;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = this.getMin()< min ? this.getMin():min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = this.getMax()> max ? this.getMax(): max;
	}
	public Data() {
		this.min = Double.MAX_VALUE;
		this.max = 0;
	}
	public void reset(){
		this.min = Double.MAX_VALUE;
		this.max = 0;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	

}
