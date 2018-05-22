package com.nlu;

public class SessionUser {
	private String id;
	private String ip;
	private String system;
	private String browser;

	public SessionUser(String id, String ip) {
		super();
		this.id = id;
		this.ip = ip;

	}

	@Override
	public String toString() {
		return "SessionUser [id=" + id + ", ip=" + ip + ", system=" + system + ", browser=" + browser + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		String[] str = agent.split(" ");
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

}
