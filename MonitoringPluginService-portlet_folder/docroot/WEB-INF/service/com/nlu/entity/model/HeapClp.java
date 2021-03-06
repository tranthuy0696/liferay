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
import com.nlu.entity.service.HeapLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NgocBao
 */
public class HeapClp extends BaseModelImpl<Heap> implements Heap {
	public HeapClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Heap.class;
	}

	@Override
	public String getModelClassName() {
		return Heap.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _heapId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setHeapId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _heapId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("heapId", getHeapId());
		attributes.put("time", getTime());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long heapId = (Long)attributes.get("heapId");

		if (heapId != null) {
			setHeapId(heapId);
		}

		Date time = (Date)attributes.get("time");

		if (time != null) {
			setTime(time);
		}

		Double value = (Double)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public long getHeapId() {
		return _heapId;
	}

	@Override
	public void setHeapId(long heapId) {
		_heapId = heapId;

		if (_heapRemoteModel != null) {
			try {
				Class<?> clazz = _heapRemoteModel.getClass();

				Method method = clazz.getMethod("setHeapId", long.class);

				method.invoke(_heapRemoteModel, heapId);
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

		if (_heapRemoteModel != null) {
			try {
				Class<?> clazz = _heapRemoteModel.getClass();

				Method method = clazz.getMethod("setTime", Date.class);

				method.invoke(_heapRemoteModel, time);
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

		if (_heapRemoteModel != null) {
			try {
				Class<?> clazz = _heapRemoteModel.getClass();

				Method method = clazz.getMethod("setValue", double.class);

				method.invoke(_heapRemoteModel, value);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getHeapRemoteModel() {
		return _heapRemoteModel;
	}

	public void setHeapRemoteModel(BaseModel<?> heapRemoteModel) {
		_heapRemoteModel = heapRemoteModel;
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

		Class<?> remoteModelClass = _heapRemoteModel.getClass();

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

		Object returnValue = method.invoke(_heapRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			HeapLocalServiceUtil.addHeap(this);
		}
		else {
			HeapLocalServiceUtil.updateHeap(this);
		}
	}

	@Override
	public Heap toEscapedModel() {
		return (Heap)ProxyUtil.newProxyInstance(Heap.class.getClassLoader(),
			new Class[] { Heap.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		HeapClp clone = new HeapClp();

		clone.setHeapId(getHeapId());
		clone.setTime(getTime());
		clone.setValue(getValue());

		return clone;
	}

	@Override
	public int compareTo(Heap heap) {
		int value = 0;

		if (getHeapId() < heap.getHeapId()) {
			value = -1;
		}
		else if (getHeapId() > heap.getHeapId()) {
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

		if (!(obj instanceof HeapClp)) {
			return false;
		}

		HeapClp heap = (HeapClp)obj;

		long primaryKey = heap.getPrimaryKey();

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

		sb.append("{heapId=");
		sb.append(getHeapId());
		sb.append(", time=");
		sb.append(getTime());
		sb.append(", value=");
		sb.append(getValue());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.nlu.entity.model.Heap");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>heapId</column-name><column-value><![CDATA[");
		sb.append(getHeapId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>time</column-name><column-value><![CDATA[");
		sb.append(getTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _heapId;
	private Date _time;
	private double _value;
	private BaseModel<?> _heapRemoteModel;
	private Class<?> _clpSerializerClass = com.nlu.entity.service.ClpSerializer.class;
}