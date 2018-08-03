package com.nlu.model;

import java.util.List;

public class Report {
	private String date;
	List<DataReport> data;
	public Report(String date, List<DataReport> data) {
		super();
		this.date = date;
		this.data = data;
	}
	
	public Report() {
		super();
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<DataReport> getData() {
		return data;
	}
	public void setData(List<DataReport> data) {
		this.data = data;
	}

	

}
