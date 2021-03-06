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
 * This class is used by SOAP remote services, specifically {@link com.nlu.entity.service.http.RamServiceSoap}.
 *
 * @author NgocBao
 * @see com.nlu.entity.service.http.RamServiceSoap
 * @generated
 */
public class RamSoap implements Serializable {
	public static RamSoap toSoapModel(Ram model) {
		RamSoap soapModel = new RamSoap();

		soapModel.setRamId(model.getRamId());
		soapModel.setTime(model.getTime());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static RamSoap[] toSoapModels(Ram[] models) {
		RamSoap[] soapModels = new RamSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RamSoap[][] toSoapModels(Ram[][] models) {
		RamSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RamSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RamSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RamSoap[] toSoapModels(List<Ram> models) {
		List<RamSoap> soapModels = new ArrayList<RamSoap>(models.size());

		for (Ram model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RamSoap[soapModels.size()]);
	}

	public RamSoap() {
	}

	public long getPrimaryKey() {
		return _ramId;
	}

	public void setPrimaryKey(long pk) {
		setRamId(pk);
	}

	public long getRamId() {
		return _ramId;
	}

	public void setRamId(long ramId) {
		_ramId = ramId;
	}

	public Date getTime() {
		return _time;
	}

	public void setTime(Date time) {
		_time = time;
	}

	public double getValue() {
		return _value;
	}

	public void setValue(double value) {
		_value = value;
	}

	private long _ramId;
	private Date _time;
	private double _value;
}