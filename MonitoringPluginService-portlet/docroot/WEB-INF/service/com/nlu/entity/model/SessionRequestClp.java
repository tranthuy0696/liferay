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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.nlu.entity.service.ClpSerializer;
import com.nlu.entity.service.SessionRequestLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NgocBao
 */
public class SessionRequestClp extends BaseModelImpl<SessionRequest>
	implements SessionRequest {
	public SessionRequestClp() {
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
	public long getPrimaryKey() {
		return _sessionRequestId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSessionRequestId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _sessionRequestId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSessionRequestId() {
		return _sessionRequestId;
	}

	@Override
	public void setSessionRequestId(long sessionRequestId) {
		_sessionRequestId = sessionRequestId;

		if (_sessionRequestRemoteModel != null) {
			try {
				Class<?> clazz = _sessionRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setSessionRequestId",
						long.class);

				method.invoke(_sessionRequestRemoteModel, sessionRequestId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSessionId() {
		return _sessionId;
	}

	@Override
	public void setSessionId(String sessionId) {
		_sessionId = sessionId;

		if (_sessionRequestRemoteModel != null) {
			try {
				Class<?> clazz = _sessionRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setSessionId", String.class);

				method.invoke(_sessionRequestRemoteModel, sessionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getTime() {
		return _time;
	}

	@Override
	public void setTime(Date time) {
		_time = time;

		if (_sessionRequestRemoteModel != null) {
			try {
				Class<?> clazz = _sessionRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setTime", Date.class);

				method.invoke(_sessionRequestRemoteModel, time);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIp() {
		return _ip;
	}

	@Override
	public void setIp(String ip) {
		_ip = ip;

		if (_sessionRequestRemoteModel != null) {
			try {
				Class<?> clazz = _sessionRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setIp", String.class);

				method.invoke(_sessionRequestRemoteModel, ip);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBrowser() {
		return _browser;
	}

	@Override
	public void setBrowser(String browser) {
		_browser = browser;

		if (_sessionRequestRemoteModel != null) {
			try {
				Class<?> clazz = _sessionRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setBrowser", String.class);

				method.invoke(_sessionRequestRemoteModel, browser);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOs() {
		return _os;
	}

	@Override
	public void setOs(String os) {
		_os = os;

		if (_sessionRequestRemoteModel != null) {
			try {
				Class<?> clazz = _sessionRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setOs", String.class);

				method.invoke(_sessionRequestRemoteModel, os);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getLogin() {
		return _login;
	}

	@Override
	public boolean isLogin() {
		return _login;
	}

	@Override
	public void setLogin(boolean login) {
		_login = login;

		if (_sessionRequestRemoteModel != null) {
			try {
				Class<?> clazz = _sessionRequestRemoteModel.getClass();

				Method method = clazz.getMethod("setLogin", boolean.class);

				method.invoke(_sessionRequestRemoteModel, login);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSessionRequestRemoteModel() {
		return _sessionRequestRemoteModel;
	}

	public void setSessionRequestRemoteModel(
		BaseModel<?> sessionRequestRemoteModel) {
		_sessionRequestRemoteModel = sessionRequestRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _sessionRequestRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_sessionRequestRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SessionRequestLocalServiceUtil.addSessionRequest(this);
		}
		else {
			SessionRequestLocalServiceUtil.updateSessionRequest(this);
		}
	}

	@Override
	public SessionRequest toEscapedModel() {
		return (SessionRequest)ProxyUtil.newProxyInstance(SessionRequest.class.getClassLoader(),
			new Class[] { SessionRequest.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SessionRequestClp clone = new SessionRequestClp();

		clone.setSessionRequestId(getSessionRequestId());
		clone.setSessionId(getSessionId());
		clone.setTime(getTime());
		clone.setIp(getIp());
		clone.setBrowser(getBrowser());
		clone.setOs(getOs());
		clone.setLogin(getLogin());

		return clone;
	}

	@Override
	public int compareTo(SessionRequest sessionRequest) {
		int value = 0;

		if (getSessionRequestId() < sessionRequest.getSessionRequestId()) {
			value = -1;
		}
		else if (getSessionRequestId() > sessionRequest.getSessionRequestId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SessionRequestClp)) {
			return false;
		}

		SessionRequestClp sessionRequest = (SessionRequestClp)obj;

		long primaryKey = sessionRequest.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{sessionRequestId=");
		sb.append(getSessionRequestId());
		sb.append(", sessionId=");
		sb.append(getSessionId());
		sb.append(", time=");
		sb.append(getTime());
		sb.append(", ip=");
		sb.append(getIp());
		sb.append(", browser=");
		sb.append(getBrowser());
		sb.append(", os=");
		sb.append(getOs());
		sb.append(", login=");
		sb.append(getLogin());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("com.nlu.entity.model.SessionRequest");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>sessionRequestId</column-name><column-value><![CDATA[");
		sb.append(getSessionRequestId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sessionId</column-name><column-value><![CDATA[");
		sb.append(getSessionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>time</column-name><column-value><![CDATA[");
		sb.append(getTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ip</column-name><column-value><![CDATA[");
		sb.append(getIp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>browser</column-name><column-value><![CDATA[");
		sb.append(getBrowser());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>os</column-name><column-value><![CDATA[");
		sb.append(getOs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>login</column-name><column-value><![CDATA[");
		sb.append(getLogin());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _sessionRequestId;
	private String _sessionId;
	private Date _time;
	private String _ip;
	private String _browser;
	private String _os;
	private boolean _login;
	private BaseModel<?> _sessionRequestRemoteModel;
	private Class<?> _clpSerializerClass = com.nlu.entity.service.ClpSerializer.class;
}