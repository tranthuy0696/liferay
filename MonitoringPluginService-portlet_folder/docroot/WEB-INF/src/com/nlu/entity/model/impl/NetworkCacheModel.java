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

import com.nlu.entity.model.Network;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Network in entity cache.
 *
 * @author NgocBao
 * @see Network
 * @generated
 */
public class NetworkCacheModel implements CacheModel<Network>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{networkId=");
		sb.append(networkId);
		sb.append(", time=");
		sb.append(time);
		sb.append(", down=");
		sb.append(down);
		sb.append(", up=");
		sb.append(up);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Network toEntityModel() {
		NetworkImpl networkImpl = new NetworkImpl();

		networkImpl.setNetworkId(networkId);

		if (time == Long.MIN_VALUE) {
			networkImpl.setTime(null);
		}
		else {
			networkImpl.setTime(new Date(time));
		}

		networkImpl.setDown(down);
		networkImpl.setUp(up);

		networkImpl.resetOriginalValues();

		return networkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		networkId = objectInput.readLong();
		time = objectInput.readLong();
		down = objectInput.readDouble();
		up = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(networkId);
		objectOutput.writeLong(time);
		objectOutput.writeDouble(down);
		objectOutput.writeDouble(up);
	}

	public long networkId;
	public long time;
	public double down;
	public double up;
}