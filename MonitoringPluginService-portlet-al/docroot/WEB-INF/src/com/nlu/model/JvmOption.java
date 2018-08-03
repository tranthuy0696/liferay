package com.nlu.model;

public class JvmOption {
	private int xmx;
	private int xms;
	private int newSize;
	private int maxNewSize;
	private int maxPermSize;
	
	public JvmOption() {
		super();
	}
	public JvmOption(int xmx, int xms, int newSize, int maxNewSize, int maxPermSize) {
		super();
		this.xmx = xmx;
		this.xms = xms;
		this.newSize = newSize;
		this.maxNewSize = maxNewSize;
		this.maxPermSize = maxPermSize;
	}
	public int getXmx() {
		return xmx;
	}
	public void setXmx(int xmx) {
		this.xmx = xmx;
	}
	public int getXms() {
		return xms;
	}
	public void setXms(int xms) {
		this.xms = xms;
	}
	public int getNewSize() {
		return newSize;
	}
	public void setNewSize(int newSize) {
		this.newSize = newSize;
	}
	public int getMaxNewSize() {
		return maxNewSize;
	}
	public void setMaxNewSize(int maxNewSize) {
		this.maxNewSize = maxNewSize;
	}
	public int getMaxPermSize() {
		return maxPermSize;
	}
	public void setMaxPermSize(int maxPermSize) {
		this.maxPermSize = maxPermSize;
	}
	

}
