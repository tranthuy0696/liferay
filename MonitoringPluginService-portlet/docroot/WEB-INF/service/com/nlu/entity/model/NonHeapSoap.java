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
 * This class is used by SOAP remote services, specifically {@link com.nlu.entity.service.http.NonHeapServiceSoap}.
 *
 * @author NgocBao
 * @see com.nlu.entity.service.http.NonHeapServiceSoap
 * @generated
 */
public class NonHeapSoap implements Serializable {
	public static NonHeapSoap toSoapModel(NonHeap model) {
		NonHeapSoap soapModel = new NonHeapSoap();

		soapModel.setNonHeapId(model.getNonHeapId());
		soapModel.setTime(model.getTime());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static NonHeapSoap[] toSoapModels(NonHeap[] models) {
		NonHeapSoap[] soapModels = new NonHeapSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static NonHeapSoap[][] toSoapModels(NonHeap[][] models) {
		NonHeapSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new NonHeapSoap[models.length][models[0].length];
		}
		else {
			soapModels = new NonHeapSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static NonHeapSoap[] toSoapModels(List<NonHeap> models) {
		List<NonHeapSoap> soapModels = new ArrayList<NonHeapSoap>(models.size());

		for (NonHeap model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new NonHeapSoap[soapModels.size()]);
	}

	public NonHeapSoap() {
	}

	public long getPrimaryKey() {
		return _nonHeapId;
	}

	public void setPrimaryKey(long pk) {
		setNonHeapId(pk);
	}

	public long getNonHeapId() {
		return _nonHeapId;
	}

	public void setNonHeapId(long nonHeapId) {
		_nonHeapId = nonHeapId;
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

	private long _nonHeapId;
	private Date _time;
	private double _value;
}