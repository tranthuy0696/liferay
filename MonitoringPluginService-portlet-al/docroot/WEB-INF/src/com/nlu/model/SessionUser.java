package com.nlu.model;

import java.util.Date;

public class SessionUser {
	private Date time;
	private String id;
	private boolean login;
	private String ip;
	private String system;
	private String browser;

	public SessionUser(String id, String ip) {
		super();
		this.time = new Date();
		this.ip = ip;
		this.id = id;

	}
	

	public boolean isLogin() {
		return login;
	}


	public void setLogin(boolean login) {
		this.login = login;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public void parseSessionAgent(String agent) {
		String[] str = agent.split("\\s");
		this.system = str[1].substring(1);
		this.browser = parseBrowser(str[str.length - 1], str[str.length - 2]);

	}

	public String parseBrowser(String lastIndex, String nearIndex) {
		switch (lastIndex) {
		case "Firefox/60.0":

			return "Firefox";
		case "Edge/17.17134":

			return "Edge";
		case "Safari/537.36":

			if (nearIndex.equals("Chrome/66.0.3359.181")) {
				return "Chrome";
			}
			return "CocCoc";

		default:
			return "unknow";
		}

	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((browser == null) ? 0 : browser.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + (login ? 1231 : 1237);
		result = prime * result + ((system == null) ? 0 : system.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SessionUser other = (SessionUser) obj;
		if (browser == null) {
			if (other.browser != null)
				return false;
		} else if (!browser.equals(other.browser))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (login != other.login)
			return false;
		if (system == null) {
			if (other.system != null)
				return false;
		} else if (!system.equals(other.system))
			return false;
		return true;
	}

	

}
