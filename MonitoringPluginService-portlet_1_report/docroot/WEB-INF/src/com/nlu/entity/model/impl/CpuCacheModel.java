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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.nlu.entity.model.Cpu;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Cpu in entity cache.
 *
 * @author NgocBao
 * @see Cpu
 * @generated
 */
public class CpuCacheModel implements CacheModel<Cpu>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{cpuId=");
		sb.append(cpuId);
		sb.append(", time=");
		sb.append(time);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Cpu toEntityModel() {
		CpuImpl cpuImpl = new CpuImpl();

		cpuImpl.setCpuId(cpuId);

		if (time == Long.MIN_VALUE) {
			cpuImpl.setTime(null);
		}
		else {
			cpuImpl.setTime(new Date(time));
		}

		cpuImpl.setValue(value);

		cpuImpl.resetOriginalValues();

		return cpuImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cpuId = objectInput.readLong();
		time = objectInput.readLong();
		value = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cpuId);
		objectOutput.writeLong(time);
		objectOutput.writeDouble(value);
	}

	public long cpuId;
	public long time;
	public double value;
}