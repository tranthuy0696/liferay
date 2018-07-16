package com.nlu.model;

import java.util.List;

public class DirectoryData {
	private double size;
	private String contentGUI;
	private List<String> eventList;
	private boolean status;

	public DirectoryData(double size, String contentGUI,
			List<String> eventList, boolean status) {
		super();
		this.size = size;
		this.contentGUI = contentGUI;
		this.eventList = eventList;
		this.status=status;
	}

	public DirectoryData() {
		super();
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public String getContentGUI() {
		return contentGUI;
	}

	public void setContentGUI(String contentGUI) {
		this.contentGUI = contentGUI;
	}

	public List<String> getEventList() {
		return eventList;
	}

	public void setEventList(List<String> eventList) {
		this.eventList = eventList;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
