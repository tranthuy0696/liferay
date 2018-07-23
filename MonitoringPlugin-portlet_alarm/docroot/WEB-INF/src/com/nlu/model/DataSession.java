package com.nlu.model;

public class DataSession {
private String name;
private long number;

public DataSession() {
	super();
}

public DataSession(String name, long number) {
	super();
	this.name = name;
	this.number = number;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getNumber() {
	return number;
}
public void setNumber(long number) {
	this.number = number;
}

@Override
public String toString() {
	return "DataSession [name=" + name + ", number=" + number + "]";
}

}
