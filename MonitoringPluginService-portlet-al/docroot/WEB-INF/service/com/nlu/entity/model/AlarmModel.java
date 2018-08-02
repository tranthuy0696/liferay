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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Alarm service. Represents a row in the &quot;Alarm&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.nlu.entity.model.impl.AlarmModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.nlu.entity.model.impl.AlarmImpl}.
 * </p>
 *
 * @author NgocBao
 * @see Alarm
 * @see com.nlu.entity.model.impl.AlarmImpl
 * @see com.nlu.entity.model.impl.AlarmModelImpl
 * @generated
 */
public interface AlarmModel extends BaseModel<Alarm> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a alarm model instance should use the {@link Alarm} interface instead.
	 */

	/**
	 * Returns the primary key of this alarm.
	 *
	 * @return the primary key of this alarm
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this alarm.
	 *
	 * @param primaryKey the primary key of this alarm
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the alarm ID of this alarm.
	 *
	 * @return the alarm ID of this alarm
	 */
	public long getAlarmId();

	/**
	 * Sets the alarm ID of this alarm.
	 *
	 * @param alarmId the alarm ID of this alarm
	 */
	public void setAlarmId(long alarmId);

	/**
	 * Returns the name of this alarm.
	 *
	 * @return the name of this alarm
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this alarm.
	 *
	 * @param name the name of this alarm
	 */
	public void setName(String name);

	/**
	 * Returns the start time of this alarm.
	 *
	 * @return the start time of this alarm
	 */
	public int getStartTime();

	/**
	 * Sets the start time of this alarm.
	 *
	 * @param startTime the start time of this alarm
	 */
	public void setStartTime(int startTime);

	/**
	 * Returns the end time of this alarm.
	 *
	 * @return the end time of this alarm
	 */
	public int getEndTime();

	/**
	 * Sets the end time of this alarm.
	 *
	 * @param endTime the end time of this alarm
	 */
	public void setEndTime(int endTime);

	/**
	 * Returns the value of this alarm.
	 *
	 * @return the value of this alarm
	 */
	public double getValue();

	/**
	 * Sets the value of this alarm.
	 *
	 * @param value the value of this alarm
	 */
	public void setValue(double value);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.nlu.entity.model.Alarm alarm);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.nlu.entity.model.Alarm> toCacheModel();

	@Override
	public com.nlu.entity.model.Alarm toEscapedModel();

	@Override
	public com.nlu.entity.model.Alarm toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}