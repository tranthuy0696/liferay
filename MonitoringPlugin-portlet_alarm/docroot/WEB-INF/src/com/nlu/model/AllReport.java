package com.nlu.model;

import java.util.List;

public class AllReport {
	private List<DataPoint> ramReport;
	private List<DataPoint> cpuReport;
	private List<DataPoint> heapReport;
	private List<DataPoint> nonheapReport;
	private List<DataPoints> sessionReport;
	private List<DataPoints> networkReport;
	public AllReport(List<DataPoint> ramReport, List<DataPoint> cpuReport,
			List<DataPoint> heapReport, List<DataPoint> nonheapReport,
			List<DataPoints> sessionReport, List<DataPoints> networkReport) {
		super();
		this.ramReport = ramReport;
		this.cpuReport = cpuReport;
		this.heapReport = heapReport;
		this.nonheapReport = nonheapReport;
		this.sessionReport = sessionReport;
		this.networkReport = networkReport;
	}
	public AllReport() {
		super();
	}
	public List<DataPoint> getRamReport() {
		return ramReport;
	}
	public void setRamReport(List<DataPoint> ramReport) {
		this.ramReport = ramReport;
	}
	public List<DataPoint> getCpuReport() {
		return cpuReport;
	}
	public void setCpuReport(List<DataPoint> cpuReport) {
		this.cpuReport = cpuReport;
	}
	public List<DataPoint> getHeapReport() {
		return heapReport;
	}
	public void setHeapReport(List<DataPoint> heapReport) {
		this.heapReport = heapReport;
	}
	public List<DataPoint> getNonheapReport() {
		return nonheapReport;
	}
	public void setNonheapReport(List<DataPoint> nonheapReport) {
		this.nonheapReport = nonheapReport;
	}
	public List<DataPoints> getSessionReport() {
		return sessionReport;
	}
	public void setSessionReport(List<DataPoints> sessionReport) {
		this.sessionReport = sessionReport;
	}
	public List<DataPoints> getNetworkReport() {
		return networkReport;
	}
	public void setNetworkReport(List<DataPoints> networkReport) {
		this.networkReport = networkReport;
	}

}
