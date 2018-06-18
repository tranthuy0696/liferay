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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SessionRequest}.
 * </p>
 *
 * @author NgocBao
 * @see SessionRequest
 * @generated
 */
public class SessionRequestWrapper implements SessionRequest,
	ModelWrapper<SessionRequest> {
	public SessionRequestWrapper(SessionRequest sessionRequest) {
		_sessionRequest = sessionRequest;
	}

	@Override
	public Class<?> getModelClass() {
		return SessionRequest.class;
	}

	@Override
	public String getModelClassName() {
		return SessionRequest.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sessionRequestId", getSessionRequestId());
		attributes.put("sessionId", getSessionId());
		attributes.put("time", getTime());
		attributes.put("ip", getIp());
		attributes.put("browser", getBrowser());
		attributes.put("os", getOs());
		attributes.put("login", getLogin());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sessionRequestId = (Long)attributes.get("sessionRequestId");

		if (sessionRequestId != null) {
			setSessionRequestId(sessionRequestId);
		}

		String sessionId = (String)attributes.get("sessionId");

		if (sessionId != null) {
			setSessionId(sessionId);
		}

		Date time = (Date)attributes.get("time");

		if (time != null) {
			setTime(time);
		}

		String ip = (String)attributes.get("ip");

		if (ip != null) {
			setIp(ip);
		}

		String browser = (String)attributes.get("browser");

		if (browser != null) {
			setBrowser(browser);
		}

		String os = (String)attributes.get("os");

		if (os != null) {
			setOs(os);
		}

		Boolean login = (Boolean)attributes.get("login");

		if (login != null) {
			setLogin(login);
		}
	}

	/**
	* Returns the primary key of this session request.
	*
	* @return the primary key of this session request
	*/
	@Override
	public long getPrimaryKey() {
		return _sessionRequest.getPrimaryKey();
	}

	/**
	* Sets the primary key of this session request.
	*
	* @param primaryKey the primary key of this session request
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_sessionRequest.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the session request ID of this session request.
	*
	* @return the session request ID of this session request
	*/
	@Override
	public long getSessionRequestId() {
		return _sessionRequest.getSessionRequestId();
	}

	/**
	* Sets the session request ID of this session request.
	*
	* @param sessionRequestId the session request ID of this session request
	*/
	@Override
	public void setSessionRequestId(long sessionRequestId) {
		_sessionRequest.setSessionRequestId(sessionRequestId);
	}

	/**
	* Returns the session ID of this session request.
	*
	* @return the session ID of this session request
	*/
	@Override
	public java.lang.String getSessionId() {
		return _sessionRequest.getSessionId();
	}

	/**
	* Sets the session ID of this session request.
	*
	* @param sessionId the session ID of this session request
	*/
	@Override
	public void setSessionId(java.lang.String sessionId) {
		_sessionRequest.setSessionId(sessionId);
	}

	/**
	* Returns the time of this session request.
	*
	* @return the time of this session request
	*/
	@Override
	public java.util.Date getTime() {
		return _sessionRequest.getTime();
	}

	/**
	* Sets the time of this session request.
	*
	* @param time the time of this session request
	*/
	@Override
	public void setTime(java.util.Date time) {
		_sessionRequest.setTime(time);
	}

	/**
	* Returns the ip of this session request.
	*
	* @return the ip of this session request
	*/
	@Override
	public java.lang.String getIp() {
		return _sessionRequest.getIp();
	}

	/**
	* Sets the ip of this session request.
	*
	* @param ip the ip of this session request
	*/
	@Override
	public void setIp(java.lang.String ip) {
		_sessionRequest.setIp(ip);
	}

	/**
	* Returns the browser of this session request.
	*
	* @return the browser of this session request
	*/
	@Override
	public java.lang.String getBrowser() {
		return _sessionRequest.getBrowser();
	}

	/**
	* Sets the browser of this session request.
	*
	* @param browser the browser of this session request
	*/
	@Override
	public void setBrowser(java.lang.String browser) {
		_sessionRequest.setBrowser(browser);
	}

	/**
	* Returns the os of this session request.
	*
	* @return the os of this session request
	*/
	@Override
	public java.lang.String getOs() {
		return _sessionRequest.getOs();
	}

	/**
	* Sets the os of this session request.
	*
	* @param os the os of this session request
	*/
	@Override
	public void setOs(java.lang.String os) {
		_sessionRequest.setOs(os);
	}

	/**
	* Returns the login of this session request.
	*
	* @return the login of this session request
	*/
	@Override
	public boolean getLogin() {
		return _sessionRequest.getLogin();
	}

	/**
	* Returns <code>true</code> if this session request is login.
	*
	* @return <code>true</code> if this session request is login; <code>false</code> otherwise
	*/
	@Override
	public boolean isLogin() {
		return _sessionRequest.isLogin();
	}

	/**
	* Sets whether this session request is login.
	*
	* @param login the login of this session request
	*/
	@Override
	public void setLogin(boolean login) {
		_sessionRequest.setLogin(login);
	}

	@Override
	public boolean isNew() {
		return _sessionRequest.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_sessionRequest.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _sessionRequest.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_sessionRequest.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _sessionRequest.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _sessionRequest.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_sessionRequest.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _sessionRequest.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_sessionRequest.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_sessionRequest.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_sessionRequest.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SessionRequestWrapper((SessionRequest)_sessionRequest.clone());
	}

	@Override
	public int compareTo(com.nlu.entity.model.SessionRequest sessionRequest) {
		return _sessionRequest.compareTo(sessionRequest);
	}

	@Override
	public int hashCode() {
		return _sessionRequest.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.nlu.entity.model.SessionRequest> toCacheModel() {
		return _sessionRequest.toCacheModel();
	}

	@Override
	public com.nlu.entity.model.SessionRequest toEscapedModel() {
		return new SessionRequestWrapper(_sessionRequest.toEscapedModel());
	}

	@Override
	public com.nlu.entity.model.SessionRequest toUnescapedModel() {
		return new SessionRequestWrapper(_sessionRequest.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _sessionRequest.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _sessionRequest.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_sessionRequest.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SessionRequestWrapper)) {
			return false;
		}

		SessionRequestWrapper sessionRequestWrapper = (SessionRequestWrapper)obj;

		if (Validator.equals(_sessionRequest,
					sessionRequestWrapper._sessionRequest)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SessionRequest getWrappedSessionRequest() {
		return _sessionRequest;
	}

	@Override
	public SessionRequest getWrappedModel() {
		return _sessionRequest;
	}

	@Override
	public void resetOriginalValues() {
		_sessionRequest.resetOriginalValues();
	}

	private SessionRequest _sessionRequest;
}