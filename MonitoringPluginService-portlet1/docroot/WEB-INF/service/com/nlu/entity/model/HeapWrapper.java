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
 * This class is a wrapper for {@link Heap}.
 * </p>
 *
 * @author NgocBao
 * @see Heap
 * @generated
 */
public class HeapWrapper implements Heap, ModelWrapper<Heap> {
	public HeapWrapper(Heap heap) {
		_heap = heap;
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

	/**
	* Returns the primary key of this heap.
	*
	* @return the primary key of this heap
	*/
	@Override
	public long getPrimaryKey() {
		return _heap.getPrimaryKey();
	}

	/**
	* Sets the primary key of this heap.
	*
	* @param primaryKey the primary key of this heap
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_heap.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the heap ID of this heap.
	*
	* @return the heap ID of this heap
	*/
	@Override
	public long getHeapId() {
		return _heap.getHeapId();
	}

	/**
	* Sets the heap ID of this heap.
	*
	* @param heapId the heap ID of this heap
	*/
	@Override
	public void setHeapId(long heapId) {
		_heap.setHeapId(heapId);
	}

	/**
	* Returns the time of this heap.
	*
	* @return the time of this heap
	*/
	@Override
	public java.util.Date getTime() {
		return _heap.getTime();
	}

	/**
	* Sets the time of this heap.
	*
	* @param time the time of this heap
	*/
	@Override
	public void setTime(java.util.Date time) {
		_heap.setTime(time);
	}

	/**
	* Returns the value of this heap.
	*
	* @return the value of this heap
	*/
	@Override
	public double getValue() {
		return _heap.getValue();
	}

	/**
	* Sets the value of this heap.
	*
	* @param value the value of this heap
	*/
	@Override
	public void setValue(double value) {
		_heap.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _heap.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_heap.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _heap.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_heap.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _heap.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _heap.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_heap.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _heap.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_heap.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_heap.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_heap.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new HeapWrapper((Heap)_heap.clone());
	}

	@Override
	public int compareTo(com.nlu.entity.model.Heap heap) {
		return _heap.compareTo(heap);
	}

	@Override
	public int hashCode() {
		return _heap.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.nlu.entity.model.Heap> toCacheModel() {
		return _heap.toCacheModel();
	}

	@Override
	public com.nlu.entity.model.Heap toEscapedModel() {
		return new HeapWrapper(_heap.toEscapedModel());
	}

	@Override
	public com.nlu.entity.model.Heap toUnescapedModel() {
		return new HeapWrapper(_heap.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _heap.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _heap.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_heap.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof HeapWrapper)) {
			return false;
		}

		HeapWrapper heapWrapper = (HeapWrapper)obj;

		if (Validator.equals(_heap, heapWrapper._heap)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Heap getWrappedHeap() {
		return _heap;
	}

	@Override
	public Heap getWrappedModel() {
		return _heap;
	}

	@Override
	public void resetOriginalValues() {
		_heap.resetOriginalValues();
	}

	private Heap _heap;
}