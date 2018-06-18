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

import com.nlu.entity.model.NonHeap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing NonHeap in entity cache.
 *
 * @author NgocBao
 * @see NonHeap
 * @generated
 */
public class NonHeapCacheModel implements CacheModel<NonHeap>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{nonHeapId=");
		sb.append(nonHeapId);
		sb.append(", time=");
		sb.append(time);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public NonHeap toEntityModel() {
		NonHeapImpl nonHeapImpl = new NonHeapImpl();

		nonHeapImpl.setNonHeapId(nonHeapId);

		if (time == Long.MIN_VALUE) {
			nonHeapImpl.setTime(null);
		}
		else {
			nonHeapImpl.setTime(new Date(time));
		}

		nonHeapImpl.setValue(value);

		nonHeapImpl.resetOriginalValues();

		return nonHeapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		nonHeapId = objectInput.readLong();
		time = objectInput.readLong();
		value = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(nonHeapId);
		objectOutput.writeLong(time);
		objectOutput.writeDouble(value);
	}

	public long nonHeapId;
	public long time;
	public double value;
}