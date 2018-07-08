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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Ram}.
 * </p>
 *
 * @author NgocBao
 * @see Ram
 * @generated
 */
public class RamWrapper implements Ram, ModelWrapper<Ram> {
	public RamWrapper(Ram ram) {
		_ram = ram;
	}

	@Override
	public Class<?> getModelClass() {
		return Ram.class;
	}

	@Override
	public String getModelClassName() {
		return Ram.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ramId", getRamId());
		attributes.put("time", getTime());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ramId = (Long)attributes.get("ramId");

		if (ramId != null) {
			setRamId(ramId);
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

	/**
	* Returns the primary key of this ram.
	*
	* @return the primary key of this ram
	*/
	@Override
	public long getPrimaryKey() {
		return _ram.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ram.
	*
	* @param primaryKey the primary key of this ram
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ram.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ram ID of this ram.
	*
	* @return the ram ID of this ram
	*/
	@Override
	public long getRamId() {
		return _ram.getRamId();
	}

	/**
	* Sets the ram ID of this ram.
	*
	* @param ramId the ram ID of this ram
	*/
	@Override
	public void setRamId(long ramId) {
		_ram.setRamId(ramId);
	}

	/**
	* Returns the time of this ram.
	*
	* @return the time of this ram
	*/
	@Override
	public java.util.Date getTime() {
		return _ram.getTime();
	}

	/**
	* Sets the time of this ram.
	*
	* @param time the time of this ram
	*/
	@Override
	public void setTime(java.util.Date time) {
		_ram.setTime(time);
	}

	/**
	* Returns the value of this ram.
	*
	* @return the value of this ram
	*/
	@Override
	public double getValue() {
		return _ram.getValue();
	}

	/**
	* Sets the value of this ram.
	*
	* @param value the value of this ram
	*/
	@Override
	public void setValue(double value) {
		_ram.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _ram.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ram.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ram.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ram.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ram.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ram.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ram.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ram.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ram.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ram.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ram.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RamWrapper((Ram)_ram.clone());
	}

	@Override
	public int compareTo(com.nlu.entity.model.Ram ram) {
		return _ram.compareTo(ram);
	}

	@Override
	public int hashCode() {
		return _ram.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.nlu.entity.model.Ram> toCacheModel() {
		return _ram.toCacheModel();
	}

	@Override
	public com.nlu.entity.model.Ram toEscapedModel() {
		return new RamWrapper(_ram.toEscapedModel());
	}

	@Override
	public com.nlu.entity.model.Ram toUnescapedModel() {
		return new RamWrapper(_ram.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ram.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ram.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ram.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RamWrapper)) {
			return false;
		}

		RamWrapper ramWrapper = (RamWrapper)obj;

		if (Validator.equals(_ram, ramWrapper._ram)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Ram getWrappedRam() {
		return _ram;
	}

	@Override
	public Ram getWrappedModel() {
		return _ram;
	}

	@Override
	public void resetOriginalValues() {
		_ram.resetOriginalValues();
	}

	private Ram _ram;
}