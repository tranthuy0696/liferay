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
 * This class is used by SOAP remote services, specifically {@link com.nlu.entity.service.http.AlarmInfoServiceSoap}.
 *
 * @author NgocBao
 * @see com.nlu.entity.service.http.AlarmInfoServiceSoap
 * @generated
 */
public class AlarmInfoSoap implements Serializable {
	public static AlarmInfoSoap toSoapModel(AlarmInfo model) {
		AlarmInfoSoap soapModel = new AlarmInfoSoap();

		soapModel.setAlarmInfoId(model.getAlarmInfoId());
		soapModel.setName(model.getName());
		soapModel.setMail(model.getMail());

		return soapModel;
	}

	public static AlarmInfoSoap[] toSoapModels(AlarmInfo[] models) {
		AlarmInfoSoap[] soapModels = new AlarmInfoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AlarmInfoSoap[][] toSoapModels(AlarmInfo[][] models) {
		AlarmInfoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AlarmInfoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AlarmInfoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AlarmInfoSoap[] toSoapModels(List<AlarmInfo> models) {
		List<AlarmInfoSoap> soapModels = new ArrayList<AlarmInfoSoap>(models.size());

		for (AlarmInfo model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AlarmInfoSoap[soapModels.size()]);
	}

	public AlarmInfoSoap() {
	}

	public long getPrimaryKey() {
		return _alarmInfoId;
	}

	public void setPrimaryKey(long pk) {
		setAlarmInfoId(pk);
	}

	public long getAlarmInfoId() {
		return _alarmInfoId;
	}

	public void setAlarmInfoId(long alarmInfoId) {
		_alarmInfoId = alarmInfoId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getMail() {
		return _mail;
	}

	public void setMail(String mail) {
		_mail = mail;
	}

	private long _alarmInfoId;
	private String _name;
	private String _mail;
}