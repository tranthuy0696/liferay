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

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Cpu service. Represents a row in the &quot;Cpu&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.nlu.entity.model.impl.CpuModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.nlu.entity.model.impl.CpuImpl}.
 * </p>
 *
 * @author NgocBao
 * @see Cpu
 * @see com.nlu.entity.model.impl.CpuImpl
 * @see com.nlu.entity.model.impl.CpuModelImpl
 * @generated
 */
public interface CpuModel extends BaseModel<Cpu> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cpu model instance should use the {@link Cpu} interface instead.
	 */

	/**
	 * Returns the primary key of this cpu.
	 *
	 * @return the primary key of this cpu
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cpu.
	 *
	 * @param primaryKey the primary key of this cpu
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the cpu ID of this cpu.
	 *
	 * @return the cpu ID of this cpu
	 */
	public long getCpuId();

	/**
	 * Sets the cpu ID of this cpu.
	 *
	 * @param cpuId the cpu ID of this cpu
	 */
	public void setCpuId(long cpuId);

	/**
	 * Returns the time of this cpu.
	 *
	 * @return the time of this cpu
	 */
	public Date getTime();

	/**
	 * Sets the time of this cpu.
	 *
	 * @param time the time of this cpu
	 */
	public void setTime(Date time);

	/**
	 * Returns the value of this cpu.
	 *
	 * @return the value of this cpu
	 */
	public double getValue();

	/**
	 * Sets the value of this cpu.
	 *
	 * @param value the value of this cpu
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
	public int compareTo(com.nlu.entity.model.Cpu cpu);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.nlu.entity.model.Cpu> toCacheModel();

	@Override
	public com.nlu.entity.model.Cpu toEscapedModel();

	@Override
	public com.nlu.entity.model.Cpu toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}