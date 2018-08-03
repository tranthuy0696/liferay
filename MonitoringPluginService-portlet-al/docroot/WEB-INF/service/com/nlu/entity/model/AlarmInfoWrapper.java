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
 * This class is a wrapper for {@link AlarmInfo}.
 * </p>
 *
 * @author NgocBao
 * @see AlarmInfo
 * @generated
 */
public class AlarmInfoWrapper implements AlarmInfo, ModelWrapper<AlarmInfo> {
	public AlarmInfoWrapper(AlarmInfo alarmInfo) {
		_alarmInfo = alarmInfo;
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

	/**
	* Returns the primary key of this alarm info.
	*
	* @return the primary key of this alarm info
	*/
	@Override
	public long getPrimaryKey() {
		return _alarmInfo.getPrimaryKey();
	}

	/**
	* Sets the primary key of this alarm info.
	*
	* @param primaryKey the primary key of this alarm info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_alarmInfo.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the alarm info ID of this alarm info.
	*
	* @return the alarm info ID of this alarm info
	*/
	@Override
	public long getAlarmInfoId() {
		return _alarmInfo.getAlarmInfoId();
	}

	/**
	* Sets the alarm info ID of this alarm info.
	*
	* @param alarmInfoId the alarm info ID of this alarm info
	*/
	@Override
	public void setAlarmInfoId(long alarmInfoId) {
		_alarmInfo.setAlarmInfoId(alarmInfoId);
	}

	/**
	* Returns the name of this alarm info.
	*
	* @return the name of this alarm info
	*/
	@Override
	public java.lang.String getName() {
		return _alarmInfo.getName();
	}

	/**
	* Sets the name of this alarm info.
	*
	* @param name the name of this alarm info
	*/
	@Override
	public void setName(java.lang.String name) {
		_alarmInfo.setName(name);
	}

	/**
	* Returns the mail of this alarm info.
	*
	* @return the mail of this alarm info
	*/
	@Override
	public java.lang.String getMail() {
		return _alarmInfo.getMail();
	}

	/**
	* Sets the mail of this alarm info.
	*
	* @param mail the mail of this alarm info
	*/
	@Override
	public void setMail(java.lang.String mail) {
		_alarmInfo.setMail(mail);
	}

	@Override
	public boolean isNew() {
		return _alarmInfo.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_alarmInfo.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _alarmInfo.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_alarmInfo.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _alarmInfo.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _alarmInfo.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_alarmInfo.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _alarmInfo.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_alarmInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_alarmInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_alarmInfo.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AlarmInfoWrapper((AlarmInfo)_alarmInfo.clone());
	}

	@Override
	public int compareTo(com.nlu.entity.model.AlarmInfo alarmInfo) {
		return _alarmInfo.compareTo(alarmInfo);
	}

	@Override
	public int hashCode() {
		return _alarmInfo.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.nlu.entity.model.AlarmInfo> toCacheModel() {
		return _alarmInfo.toCacheModel();
	}

	@Override
	public com.nlu.entity.model.AlarmInfo toEscapedModel() {
		return new AlarmInfoWrapper(_alarmInfo.toEscapedModel());
	}

	@Override
	public com.nlu.entity.model.AlarmInfo toUnescapedModel() {
		return new AlarmInfoWrapper(_alarmInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _alarmInfo.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _alarmInfo.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_alarmInfo.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AlarmInfoWrapper)) {
			return false;
		}

		AlarmInfoWrapper alarmInfoWrapper = (AlarmInfoWrapper)obj;

		if (Validator.equals(_alarmInfo, alarmInfoWrapper._alarmInfo)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AlarmInfo getWrappedAlarmInfo() {
		return _alarmInfo;
	}

	@Override
	public AlarmInfo getWrappedModel() {
		return _alarmInfo;
	}

	@Override
	public void resetOriginalValues() {
		_alarmInfo.resetOriginalValues();
	}

	private AlarmInfo _alarmInfo;
}