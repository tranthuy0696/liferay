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
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.nlu.entity.service.http.AlarmServiceSoap}.
 *
 * @author NgocBao
 * @see com.nlu.entity.service.http.AlarmServiceSoap
 * @generated
 */
public class AlarmSoap implements Serializable {
	public static AlarmSoap toSoapModel(Alarm model) {
		AlarmSoap soapModel = new AlarmSoap();

		soapModel.setAlarmId(model.getAlarmId());
		soapModel.setName(model.getName());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static AlarmSoap[] toSoapModels(Alarm[] models) {
		AlarmSoap[] soapModels = new AlarmSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AlarmSoap[][] toSoapModels(Alarm[][] models) {
		AlarmSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AlarmSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AlarmSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AlarmSoap[] toSoapModels(List<Alarm> models) {
		List<AlarmSoap> soapModels = new ArrayList<AlarmSoap>(models.size());

		for (Alarm model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AlarmSoap[soapModels.size()]);
	}

	public AlarmSoap() {
	}

	public long getPrimaryKey() {
		return _alarmId;
	}

	public void setPrimaryKey(long pk) {
		setAlarmId(pk);
	}

	public long getAlarmId() {
		return _alarmId;
	}

	public void setAlarmId(long alarmId) {
		_alarmId = alarmId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getStartTime() {
		return _startTime;
	}

	public void setStartTime(int startTime) {
		_startTime = startTime;
	}

	public int getEndTime() {
		return _endTime;
	}

	public void setEndTime(int endTime) {
		_endTime = endTime;
	}

	public double getValue() {
		return _value;
	}

	public void setValue(double value) {
		_value = value;
	}

	private long _alarmId;
	private String _name;
	private int _startTime;
	private int _endTime;
	private double _value;
}