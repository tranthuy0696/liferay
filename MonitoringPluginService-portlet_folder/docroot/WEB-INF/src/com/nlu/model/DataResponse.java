package com.nlu.model;

public class DataResponse {
	private double dataUsage;
	private double percentUsage;

	public DataResponse(double dataUsage, double percentUsage) {
		this.dataUsage = dataUsage;
		this.percentUsage = percentUsage;
	}

	public double getDataUsage() {
		return dataUsage;
	}

	public void setDataUsage(double dataUsage) {
		this.dataUsage = dataUsage;
	}

	public double getPercentUsage() {
		return percentUsage;
	}

	public void setPercentUsage(double percentUsage) {
		this.percentUsage = percentUsage;
	}

	@Override
	public String toString() {
		return "DataResponse [dataUsage=" + dataUsage + ", percentUsage="
				+ percentUsage + "]";
	}
	

}
