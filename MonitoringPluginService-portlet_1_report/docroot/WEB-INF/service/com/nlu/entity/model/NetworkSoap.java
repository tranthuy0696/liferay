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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.nlu.entity.service.http.NetworkServiceSoap}.
 *
 * @author NgocBao
 * @see com.nlu.entity.service.http.NetworkServiceSoap
 * @generated
 */
public class NetworkSoap implements Serializable {
	public static NetworkSoap toSoapModel(Network model) {
		NetworkSoap soapModel = new NetworkSoap();

		soapModel.setNetworkId(model.getNetworkId());
		soapModel.setTime(model.getTime());
		soapModel.setDown(model.getDown());
		soapModel.setUp(model.getUp());

		return soapModel;
	}

	public static NetworkSoap[] toSoapModels(Network[] models) {
		NetworkSoap[] soapModels = new NetworkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NetworkSoap[][] toSoapModels(Network[][] models) {
		NetworkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NetworkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NetworkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NetworkSoap[] toSoapModels(List<Network> models) {
		List<NetworkSoap> soapModels = new ArrayList<NetworkSoap>(models.size());

		for (Network model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NetworkSoap[soapModels.size()]);
	}

	public NetworkSoap() {
	}

	public long getPrimaryKey() {
		return _networkId;
	}

	public void setPrimaryKey(long pk) {
		setNetworkId(pk);
	}

	public long getNetworkId() {
		return _networkId;
	}

	public void setNetworkId(long networkId) {
		_networkId = networkId;
	}

	public Date getTime() {
		return _time;
	}

	public void setTime(Date time) {
		_time = time;
	}

	public double getDown() {
		return _down;
	}

	public void setDown(double down) {
		_down = down;
	}

	public double getUp() {
		return _up;
	}

	public void setUp(double up) {
		_up = up;
	}

	private long _networkId;
	private Date _time;
	private double _down;
	private double _up;
}