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

import com.nlu.entity.model.SessionRequest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SessionRequest in entity cache.
 *
 * @author NgocBao
 * @see SessionRequest
 * @generated
 */
public class SessionRequestCacheModel implements CacheModel<SessionRequest>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{sessionRequestId=");
		sb.append(sessionRequestId);
		sb.append(", sessionId=");
		sb.append(sessionId);
		sb.append(", time=");
		sb.append(time);
		sb.append(", ip=");
		sb.append(ip);
		sb.append(", browser=");
		sb.append(browser);
		sb.append(", os=");
		sb.append(os);
		sb.append(", login=");
		sb.append(login);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SessionRequest toEntityModel() {
		SessionRequestImpl sessionRequestImpl = new SessionRequestImpl();

		sessionRequestImpl.setSessionRequestId(sessionRequestId);

		if (sessionId == null) {
			sessionRequestImpl.setSessionId(StringPool.BLANK);
		}
		else {
			sessionRequestImpl.setSessionId(sessionId);
		}

		if (time == Long.MIN_VALUE) {
			sessionRequestImpl.setTime(null);
		}
		else {
			sessionRequestImpl.setTime(new Date(time));
		}

		if (ip == null) {
			sessionRequestImpl.setIp(StringPool.BLANK);
		}
		else {
			sessionRequestImpl.setIp(ip);
		}

		if (browser == null) {
			sessionRequestImpl.setBrowser(StringPool.BLANK);
		}
		else {
			sessionRequestImpl.setBrowser(browser);
		}

		if (os == null) {
			sessionRequestImpl.setOs(StringPool.BLANK);
		}
		else {
			sessionRequestImpl.setOs(os);
		}

		sessionRequestImpl.setLogin(login);

		sessionRequestImpl.resetOriginalValues();

		return sessionRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sessionRequestId = objectInput.readLong();
		sessionId = objectInput.readUTF();
		time = objectInput.readLong();
		ip = objectInput.readUTF();
		browser = objectInput.readUTF();
		os = objectInput.readUTF();
		login = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sessionRequestId);

		if (sessionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sessionId);
		}

		objectOutput.writeLong(time);

		if (ip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ip);
		}

		if (browser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(browser);
		}

		if (os == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(os);
		}

		objectOutput.writeBoolean(login);
	}

	public long sessionRequestId;
	public String sessionId;
	public long time;
	public String ip;
	public String browser;
	public String os;
	public boolean login;
}