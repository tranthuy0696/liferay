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

package com.monitor.portlet.entity.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.monitor.portlet.entity.service.ClpSerializer;
import com.monitor.portlet.entity.service.CpuLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author thuthuy
 */
public class CpuClp extends BaseModelImpl<Cpu> implements Cpu {
	public CpuClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Cpu.class;
	}

	@Override
	public String getModelClassName() {
		return Cpu.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _cpuId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCpuId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cpuId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cpuId", getCpuId());
		attributes.put("time", getTime());
		attributes.put("min", getMin());
		attributes.put("max", getMax());
		attributes.put("aver", getAver());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cpuId = (Long)attributes.get("cpuId");

		if (cpuId != null) {
			setCpuId(cpuId);
		}

		Date time = (Date)attributes.get("time");

		if (time != null) {
			setTime(time);
		}

		Double min = (Double)attributes.get("min");

		if (min != null) {
			setMin(min);
		}

		Double max = (Double)attributes.get("max");

		if (max != null) {
			setMax(max);
		}

		Double aver = (Double)attributes.get("aver");

		if (aver != null) {
			setAver(aver);
		}
	}

	@Override
	public long getCpuId() {
		return _cpuId;
	}

	@Override
	public void setCpuId(long cpuId) {
		_cpuId = cpuId;

		if (_cpuRemoteModel != null) {
			try {
				Class<?> clazz = _cpuRemoteModel.getClass();

				Method method = clazz.getMethod("setCpuId", long.class);

				method.invoke(_cpuRemoteModel, cpuId);
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

		if (_cpuRemoteModel != null) {
			try {
				Class<?> clazz = _cpuRemoteModel.getClass();

				Method method = clazz.getMethod("setTime", Date.class);

				method.invoke(_cpuRemoteModel, time);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getMin() {
		return _min;
	}

	@Override
	public void setMin(double min) {
		_min = min;

		if (_cpuRemoteModel != null) {
			try {
				Class<?> clazz = _cpuRemoteModel.getClass();

				Method method = clazz.getMethod("setMin", double.class);

				method.invoke(_cpuRemoteModel, min);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getMax() {
		return _max;
	}

	@Override
	public void setMax(double max) {
		_max = max;

		if (_cpuRemoteModel != null) {
			try {
				Class<?> clazz = _cpuRemoteModel.getClass();

				Method method = clazz.getMethod("setMax", double.class);

				method.invoke(_cpuRemoteModel, max);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getAver() {
		return _aver;
	}

	@Override
	public void setAver(double aver) {
		_aver = aver;

		if (_cpuRemoteModel != null) {
			try {
				Class<?> clazz = _cpuRemoteModel.getClass();

				Method method = clazz.getMethod("setAver", double.class);

				method.invoke(_cpuRemoteModel, aver);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCpuRemoteModel() {
		return _cpuRemoteModel;
	}

	public void setCpuRemoteModel(BaseModel<?> cpuRemoteModel) {
		_cpuRemoteModel = cpuRemoteModel;
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

		Class<?> remoteModelClass = _cpuRemoteModel.getClass();

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

		Object returnValue = method.invoke(_cpuRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CpuLocalServiceUtil.addCpu(this);
		}
		else {
			CpuLocalServiceUtil.updateCpu(this);
		}
	}

	@Override
	public Cpu toEscapedModel() {
		return (Cpu)ProxyUtil.newProxyInstance(Cpu.class.getClassLoader(),
			new Class[] { Cpu.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CpuClp clone = new CpuClp();

		clone.setCpuId(getCpuId());
		clone.setTime(getTime());
		clone.setMin(getMin());
		clone.setMax(getMax());
		clone.setAver(getAver());

		return clone;
	}

	@Override
	public int compareTo(Cpu cpu) {
		int value = 0;

		if (getCpuId() < cpu.getCpuId()) {
			value = -1;
		}
		else if (getCpuId() > cpu.getCpuId()) {
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

		if (!(obj instanceof CpuClp)) {
			return false;
		}

		CpuClp cpu = (CpuClp)obj;

		long primaryKey = cpu.getPrimaryKey();

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

		sb.append("{cpuId=");
		sb.append(getCpuId());
		sb.append(", time=");
		sb.append(getTime());
		sb.append(", min=");
		sb.append(getMin());
		sb.append(", max=");
		sb.append(getMax());
		sb.append(", aver=");
		sb.append(getAver());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.monitor.portlet.entity.model.Cpu");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cpuId</column-name><column-value><![CDATA[");
		sb.append(getCpuId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>time</column-name><column-value><![CDATA[");
		sb.append(getTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>min</column-name><column-value><![CDATA[");
		sb.append(getMin());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>max</column-name><column-value><![CDATA[");
		sb.append(getMax());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>aver</column-name><column-value><![CDATA[");
		sb.append(getAver());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _cpuId;
	private Date _time;
	private double _min;
	private double _max;
	private double _aver;
	private BaseModel<?> _cpuRemoteModel;
	private Class<?> _clpSerializerClass = com.monitor.portlet.entity.service.ClpSerializer.class;
}