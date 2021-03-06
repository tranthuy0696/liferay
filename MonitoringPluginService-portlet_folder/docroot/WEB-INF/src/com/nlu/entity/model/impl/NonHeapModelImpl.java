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

import com.nlu.entity.model.NonHeap;
import com.nlu.entity.model.NonHeapModel;
import com.nlu.entity.model.NonHeapSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the NonHeap service. Represents a row in the &quot;NonHeap&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.nlu.entity.model.NonHeapModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link NonHeapImpl}.
 * </p>
 *
 * @author NgocBao
 * @see NonHeapImpl
 * @see com.nlu.entity.model.NonHeap
 * @see com.nlu.entity.model.NonHeapModel
 * @generated
 */
@JSON(strict = true)
public class NonHeapModelImpl extends BaseModelImpl<NonHeap>
	implements NonHeapModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a non heap model instance should use the {@link com.nlu.entity.model.NonHeap} interface instead.
	 */
	public static final String TABLE_NAME = "NonHeap";
	public static final Object[][] TABLE_COLUMNS = {
			{ "nonHeapId", Types.BIGINT },
			{ "time_", Types.TIMESTAMP },
			{ "value", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table NonHeap (nonHeapId LONG not null primary key,time_ DATE null,value DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table NonHeap";
	public static final String ORDER_BY_JPQL = " ORDER BY nonHeap.nonHeapId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY NonHeap.nonHeapId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.nlu.entity.model.NonHeap"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.nlu.entity.model.NonHeap"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static NonHeap toModel(NonHeapSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		NonHeap model = new NonHeapImpl();

		model.setNonHeapId(soapModel.getNonHeapId());
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
	public static List<NonHeap> toModels(NonHeapSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<NonHeap> models = new ArrayList<NonHeap>(soapModels.length);

		for (NonHeapSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.nlu.entity.model.NonHeap"));

	public NonHeapModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _nonHeapId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNonHeapId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _nonHeapId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return NonHeap.class;
	}

	@Override
	public String getModelClassName() {
		return NonHeap.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("nonHeapId", getNonHeapId());
		attributes.put("time", getTime());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long nonHeapId = (Long)attributes.get("nonHeapId");

		if (nonHeapId != null) {
			setNonHeapId(nonHeapId);
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
	public long getNonHeapId() {
		return _nonHeapId;
	}

	@Override
	public void setNonHeapId(long nonHeapId) {
		_nonHeapId = nonHeapId;
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
			NonHeap.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public NonHeap toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (NonHeap)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		NonHeapImpl nonHeapImpl = new NonHeapImpl();

		nonHeapImpl.setNonHeapId(getNonHeapId());
		nonHeapImpl.setTime(getTime());
		nonHeapImpl.setValue(getValue());

		nonHeapImpl.resetOriginalValues();

		return nonHeapImpl;
	}

	@Override
	public int compareTo(NonHeap nonHeap) {
		int value = 0;

		if (getNonHeapId() < nonHeap.getNonHeapId()) {
			value = -1;
		}
		else if (getNonHeapId() > nonHeap.getNonHeapId()) {
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

		if (!(obj instanceof NonHeap)) {
			return false;
		}

		NonHeap nonHeap = (NonHeap)obj;

		long primaryKey = nonHeap.getPrimaryKey();

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
	public CacheModel<NonHeap> toCacheModel() {
		NonHeapCacheModel nonHeapCacheModel = new NonHeapCacheModel();

		nonHeapCacheModel.nonHeapId = getNonHeapId();

		Date time = getTime();

		if (time != null) {
			nonHeapCacheModel.time = time.getTime();
		}
		else {
			nonHeapCacheModel.time = Long.MIN_VALUE;
		}

		nonHeapCacheModel.value = getValue();

		return nonHeapCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{nonHeapId=");
		sb.append(getNonHeapId());
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
		sb.append("com.nlu.entity.model.NonHeap");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>nonHeapId</column-name><column-value><![CDATA[");
		sb.append(getNonHeapId());
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

	private static ClassLoader _classLoader = NonHeap.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			NonHeap.class
		};
	private long _nonHeapId;
	private Date _time;
	private double _value;
	private NonHeap _escapedModel;
}