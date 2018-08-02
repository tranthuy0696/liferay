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

import com.nlu.entity.model.AlarmInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AlarmInfo in entity cache.
 *
 * @author NgocBao
 * @see AlarmInfo
 * @generated
 */
public class AlarmInfoCacheModel implements CacheModel<AlarmInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{alarmInfoId=");
		sb.append(alarmInfoId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", mail=");
		sb.append(mail);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AlarmInfo toEntityModel() {
		AlarmInfoImpl alarmInfoImpl = new AlarmInfoImpl();

		alarmInfoImpl.setAlarmInfoId(alarmInfoId);

		if (name == null) {
			alarmInfoImpl.setName(StringPool.BLANK);
		}
		else {
			alarmInfoImpl.setName(name);
		}

		if (mail == null) {
			alarmInfoImpl.setMail(StringPool.BLANK);
		}
		else {
			alarmInfoImpl.setMail(mail);
		}

		alarmInfoImpl.resetOriginalValues();

		return alarmInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		alarmInfoId = objectInput.readLong();
		name = objectInput.readUTF();
		mail = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(alarmInfoId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (mail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mail);
		}
	}

	public long alarmInfoId;
	public String name;
	public String mail;
}