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
 * This class is used by SOAP remote services, specifically {@link com.nlu.entity.service.http.HeapServiceSoap}.
 *
 * @author NgocBao
 * @see com.nlu.entity.service.http.HeapServiceSoap
 * @generated
 */
public class HeapSoap implements Serializable {
	public static HeapSoap toSoapModel(Heap model) {
		HeapSoap soapModel = new HeapSoap();

		soapModel.setHeapId(model.getHeapId());
		soapModel.setTime(model.getTime());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static HeapSoap[] toSoapModels(Heap[] models) {
		HeapSoap[] soapModels = new HeapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HeapSoap[][] toSoapModels(Heap[][] models) {
		HeapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HeapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HeapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HeapSoap[] toSoapModels(List<Heap> models) {
		List<HeapSoap> soapModels = new ArrayList<HeapSoap>(models.size());

		for (Heap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HeapSoap[soapModels.size()]);
	}

	public HeapSoap() {
	}

	public long getPrimaryKey() {
		return _heapId;
	}

	public void setPrimaryKey(long pk) {
		setHeapId(pk);
	}

	public long getHeapId() {
		return _heapId;
	}

	public void setHeapId(long heapId) {
		_heapId = heapId;
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

	private long _heapId;
	private Date _time;
	private double _value;
}