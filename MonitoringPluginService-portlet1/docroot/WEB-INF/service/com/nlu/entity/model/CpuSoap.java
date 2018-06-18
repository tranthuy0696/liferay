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
 * This class is used by SOAP remote services, specifically {@link com.nlu.entity.service.http.CpuServiceSoap}.
 *
 * @author NgocBao
 * @see com.nlu.entity.service.http.CpuServiceSoap
 * @generated
 */
public class CpuSoap implements Serializable {
	public static CpuSoap toSoapModel(Cpu model) {
		CpuSoap soapModel = new CpuSoap();

		soapModel.setCpuId(model.getCpuId());
		soapModel.setTime(model.getTime());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static CpuSoap[] toSoapModels(Cpu[] models) {
		CpuSoap[] soapModels = new CpuSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CpuSoap[][] toSoapModels(Cpu[][] models) {
		CpuSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CpuSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CpuSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CpuSoap[] toSoapModels(List<Cpu> models) {
		List<CpuSoap> soapModels = new ArrayList<CpuSoap>(models.size());

		for (Cpu model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CpuSoap[soapModels.size()]);
	}

	public CpuSoap() {
	}

	public long getPrimaryKey() {
		return _cpuId;
	}

	public void setPrimaryKey(long pk) {
		setCpuId(pk);
	}

	public long getCpuId() {
		return _cpuId;
	}

	public void setCpuId(long cpuId) {
		_cpuId = cpuId;
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

	private long _cpuId;
	private Date _time;
	private double _value;
}