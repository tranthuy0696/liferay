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

import com.nlu.entity.model.Heap;
import com.nlu.entity.model.HeapModel;
import com.nlu.entity.model.HeapSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Heap service. Represents a row in the &quot;Heap&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.nlu.entity.model.HeapModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link HeapImpl}.
 * </p>
 *
 * @author NgocBao
 * @see HeapImpl
 * @see com.nlu.entity.model.Heap
 * @see com.nlu.entity.model.HeapModel
 * @generated
 */
@JSON(strict = true)
public class HeapModelImpl extends BaseModelImpl<Heap> implements HeapModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a heap model instance should use the {@link com.nlu.entity.model.Heap} interface instead.
	 */
	public static final String TABLE_NAME = "Heap";
	public static final Object[][] TABLE_COLUMNS = {
			{ "heapId", Types.BIGINT },
			{ "time_", Types.TIMESTAMP },
			{ "value", Types.DOUBLE }
		};
	public static final String TABLE_SQL_CREATE = "create table Heap (heapId LONG not null primary key,time_ DATE null,value DOUBLE)";
	public static final String TABLE_SQL_DROP = "drop table Heap";
	public static final String ORDER_BY_JPQL = " ORDER BY heap.heapId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Heap.heapId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.nlu.entity.model.Heap"),
			false);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.nlu.entity.model.Heap"),
			false);
	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Heap toModel(HeapSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Heap model = new HeapImpl();

		model.setHeapId(soapModel.getHeapId());
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
	public static List<Heap> toModels(HeapSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Heap> models = new ArrayList<Heap>(soapModels.length);

		for (HeapSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.nlu.entity.model.Heap"));

	public HeapModelImpl() {
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
	public Class<?> getModelClass() {
		return Heap.class;
	}

	@Override
	public String getModelClassName() {
		return Heap.class.getName();
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

	@JSON
	@Override
	public long getHeapId() {
		return _heapId;
	}

	@Override
	public void setHeapId(long heapId) {
		_heapId = heapId;
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
			Heap.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Heap toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Heap)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		HeapImpl heapImpl = new HeapImpl();

		heapImpl.setHeapId(getHeapId());
		heapImpl.setTime(getTime());
		heapImpl.setValue(getValue());

		heapImpl.resetOriginalValues();

		return heapImpl;
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

		if (!(obj instanceof Heap)) {
			return false;
		}

		Heap heap = (Heap)obj;

		long primaryKey = heap.getPrimaryKey();

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
	public CacheModel<Heap> toCacheModel() {
		HeapCacheModel heapCacheModel = new HeapCacheModel();

		heapCacheModel.heapId = getHeapId();

		Date time = getTime();

		if (time != null) {
			heapCacheModel.time = time.getTime();
		}
		else {
			heapCacheModel.time = Long.MIN_VALUE;
		}

		heapCacheModel.value = getValue();

		return heapCacheModel;
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

	private static ClassLoader _classLoader = Heap.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Heap.class };
	private long _heapId;
	private Date _time;
	private double _value;
	private Heap _escapedModel;
}