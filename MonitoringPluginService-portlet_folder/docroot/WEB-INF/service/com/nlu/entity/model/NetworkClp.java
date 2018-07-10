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
import com.nlu.entity.service.NetworkLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author NgocBao
 */
public class NetworkClp extends BaseModelImpl<Network> implements Network {
	public NetworkClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Network.class;
	}

	@Override
	public String getModelClassName() {
		return Network.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _networkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNetworkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _networkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("networkId", getNetworkId());
		attributes.put("time", getTime());
		attributes.put("down", getDown());
		attributes.put("up", getUp());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long networkId = (Long)attributes.get("networkId");

		if (networkId != null) {
			setNetworkId(networkId);
		}

		Date time = (Date)attributes.get("time");

		if (time != null) {
			setTime(time);
		}

		Double down = (Double)attributes.get("down");

		if (down != null) {
			setDown(down);
		}

		Double up = (Double)attributes.get("up");

		if (up != null) {
			setUp(up);
		}
	}

	@Override
	public long getNetworkId() {
		return _networkId;
	}

	@Override
	public void setNetworkId(long networkId) {
		_networkId = networkId;

		if (_networkRemoteModel != null) {
			try {
				Class<?> clazz = _networkRemoteModel.getClass();

				Method method = clazz.getMethod("setNetworkId", long.class);

				method.invoke(_networkRemoteModel, networkId);
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

		if (_networkRemoteModel != null) {
			try {
				Class<?> clazz = _networkRemoteModel.getClass();

				Method method = clazz.getMethod("setTime", Date.class);

				method.invoke(_networkRemoteModel, time);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getDown() {
		return _down;
	}

	@Override
	public void setDown(double down) {
		_down = down;

		if (_networkRemoteModel != null) {
			try {
				Class<?> clazz = _networkRemoteModel.getClass();

				Method method = clazz.getMethod("setDown", double.class);

				method.invoke(_networkRemoteModel, down);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public double getUp() {
		return _up;
	}

	@Override
	public void setUp(double up) {
		_up = up;

		if (_networkRemoteModel != null) {
			try {
				Class<?> clazz = _networkRemoteModel.getClass();

				Method method = clazz.getMethod("setUp", double.class);

				method.invoke(_networkRemoteModel, up);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getNetworkRemoteModel() {
		return _networkRemoteModel;
	}

	public void setNetworkRemoteModel(BaseModel<?> networkRemoteModel) {
		_networkRemoteModel = networkRemoteModel;
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

		Class<?> remoteModelClass = _networkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_networkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			NetworkLocalServiceUtil.addNetwork(this);
		}
		else {
			NetworkLocalServiceUtil.updateNetwork(this);
		}
	}

	@Override
	public Network toEscapedModel() {
		return (Network)ProxyUtil.newProxyInstance(Network.class.getClassLoader(),
			new Class[] { Network.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		NetworkClp clone = new NetworkClp();

		clone.setNetworkId(getNetworkId());
		clone.setTime(getTime());
		clone.setDown(getDown());
		clone.setUp(getUp());

		return clone;
	}

	@Override
	public int compareTo(Network network) {
		int value = 0;

		if (getNetworkId() < network.getNetworkId()) {
			value = -1;
		}
		else if (getNetworkId() > network.getNetworkId()) {
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

		if (!(obj instanceof NetworkClp)) {
			return false;
		}

		NetworkClp network = (NetworkClp)obj;

		long primaryKey = network.getPrimaryKey();

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
		StringBundler sb = new StringBundler(9);

		sb.append("{networkId=");
		sb.append(getNetworkId());
		sb.append(", time=");
		sb.append(getTime());
		sb.append(", down=");
		sb.append(getDown());
		sb.append(", up=");
		sb.append(getUp());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.nlu.entity.model.Network");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>networkId</column-name><column-value><![CDATA[");
		sb.append(getNetworkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>time</column-name><column-value><![CDATA[");
		sb.append(getTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>down</column-name><column-value><![CDATA[");
		sb.append(getDown());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>up</column-name><column-value><![CDATA[");
		sb.append(getUp());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _networkId;
	private Date _time;
	private double _down;
	private double _up;
	private BaseModel<?> _networkRemoteModel;
	private Class<?> _clpSerializerClass = com.nlu.entity.service.ClpSerializer.class;
}