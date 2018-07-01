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

import com.nlu.entity.model.Heap;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Heap in entity cache.
 *
 * @author NgocBao
 * @see Heap
 * @generated
 */
public class HeapCacheModel implements CacheModel<Heap>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{heapId=");
		sb.append(heapId);
		sb.append(", time=");
		sb.append(time);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Heap toEntityModel() {
		HeapImpl heapImpl = new HeapImpl();

		heapImpl.setHeapId(heapId);

		if (time == Long.MIN_VALUE) {
			heapImpl.setTime(null);
		}
		else {
			heapImpl.setTime(new Date(time));
		}

		heapImpl.setValue(value);

		heapImpl.resetOriginalValues();

		return heapImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		heapId = objectInput.readLong();
		time = objectInput.readLong();
		value = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(heapId);
		objectOutput.writeLong(time);
		objectOutput.writeDouble(value);
	}

	public long heapId;
	public long time;
	public double value;
}