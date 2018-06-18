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

package com.service.serviceBuilder.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import com.service.serviceBuilder.model.Ram;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Ram in entity cache.
 *
 * @author NgocBao
 * @see Ram
 * @generated
 */
public class RamCacheModel implements CacheModel<Ram>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{ramId=");
		sb.append(ramId);
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
	public Ram toEntityModel() {
		RamImpl ramImpl = new RamImpl();

		ramImpl.setRamId(ramId);

		if (time == Long.MIN_VALUE) {
			ramImpl.setTime(null);
		}
		else {
			ramImpl.setTime(new Date(time));
		}

		ramImpl.setMin(min);
		ramImpl.setMax(max);
		ramImpl.setAver(aver);

		ramImpl.resetOriginalValues();

		return ramImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ramId = objectInput.readLong();
		time = objectInput.readLong();
		min = objectInput.readDouble();
		max = objectInput.readDouble();
		aver = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ramId);
		objectOutput.writeLong(time);
		objectOutput.writeDouble(min);
		objectOutput.writeDouble(max);
		objectOutput.writeDouble(aver);
	}

	public long ramId;
	public long time;
	public double min;
	public double max;
	public double aver;
}