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

package com.nlu.entity.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.nlu.entity.model.Cpu;
import com.nlu.entity.model.CpuModel;
import com.nlu.entity.model.CpuSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Cpu service. Represents a row in the &quot;Cpu&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.nlu.entity.model.CpuModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CpuImpl}.
 * </p>
 *
 * @author NgocBao
 * @see CpuImpl
 * @see com.nlu.entity.model.Cpu
 * @see com.nlu.entity.model.CpuModel
 * @generated
 */
@JSON(strict = true)
public class CpuModelImpl extends BaseModelImpl<Cpu> implements CpuModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a cpu model instance should use the {@link com.nlu.entity.model.Cpu} interface instead.
	 */
	public static final String TABLE_NAME = "Cpu";
	public static final Object[][] TABLE_COLUMNS = {
			{ "cpuId", Types.BIGINT },
			{ "time_", Types.TIMESTAMP },
			{ "value", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table Cpu (cpuId LONG not null primary key,time_ DATE null,value DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table Cpu";
	public static final String ORDER_BY_JPQL = " ORDER BY cpu.cpuId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Cpu.cpuId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.nlu.entity.model.Cpu"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.nlu.entity.model.Cpu"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Cpu toModel(CpuSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Cpu model = new CpuImpl();

		model.setCpuId(soapModel.getCpuId());
		model.setTime(soapModel.getTime());
		model.setValue(soapModel.getValue());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Cpu> toModels(CpuSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Cpu> models = new ArrayList<Cpu>(soapModels.length);

		for (CpuSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.nlu.entity.model.Cpu"));

	public CpuModelImpl() {
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
	public Class<?> getModelClass() {
		return Cpu.class;
	}

	@Override
	public String getModelClassName() {
		return Cpu.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cpuId", getCpuId());
		attributes.put("time", getTime());
		attributes.put("value", getValue());

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

		Double value = (Double)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@JSON
	@Override
	public long getCpuId() {
		return _cpuId;
	}

	@Override
	public void setCpuId(long cpuId) {
		_cpuId = cpuId;
	}

	@JSON
	@Override
	public Date getTime() {
		return _time;
	}

	@Override
	public void setTime(Date time) {
		_time = time;
	}

	@JSON
	@Override
	public double getValue() {
		return _value;
	}

	@Override
	public void setValue(double value) {
		_value = value;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Cpu.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Cpu toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Cpu)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CpuImpl cpuImpl = new CpuImpl();

		cpuImpl.setCpuId(getCpuId());
		cpuImpl.setTime(getTime());
		cpuImpl.setValue(getValue());

		cpuImpl.resetOriginalValues();

		return cpuImpl;
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

		if (!(obj instanceof Cpu)) {
			return false;
		}

		Cpu cpu = (Cpu)obj;

		long primaryKey = cpu.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<Cpu> toCacheModel() {
		CpuCacheModel cpuCacheModel = new CpuCacheModel();

		cpuCacheModel.cpuId = getCpuId();

		Date time = getTime();

		if (time != null) {
			cpuCacheModel.time = time.getTime();
		}
		else {
			cpuCacheModel.time = Long.MIN_VALUE;
		}

		cpuCacheModel.value = getValue();

		return cpuCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{cpuId=");
		sb.append(getCpuId());
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
		sb.append("com.nlu.entity.model.Cpu");
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
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Cpu.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Cpu.class };
	private long _cpuId;
	private Date _time;
	private double _value;
	private Cpu _escapedModel;
}