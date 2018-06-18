package com.nlu.model;

public class SessionResponse {
	private long numberLogin;
	private long numberLogout;

	public SessionResponse() {
	}

	public SessionResponse(long numberLogin, long numberLogout) {
		this.numberLogin = numberLogin;
		this.numberLogout = numberLogout;
	}

	public long getNumberLogin() {
		return numberLogin;
	}

	public void setNumberLogin(long numberLogin) {
		this.numberLogin = numberLogin;
	}

	public long getNumberLogout() {
		return numberLogout;
	}

	public void setNumberLogout(long numberLogout) {
		this.numberLogout = numberLogout;
	}

}
