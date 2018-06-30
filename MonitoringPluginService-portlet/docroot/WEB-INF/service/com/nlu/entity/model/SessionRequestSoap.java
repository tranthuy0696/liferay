/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.nlu.entity.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.nlu.entity.service.http.SessionRequestServiceSoap}.
 *
 * @author NgocBao
 * @see com.nlu.entity.service.http.SessionRequestServiceSoap
 * @generated
 */
public class SessionRequestSoap implements Serializable {
	public static SessionRequestSoap toSoapModel(SessionRequest model) {
		SessionRequestSoap soapModel = new SessionRequestSoap();

		soapModel.setSessionRequestId(model.getSessionRequestId());
		soapModel.setSessionId(model.getSessionId());
		soapModel.setTime(model.getTime());
		soapModel.setIp(model.getIp());
		soapModel.setBrowser(model.getBrowser());
		soapModel.setOs(model.getOs());
		soapModel.setLogin(model.getLogin());

		return soapModel;
	}

	public static SessionRequestSoap[] toSoapModels(SessionRequest[] models) {
		SessionRequestSoap[] soapModels = new SessionRequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SessionRequestSoap[][] toSoapModels(SessionRequest[][] models) {
		SessionRequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SessionRequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SessionRequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SessionRequestSoap[] toSoapModels(List<SessionRequest> models) {
		List<SessionRequestSoap> soapModels = new ArrayList<SessionRequestSoap>(models.size());

		for (SessionRequest model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SessionRequestSoap[soapModels.size()]);
	}

	public SessionRequestSoap() {
	}

	public long getPrimaryKey() {
		return _sessionRequestId;
	}

	public void setPrimaryKey(long pk) {
		setSessionRequestId(pk);
	}

	public long getSessionRequestId() {
		return _sessionRequestId;
	}

	public void setSessionRequestId(long sessionRequestId) {
		_sessionRequestId = sessionRequestId;
	}

	public String getSessionId() {
		return _sessionId;
	}

	public void setSessionId(String sessionId) {
		_sessionId = sessionId;
	}

	public Date getTime() {
		return _time;
	}

	public void setTime(Date time) {
		_time = time;
	}

	public String getIp() {
		return _ip;
	}

	public void setIp(String ip) {
		_ip = ip;
	}

	public String getBrowser() {
		return _browser;
	}

	public void setBrowser(String browser) {
		_browser = browser;
	}

	public String getOs() {
		return _os;
	}

	public void setOs(String os) {
		_os = os;
	}

	public boolean getLogin() {
		return _login;
	}

	public boolean isLogin() {
		return _login;
	}

	public void setLogin(boolean login) {
		_login = login;
	}

	private long _sessionRequestId;
	private String _sessionId;
	private Date _time;
	private String _ip;
	private String _browser;
	private String _os;
	private boolean _login;
}