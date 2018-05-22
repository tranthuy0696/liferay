package com.nlu.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.portlet.PortletSession;

public class GetApi {
	private static final String HOST_API = "http://localhost:8080/monitoring?format=json";
	private static final String POST = "POST";
	private static final String CONTENT_TYPE = "Content-Type";
	private static final String CONTENT_JSON = "application/json";
	private static final String COOKIE = "Cookie";
	private static final String SESSION_ID = "JSESSIONID=%s";
	public static String getApi(PortletSession session,String api) throws IOException{
		URL url = new URL(HOST_API.concat(api));
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod(POST);
		conn.setRequestProperty(CONTENT_TYPE, CONTENT_JSON);
		conn.setRequestProperty(COOKIE, String.format(SESSION_ID, session.getId()));
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		StringBuilder str = new StringBuilder();
		while ((output = br.readLine()) != null) {
			str.append(output);
		}
		conn.disconnect();
		return str.toString();
	}

}
