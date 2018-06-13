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
 * This class is a wrapper for {@link NonHeap}.
 * </p>
 *
 * @author NgocBao
 * @see NonHeap
 * @generated
 */
public class NonHeapWrapper implements NonHeap, ModelWrapper<NonHeap> {
	public NonHeapWrapper(NonHeap nonHeap) {
		_nonHeap = nonHeap;
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

	/**
	* Returns the primary key of this non heap.
	*
	* @return the primary key of this non heap
	*/
	@Override
	public long getPrimaryKey() {
		return _nonHeap.getPrimaryKey();
	}

	/**
	* Sets the primary key of this non heap.
	*
	* @param primaryKey the primary key of this non heap
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_nonHeap.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the non heap ID of this non heap.
	*
	* @return the non heap ID of this non heap
	*/
	@Override
	public long getNonHeapId() {
		return _nonHeap.getNonHeapId();
	}

	/**
	* Sets the non heap ID of this non heap.
	*
	* @param nonHeapId the non heap ID of this non heap
	*/
	@Override
	public void setNonHeapId(long nonHeapId) {
		_nonHeap.setNonHeapId(nonHeapId);
	}

	/**
	* Returns the time of this non heap.
	*
	* @return the time of this non heap
	*/
	@Override
	public java.util.Date getTime() {
		return _nonHeap.getTime();
	}

	/**
	* Sets the time of this non heap.
	*
	* @param time the time of this non heap
	*/
	@Override
	public void setTime(java.util.Date time) {
		_nonHeap.setTime(time);
	}

	/**
	* Returns the value of this non heap.
	*
	* @return the value of this non heap
	*/
	@Override
	public double getValue() {
		return _nonHeap.getValue();
	}

	/**
	* Sets the value of this non heap.
	*
	* @param value the value of this non heap
	*/
	@Override
	public void setValue(double value) {
		_nonHeap.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _nonHeap.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_nonHeap.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _nonHeap.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_nonHeap.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _nonHeap.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _nonHeap.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_nonHeap.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _nonHeap.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_nonHeap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_nonHeap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_nonHeap.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new NonHeapWrapper((NonHeap)_nonHeap.clone());
	}

	@Override
	public int compareTo(com.nlu.entity.model.NonHeap nonHeap) {
		return _nonHeap.compareTo(nonHeap);
	}

	@Override
	public int hashCode() {
		return _nonHeap.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.nlu.entity.model.NonHeap> toCacheModel() {
		return _nonHeap.toCacheModel();
	}

	@Override
	public com.nlu.entity.model.NonHeap toEscapedModel() {
		return new NonHeapWrapper(_nonHeap.toEscapedModel());
	}

	@Override
	public com.nlu.entity.model.NonHeap toUnescapedModel() {
		return new NonHeapWrapper(_nonHeap.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _nonHeap.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _nonHeap.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_nonHeap.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof NonHeapWrapper)) {
			return false;
		}

		NonHeapWrapper nonHeapWrapper = (NonHeapWrapper)obj;

		if (Validator.equals(_nonHeap, nonHeapWrapper._nonHeap)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public NonHeap getWrappedNonHeap() {
		return _nonHeap;
	}

	@Override
	public NonHeap getWrappedModel() {
		return _nonHeap;
	}

	@Override
	public void resetOriginalValues() {
		_nonHeap.resetOriginalValues();
	}

	private NonHeap _nonHeap;
}