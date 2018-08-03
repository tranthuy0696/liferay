package com.nlu.model;

public class AlarmInfo {
	private String name;
	private int start;
	private int end;
	private double value;

	public AlarmInfo(String name, int start, int end, double value) {
		super();
		this.name = name;
		this.start = start;
		this.end = end;
		this.value = value;
	}

	public AlarmInfo() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "AlarmInfo [name=" + name + ", start=" + start + ", end=" + end
				+ ", value=" + value + "]\n";
	}

}
