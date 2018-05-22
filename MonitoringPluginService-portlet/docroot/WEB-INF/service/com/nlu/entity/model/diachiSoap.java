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
 * This class is used by SOAP remote services, specifically {@link com.nlu.entity.service.http.diachiServiceSoap}.
 *
 * @author NgocBao
 * @see com.nlu.entity.service.http.diachiServiceSoap
 * @generated
 */
public class diachiSoap implements Serializable {
	public static diachiSoap toSoapModel(diachi model) {
		diachiSoap soapModel = new diachiSoap();

		soapModel.setId(model.getId());
		soapModel.setTinh(model.getTinh());
		soapModel.setHuyen(model.getHuyen());
		soapModel.setXa(model.getXa());
		soapModel.setDuong(model.getDuong());
		soapModel.setDuongKhac(model.getDuongKhac());
		soapModel.setKhuPho(model.getKhuPho());
		soapModel.setSoNha(model.getSoNha());
		soapModel.setQuocGia(model.getQuocGia());

		return soapModel;
	}

	public static diachiSoap[] toSoapModels(diachi[] models) {
		diachiSoap[] soapModels = new diachiSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static diachiSoap[][] toSoapModels(diachi[][] models) {
		diachiSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new diachiSoap[models.length][models[0].length];
		}
		else {
			soapModels = new diachiSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static diachiSoap[] toSoapModels(List<diachi> models) {
		List<diachiSoap> soapModels = new ArrayList<diachiSoap>(models.size());

		for (diachi model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new diachiSoap[soapModels.size()]);
	}

	public diachiSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public String getTinh() {
		return _tinh;
	}

	public void setTinh(String tinh) {
		_tinh = tinh;
	}

	public String getHuyen() {
		return _huyen;
	}

	public void setHuyen(String huyen) {
		_huyen = huyen;
	}

	public String getXa() {
		return _xa;
	}

	public void setXa(String xa) {
		_xa = xa;
	}

	public String getDuong() {
		return _duong;
	}

	public void setDuong(String duong) {
		_duong = duong;
	}

	public String getDuongKhac() {
		return _duongKhac;
	}

	public void setDuongKhac(String duongKhac) {
		_duongKhac = duongKhac;
	}

	public String getKhuPho() {
		return _khuPho;
	}

	public void setKhuPho(String khuPho) {
		_khuPho = khuPho;
	}

	public String getSoNha() {
		return _soNha;
	}

	public void setSoNha(String soNha) {
		_soNha = soNha;
	}

	public String getQuocGia() {
		return _quocGia;
	}

	public void setQuocGia(String quocGia) {
		_quocGia = quocGia;
	}

	private long _id;
	private String _tinh;
	private String _huyen;
	private String _xa;
	private String _duong;
	private String _duongKhac;
	private String _khuPho;
	private String _soNha;
	private String _quocGia;
}