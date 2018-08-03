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

import com.nlu.entity.service.AlarmLocalServiceUtil;
import com.nlu.entity.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NgocBao
 */
public class AlarmClp extends BaseModelImpl<Alarm> implements Alarm {
	public AlarmClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Alarm.class;
	}

	@Override
	public String getModelClassName() {
		return Alarm.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _alarmId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAlarmId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _alarmId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("alarmId", getAlarmId());
		attributes.put("name", getName());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long alarmId = (Long)attributes.get("alarmId");

		if (alarmId != null) {
			setAlarmId(alarmId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer startTime = (Integer)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Integer endTime = (Integer)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Double value = (Double)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public long getAlarmId() {
		return _alarmId;
	}

	@Override
	public void setAlarmId(long alarmId) {
		_alarmId = alarmId;

		if (_alarmRemoteModel != null) {
			try {
				Class<?> clazz = _alarmRemoteModel.getClass();

				Method method = clazz.getMethod("setAlarmId", long.class);

				method.invoke(_alarmRemoteModel, alarmId);
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

		if (_alarmRemoteModel != null) {
			try {
				Class<?> clazz = _alarmRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_alarmRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(int startTime) {
		_startTime = startTime;

		if (_alarmRemoteModel != null) {
			try {
				Class<?> clazz = _alarmRemoteModel.getClass();

				Method method = clazz.getMethod("setStartTime", int.class);

				method.invoke(_alarmRemoteModel, startTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getEndTime() {
		return _endTime;
	}

	@Override
	public void setEndTime(int endTime) {
		_endTime = endTime;

		if (_alarmRemoteModel != null) {
			try {
				Class<?> clazz = _alarmRemoteModel.getClass();

				Method method = clazz.getMethod("setEndTime", int.class);

				method.invoke(_alarmRemoteModel, endTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getValue() {
		return _value;
	}

	@Override
	public void setValue(double value) {
		_value = value;

		if (_alarmRemoteModel != null) {
			try {
				Class<?> clazz = _alarmRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", double.class);

				method.invoke(_alarmRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getAlarmRemoteModel() {
		return _alarmRemoteModel;
	}

	public void setAlarmRemoteModel(BaseModel<?> alarmRemoteModel) {
		_alarmRemoteModel = alarmRemoteModel;
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

		Class<?> remoteModelClass = _alarmRemoteModel.getClass();

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

		Object returnValue = method.invoke(_alarmRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			AlarmLocalServiceUtil.addAlarm(this);
		}
		else {
			AlarmLocalServiceUtil.updateAlarm(this);
		}
	}

	@Override
	public Alarm toEscapedModel() {
		return (Alarm)ProxyUtil.newProxyInstance(Alarm.class.getClassLoader(),
			new Class[] { Alarm.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		AlarmClp clone = new AlarmClp();

		clone.setAlarmId(getAlarmId());
		clone.setName(getName());
		clone.setStartTime(getStartTime());
		clone.setEndTime(getEndTime());
		clone.setValue(getValue());

		return clone;
	}

	@Override
	public int compareTo(Alarm alarm) {
		long primaryKey = alarm.getPrimaryKey();

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

		if (!(obj instanceof AlarmClp)) {
			return false;
		}

		AlarmClp alarm = (AlarmClp)obj;

		long primaryKey = alarm.getPrimaryKey();

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
		StringBundler sb = new StringBundler(11);

		sb.append("{alarmId=");
		sb.append(getAlarmId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", endTime=");
		sb.append(getEndTime());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.nlu.entity.model.Alarm");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>alarmId</column-name><column-value><![CDATA[");
		sb.append(getAlarmId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endTime</column-name><column-value><![CDATA[");
		sb.append(getEndTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _alarmId;
	private String _name;
	private int _startTime;
	private int _endTime;
	private double _value;
	private BaseModel<?> _alarmRemoteModel;
	private Class<?> _clpSerializerClass = com.nlu.entity.service.ClpSerializer.class;
}