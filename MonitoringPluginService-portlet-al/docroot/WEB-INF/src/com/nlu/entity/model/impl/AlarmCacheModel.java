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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.nlu.entity.model.Alarm;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Alarm in entity cache.
 *
 * @author NgocBao
 * @see Alarm
 * @generated
 */
public class AlarmCacheModel implements CacheModel<Alarm>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{alarmId=");
		sb.append(alarmId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Alarm toEntityModel() {
		AlarmImpl alarmImpl = new AlarmImpl();

		alarmImpl.setAlarmId(alarmId);

		if (name == null) {
			alarmImpl.setName(StringPool.BLANK);
		}
		else {
			alarmImpl.setName(name);
		}

		alarmImpl.setStartTime(startTime);
		alarmImpl.setEndTime(endTime);
		alarmImpl.setValue(value);

		alarmImpl.resetOriginalValues();

		return alarmImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		alarmId = objectInput.readLong();
		name = objectInput.readUTF();
		startTime = objectInput.readInt();
		endTime = objectInput.readInt();
		value = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(alarmId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(startTime);
		objectOutput.writeInt(endTime);
		objectOutput.writeDouble(value);
	}

	public long alarmId;
	public String name;
	public int startTime;
	public int endTime;
	public double value;
}