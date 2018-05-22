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
		StringBundler sb = new StringBundler(11);

		sb.append("{cpuId=");
		sb.append(cpuId);
		sb.append(", time=");
		sb.append(time);
		sb.append(", min=");
		sb.append(min);
		sb.append(", max=");
		sb.append(max);
		sb.append(", aver=");
		sb.append(aver);
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

		cpuImpl.setMin(min);
		cpuImpl.setMax(max);
		cpuImpl.setAver(aver);

		cpuImpl.resetOriginalValues();

		return cpuImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cpuId = objectInput.readLong();
		time = objectInput.readLong();
		min = objectInput.readDouble();
		max = objectInput.readDouble();
		aver = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cpuId);
		objectOutput.writeLong(time);
		objectOutput.writeDouble(min);
		objectOutput.writeDouble(max);
		objectOutput.writeDouble(aver);
	}

	public long cpuId;
	public long time;
	public double min;
	public double max;
	public double aver;
}