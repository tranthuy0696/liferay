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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.nlu.entity.service.ClpSerializer;
import com.nlu.entity.service.diachiLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NgocBao
 */
public class diachiClp extends BaseModelImpl<diachi> implements diachi {
	public diachiClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return diachi.class;
	}

	@Override
	public String getModelClassName() {
		return diachi.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _id;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _id;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("tinh", getTinh());
		attributes.put("huyen", getHuyen());
		attributes.put("xa", getXa());
		attributes.put("duong", getDuong());
		attributes.put("duongKhac", getDuongKhac());
		attributes.put("khuPho", getKhuPho());
		attributes.put("soNha", getSoNha());
		attributes.put("quocGia", getQuocGia());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String tinh = (String)attributes.get("tinh");

		if (tinh != null) {
			setTinh(tinh);
		}

		String huyen = (String)attributes.get("huyen");

		if (huyen != null) {
			setHuyen(huyen);
		}

		String xa = (String)attributes.get("xa");

		if (xa != null) {
			setXa(xa);
		}

		String duong = (String)attributes.get("duong");

		if (duong != null) {
			setDuong(duong);
		}

		String duongKhac = (String)attributes.get("duongKhac");

		if (duongKhac != null) {
			setDuongKhac(duongKhac);
		}

		String khuPho = (String)attributes.get("khuPho");

		if (khuPho != null) {
			setKhuPho(khuPho);
		}

		String soNha = (String)attributes.get("soNha");

		if (soNha != null) {
			setSoNha(soNha);
		}

		String quocGia = (String)attributes.get("quocGia");

		if (quocGia != null) {
			setQuocGia(quocGia);
		}
	}

	@Override
	public long getId() {
		return _id;
	}

	@Override
	public void setId(long id) {
		_id = id;

		if (_diachiRemoteModel != null) {
			try {
				Class<?> clazz = _diachiRemoteModel.getClass();

				Method method = clazz.getMethod("setId", long.class);

				method.invoke(_diachiRemoteModel, id);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTinh() {
		return _tinh;
	}

	@Override
	public void setTinh(String tinh) {
		_tinh = tinh;

		if (_diachiRemoteModel != null) {
			try {
				Class<?> clazz = _diachiRemoteModel.getClass();

				Method method = clazz.getMethod("setTinh", String.class);

				method.invoke(_diachiRemoteModel, tinh);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHuyen() {
		return _huyen;
	}

	@Override
	public void setHuyen(String huyen) {
		_huyen = huyen;

		if (_diachiRemoteModel != null) {
			try {
				Class<?> clazz = _diachiRemoteModel.getClass();

				Method method = clazz.getMethod("setHuyen", String.class);

				method.invoke(_diachiRemoteModel, huyen);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getXa() {
		return _xa;
	}

	@Override
	public void setXa(String xa) {
		_xa = xa;

		if (_diachiRemoteModel != null) {
			try {
				Class<?> clazz = _diachiRemoteModel.getClass();

				Method method = clazz.getMethod("setXa", String.class);

				method.invoke(_diachiRemoteModel, xa);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDuong() {
		return _duong;
	}

	@Override
	public void setDuong(String duong) {
		_duong = duong;

		if (_diachiRemoteModel != null) {
			try {
				Class<?> clazz = _diachiRemoteModel.getClass();

				Method method = clazz.getMethod("setDuong", String.class);

				method.invoke(_diachiRemoteModel, duong);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDuongKhac() {
		return _duongKhac;
	}

	@Override
	public void setDuongKhac(String duongKhac) {
		_duongKhac = duongKhac;

		if (_diachiRemoteModel != null) {
			try {
				Class<?> clazz = _diachiRemoteModel.getClass();

				Method method = clazz.getMethod("setDuongKhac", String.class);

				method.invoke(_diachiRemoteModel, duongKhac);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKhuPho() {
		return _khuPho;
	}

	@Override
	public void setKhuPho(String khuPho) {
		_khuPho = khuPho;

		if (_diachiRemoteModel != null) {
			try {
				Class<?> clazz = _diachiRemoteModel.getClass();

				Method method = clazz.getMethod("setKhuPho", String.class);

				method.invoke(_diachiRemoteModel, khuPho);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSoNha() {
		return _soNha;
	}

	@Override
	public void setSoNha(String soNha) {
		_soNha = soNha;

		if (_diachiRemoteModel != null) {
			try {
				Class<?> clazz = _diachiRemoteModel.getClass();

				Method method = clazz.getMethod("setSoNha", String.class);

				method.invoke(_diachiRemoteModel, soNha);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQuocGia() {
		return _quocGia;
	}

	@Override
	public void setQuocGia(String quocGia) {
		_quocGia = quocGia;

		if (_diachiRemoteModel != null) {
			try {
				Class<?> clazz = _diachiRemoteModel.getClass();

				Method method = clazz.getMethod("setQuocGia", String.class);

				method.invoke(_diachiRemoteModel, quocGia);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getdiachiRemoteModel() {
		return _diachiRemoteModel;
	}

	public void setdiachiRemoteModel(BaseModel<?> diachiRemoteModel) {
		_diachiRemoteModel = diachiRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _diachiRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_diachiRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			diachiLocalServiceUtil.adddiachi(this);
		}
		else {
			diachiLocalServiceUtil.updatediachi(this);
		}
	}

	@Override
	public diachi toEscapedModel() {
		return (diachi)ProxyUtil.newProxyInstance(diachi.class.getClassLoader(),
			new Class[] { diachi.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		diachiClp clone = new diachiClp();

		clone.setId(getId());
		clone.setTinh(getTinh());
		clone.setHuyen(getHuyen());
		clone.setXa(getXa());
		clone.setDuong(getDuong());
		clone.setDuongKhac(getDuongKhac());
		clone.setKhuPho(getKhuPho());
		clone.setSoNha(getSoNha());
		clone.setQuocGia(getQuocGia());

		return clone;
	}

	@Override
	public int compareTo(diachi diachi) {
		long primaryKey = diachi.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof diachiClp)) {
			return false;
		}

		diachiClp diachi = (diachiClp)obj;

		long primaryKey = diachi.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(getId());
		sb.append(", tinh=");
		sb.append(getTinh());
		sb.append(", huyen=");
		sb.append(getHuyen());
		sb.append(", xa=");
		sb.append(getXa());
		sb.append(", duong=");
		sb.append(getDuong());
		sb.append(", duongKhac=");
		sb.append(getDuongKhac());
		sb.append(", khuPho=");
		sb.append(getKhuPho());
		sb.append(", soNha=");
		sb.append(getSoNha());
		sb.append(", quocGia=");
		sb.append(getQuocGia());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.nlu.entity.model.diachi");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>id</column-name><column-value><![CDATA[");
		sb.append(getId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tinh</column-name><column-value><![CDATA[");
		sb.append(getTinh());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>huyen</column-name><column-value><![CDATA[");
		sb.append(getHuyen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xa</column-name><column-value><![CDATA[");
		sb.append(getXa());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duong</column-name><column-value><![CDATA[");
		sb.append(getDuong());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duongKhac</column-name><column-value><![CDATA[");
		sb.append(getDuongKhac());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>khuPho</column-name><column-value><![CDATA[");
		sb.append(getKhuPho());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>soNha</column-name><column-value><![CDATA[");
		sb.append(getSoNha());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>quocGia</column-name><column-value><![CDATA[");
		sb.append(getQuocGia());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _diachiRemoteModel;
	private Class<?> _clpSerializerClass = com.nlu.entity.service.ClpSerializer.class;
}