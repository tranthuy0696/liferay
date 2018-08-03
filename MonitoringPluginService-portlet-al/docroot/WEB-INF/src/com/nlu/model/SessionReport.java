package com.nlu.model;

import java.util.List;

public class SessionReport {
	private String date;
	private List<DataSession> listBrowser;
	private List<DataSession> listLoginOut;
	private List<DataSession> listOs;

	public SessionReport(String date, List<DataSession> listBrowser,
			List<DataSession> listLoginOut, List<DataSession> listOs) {
		super();
		this.date = date;
		this.listBrowser = listBrowser;
		this.listLoginOut = listLoginOut;
		this.listOs = listOs;
	}

	public SessionReport() {
		super();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<DataSession> getListBrowser() {
		return listBrowser;
	}

	public void setListBrowser(List<DataSession> listBrowser) {
		this.listBrowser = listBrowser;
	}

	public List<DataSession> getListLoginOut() {
		return listLoginOut;
	}

	public void setListLoginOut(List<DataSession> listLoginOut) {
		this.listLoginOut = listLoginOut;
	}

	public List<DataSession> getListOs() {
		return listOs;
	}

	public void setListOs(List<DataSession> listOs) {
		this.listOs = listOs;
	}

}
