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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Alarm}.
 * </p>
 *
 * @author NgocBao
 * @see Alarm
 * @generated
 */
public class AlarmWrapper implements Alarm, ModelWrapper<Alarm> {
	public AlarmWrapper(Alarm alarm) {
		_alarm = alarm;
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

	/**
	* Returns the primary key of this alarm.
	*
	* @return the primary key of this alarm
	*/
	@Override
	public long getPrimaryKey() {
		return _alarm.getPrimaryKey();
	}

	/**
	* Sets the primary key of this alarm.
	*
	* @param primaryKey the primary key of this alarm
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_alarm.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the alarm ID of this alarm.
	*
	* @return the alarm ID of this alarm
	*/
	@Override
	public long getAlarmId() {
		return _alarm.getAlarmId();
	}

	/**
	* Sets the alarm ID of this alarm.
	*
	* @param alarmId the alarm ID of this alarm
	*/
	@Override
	public void setAlarmId(long alarmId) {
		_alarm.setAlarmId(alarmId);
	}

	/**
	* Returns the name of this alarm.
	*
	* @return the name of this alarm
	*/
	@Override
	public java.lang.String getName() {
		return _alarm.getName();
	}

	/**
	* Sets the name of this alarm.
	*
	* @param name the name of this alarm
	*/
	@Override
	public void setName(java.lang.String name) {
		_alarm.setName(name);
	}

	/**
	* Returns the start time of this alarm.
	*
	* @return the start time of this alarm
	*/
	@Override
	public int getStartTime() {
		return _alarm.getStartTime();
	}

	/**
	* Sets the start time of this alarm.
	*
	* @param startTime the start time of this alarm
	*/
	@Override
	public void setStartTime(int startTime) {
		_alarm.setStartTime(startTime);
	}

	/**
	* Returns the end time of this alarm.
	*
	* @return the end time of this alarm
	*/
	@Override
	public int getEndTime() {
		return _alarm.getEndTime();
	}

	/**
	* Sets the end time of this alarm.
	*
	* @param endTime the end time of this alarm
	*/
	@Override
	public void setEndTime(int endTime) {
		_alarm.setEndTime(endTime);
	}

	/**
	* Returns the value of this alarm.
	*
	* @return the value of this alarm
	*/
	@Override
	public double getValue() {
		return _alarm.getValue();
	}

	/**
	* Sets the value of this alarm.
	*
	* @param value the value of this alarm
	*/
	@Override
	public void setValue(double value) {
		_alarm.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _alarm.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_alarm.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _alarm.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_alarm.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _alarm.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _alarm.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_alarm.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _alarm.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_alarm.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_alarm.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_alarm.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AlarmWrapper((Alarm)_alarm.clone());
	}

	@Override
	public int compareTo(com.nlu.entity.model.Alarm alarm) {
		return _alarm.compareTo(alarm);
	}

	@Override
	public int hashCode() {
		return _alarm.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.nlu.entity.model.Alarm> toCacheModel() {
		return _alarm.toCacheModel();
	}

	@Override
	public com.nlu.entity.model.Alarm toEscapedModel() {
		return new AlarmWrapper(_alarm.toEscapedModel());
	}

	@Override
	public com.nlu.entity.model.Alarm toUnescapedModel() {
		return new AlarmWrapper(_alarm.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _alarm.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _alarm.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_alarm.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AlarmWrapper)) {
			return false;
		}

		AlarmWrapper alarmWrapper = (AlarmWrapper)obj;

		if (Validator.equals(_alarm, alarmWrapper._alarm)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Alarm getWrappedAlarm() {
		return _alarm;
	}

	@Override
	public Alarm getWrappedModel() {
		return _alarm;
	}

	@Override
	public void resetOriginalValues() {
		_alarm.resetOriginalValues();
	}

	private Alarm _alarm;
}