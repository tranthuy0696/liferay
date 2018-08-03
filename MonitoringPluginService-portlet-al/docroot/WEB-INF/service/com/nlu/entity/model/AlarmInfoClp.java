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

import com.nlu.entity.service.AlarmInfoLocalServiceUtil;
import com.nlu.entity.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NgocBao
 */
public class AlarmInfoClp extends BaseModelImpl<AlarmInfo> implements AlarmInfo {
	public AlarmInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return AlarmInfo.class;
	}

	@Override
	public String getModelClassName() {
		return AlarmInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _alarmInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAlarmInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _alarmInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("alarmInfoId", getAlarmInfoId());
		attributes.put("name", getName());
		attributes.put("mail", getMail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long alarmInfoId = (Long)attributes.get("alarmInfoId");

		if (alarmInfoId != null) {
			setAlarmInfoId(alarmInfoId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String mail = (String)attributes.get("mail");

		if (mail != null) {
			setMail(mail);
		}
	}

	@Override
	public long getAlarmInfoId() {
		return _alarmInfoId;
	}

	@Override
	public void setAlarmInfoId(long alarmInfoId) {
		_alarmInfoId = alarmInfoId;

		if (_alarmInfoRemoteModel != null) {
			try {
				Class<?> clazz = _alarmInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setAlarmInfoId", long.class);

				method.invoke(_alarmInfoRemoteModel, alarmInfoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_alarmInfoRemoteModel != null) {
			try {
				Class<?> clazz = _alarmInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_alarmInfoRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMail() {
		return _mail;
	}

	@Override
	public void setMail(String mail) {
		_mail = mail;

		if (_alarmInfoRemoteModel != null) {
			try {
				Class<?> clazz = _alarmInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setMail", String.class);

				method.invoke(_alarmInfoRemoteModel, mail);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAlarmInfoRemoteModel() {
		return _alarmInfoRemoteModel;
	}

	public void setAlarmInfoRemoteModel(BaseModel<?> alarmInfoRemoteModel) {
		_alarmInfoRemoteModel = alarmInfoRemoteModel;
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

		Class<?> remoteModelClass = _alarmInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_alarmInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AlarmInfoLocalServiceUtil.addAlarmInfo(this);
		}
		else {
			AlarmInfoLocalServiceUtil.updateAlarmInfo(this);
		}
	}

	@Override
	public AlarmInfo toEscapedModel() {
		return (AlarmInfo)ProxyUtil.newProxyInstance(AlarmInfo.class.getClassLoader(),
			new Class[] { AlarmInfo.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AlarmInfoClp clone = new AlarmInfoClp();

		clone.setAlarmInfoId(getAlarmInfoId());
		clone.setName(getName());
		clone.setMail(getMail());

		return clone;
	}

	@Override
	public int compareTo(AlarmInfo alarmInfo) {
		long primaryKey = alarmInfo.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AlarmInfoClp)) {
			return false;
		}

		AlarmInfoClp alarmInfo = (AlarmInfoClp)obj;

		long primaryKey = alarmInfo.getPrimaryKey();

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
		StringBundler sb = new StringBundler(7);

		sb.append("{alarmInfoId=");
		sb.append(getAlarmInfoId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", mail=");
		sb.append(getMail());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.nlu.entity.model.AlarmInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>alarmInfoId</column-name><column-value><![CDATA[");
		sb.append(getAlarmInfoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mail</column-name><column-value><![CDATA[");
		sb.append(getMail());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _alarmInfoId;
	private String _name;
	private String _mail;
	private BaseModel<?> _alarmInfoRemoteModel;
	private Class<?> _clpSerializerClass = com.nlu.entity.service.ClpSerializer.class;
}