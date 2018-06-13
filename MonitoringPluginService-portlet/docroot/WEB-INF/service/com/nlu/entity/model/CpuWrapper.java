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
 * This class is a wrapper for {@link Cpu}.
 * </p>
 *
 * @author NgocBao
 * @see Cpu
 * @generated
 */
public class CpuWrapper implements Cpu, ModelWrapper<Cpu> {
	public CpuWrapper(Cpu cpu) {
		_cpu = cpu;
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

	/**
	* Returns the primary key of this cpu.
	*
	* @return the primary key of this cpu
	*/
	@Override
	public long getPrimaryKey() {
		return _cpu.getPrimaryKey();
	}

	/**
	* Sets the primary key of this cpu.
	*
	* @param primaryKey the primary key of this cpu
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_cpu.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the cpu ID of this cpu.
	*
	* @return the cpu ID of this cpu
	*/
	@Override
	public long getCpuId() {
		return _cpu.getCpuId();
	}

	/**
	* Sets the cpu ID of this cpu.
	*
	* @param cpuId the cpu ID of this cpu
	*/
	@Override
	public void setCpuId(long cpuId) {
		_cpu.setCpuId(cpuId);
	}

	/**
	* Returns the time of this cpu.
	*
	* @return the time of this cpu
	*/
	@Override
	public java.util.Date getTime() {
		return _cpu.getTime();
	}

	/**
	* Sets the time of this cpu.
	*
	* @param time the time of this cpu
	*/
	@Override
	public void setTime(java.util.Date time) {
		_cpu.setTime(time);
	}

	/**
	* Returns the value of this cpu.
	*
	* @return the value of this cpu
	*/
	@Override
	public double getValue() {
		return _cpu.getValue();
	}

	/**
	* Sets the value of this cpu.
	*
	* @param value the value of this cpu
	*/
	@Override
	public void setValue(double value) {
		_cpu.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _cpu.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_cpu.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _cpu.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_cpu.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _cpu.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _cpu.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_cpu.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _cpu.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_cpu.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_cpu.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_cpu.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CpuWrapper((Cpu)_cpu.clone());
	}

	@Override
	public int compareTo(com.nlu.entity.model.Cpu cpu) {
		return _cpu.compareTo(cpu);
	}

	@Override
	public int hashCode() {
		return _cpu.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.nlu.entity.model.Cpu> toCacheModel() {
		return _cpu.toCacheModel();
	}

	@Override
	public com.nlu.entity.model.Cpu toEscapedModel() {
		return new CpuWrapper(_cpu.toEscapedModel());
	}

	@Override
	public com.nlu.entity.model.Cpu toUnescapedModel() {
		return new CpuWrapper(_cpu.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _cpu.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _cpu.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_cpu.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CpuWrapper)) {
			return false;
		}

		CpuWrapper cpuWrapper = (CpuWrapper)obj;

		if (Validator.equals(_cpu, cpuWrapper._cpu)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Cpu getWrappedCpu() {
		return _cpu;
	}

	@Override
	public Cpu getWrappedModel() {
		return _cpu;
	}

	@Override
	public void resetOriginalValues() {
		_cpu.resetOriginalValues();
	}

	private Cpu _cpu;
}