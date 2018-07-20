package com.nlu.model;

import java.util.Date;

public class NetworkData {
	private Date time;
	private long rx;
	private long tx;
	public NetworkData(Date time, long rx, long tx) {
		super();
		this.time = time;
		this.rx = rx;
		this.tx = tx;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public long getRx() {
		return rx;
	}
	public void setRx(long d) {
		this.rx = d;
	}
	@Override
	public String toString() {
		return time.getTime()+" "+rx+" "+tx;
	}
	public long getTx() {
		return tx;
	}
	public void setTx(long tx) {
		this.tx = tx;
	}

	

}