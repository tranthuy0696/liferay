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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link diachi}.
 * </p>
 *
 * @author NgocBao
 * @see diachi
 * @generated
 */
public class diachiWrapper implements diachi, ModelWrapper<diachi> {
	public diachiWrapper(diachi diachi) {
		_diachi = diachi;
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

	/**
	* Returns the primary key of this diachi.
	*
	* @return the primary key of this diachi
	*/
	@Override
	public long getPrimaryKey() {
		return _diachi.getPrimaryKey();
	}

	/**
	* Sets the primary key of this diachi.
	*
	* @param primaryKey the primary key of this diachi
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_diachi.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this diachi.
	*
	* @return the ID of this diachi
	*/
	@Override
	public long getId() {
		return _diachi.getId();
	}

	/**
	* Sets the ID of this diachi.
	*
	* @param id the ID of this diachi
	*/
	@Override
	public void setId(long id) {
		_diachi.setId(id);
	}

	/**
	* Returns the tinh of this diachi.
	*
	* @return the tinh of this diachi
	*/
	@Override
	public java.lang.String getTinh() {
		return _diachi.getTinh();
	}

	/**
	* Sets the tinh of this diachi.
	*
	* @param tinh the tinh of this diachi
	*/
	@Override
	public void setTinh(java.lang.String tinh) {
		_diachi.setTinh(tinh);
	}

	/**
	* Returns the huyen of this diachi.
	*
	* @return the huyen of this diachi
	*/
	@Override
	public java.lang.String getHuyen() {
		return _diachi.getHuyen();
	}

	/**
	* Sets the huyen of this diachi.
	*
	* @param huyen the huyen of this diachi
	*/
	@Override
	public void setHuyen(java.lang.String huyen) {
		_diachi.setHuyen(huyen);
	}

	/**
	* Returns the xa of this diachi.
	*
	* @return the xa of this diachi
	*/
	@Override
	public java.lang.String getXa() {
		return _diachi.getXa();
	}

	/**
	* Sets the xa of this diachi.
	*
	* @param xa the xa of this diachi
	*/
	@Override
	public void setXa(java.lang.String xa) {
		_diachi.setXa(xa);
	}

	/**
	* Returns the duong of this diachi.
	*
	* @return the duong of this diachi
	*/
	@Override
	public java.lang.String getDuong() {
		return _diachi.getDuong();
	}

	/**
	* Sets the duong of this diachi.
	*
	* @param duong the duong of this diachi
	*/
	@Override
	public void setDuong(java.lang.String duong) {
		_diachi.setDuong(duong);
	}

	/**
	* Returns the duong khac of this diachi.
	*
	* @return the duong khac of this diachi
	*/
	@Override
	public java.lang.String getDuongKhac() {
		return _diachi.getDuongKhac();
	}

	/**
	* Sets the duong khac of this diachi.
	*
	* @param duongKhac the duong khac of this diachi
	*/
	@Override
	public void setDuongKhac(java.lang.String duongKhac) {
		_diachi.setDuongKhac(duongKhac);
	}

	/**
	* Returns the khu pho of this diachi.
	*
	* @return the khu pho of this diachi
	*/
	@Override
	public java.lang.String getKhuPho() {
		return _diachi.getKhuPho();
	}

	/**
	* Sets the khu pho of this diachi.
	*
	* @param khuPho the khu pho of this diachi
	*/
	@Override
	public void setKhuPho(java.lang.String khuPho) {
		_diachi.setKhuPho(khuPho);
	}

	/**
	* Returns the so nha of this diachi.
	*
	* @return the so nha of this diachi
	*/
	@Override
	public java.lang.String getSoNha() {
		return _diachi.getSoNha();
	}

	/**
	* Sets the so nha of this diachi.
	*
	* @param soNha the so nha of this diachi
	*/
	@Override
	public void setSoNha(java.lang.String soNha) {
		_diachi.setSoNha(soNha);
	}

	/**
	* Returns the quoc gia of this diachi.
	*
	* @return the quoc gia of this diachi
	*/
	@Override
	public java.lang.String getQuocGia() {
		return _diachi.getQuocGia();
	}

	/**
	* Sets the quoc gia of this diachi.
	*
	* @param quocGia the quoc gia of this diachi
	*/
	@Override
	public void setQuocGia(java.lang.String quocGia) {
		_diachi.setQuocGia(quocGia);
	}

	@Override
	public boolean isNew() {
		return _diachi.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_diachi.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _diachi.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_diachi.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _diachi.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _diachi.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_diachi.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _diachi.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_diachi.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_diachi.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_diachi.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new diachiWrapper((diachi)_diachi.clone());
	}

	@Override
	public int compareTo(com.nlu.entity.model.diachi diachi) {
		return _diachi.compareTo(diachi);
	}

	@Override
	public int hashCode() {
		return _diachi.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.nlu.entity.model.diachi> toCacheModel() {
		return _diachi.toCacheModel();
	}

	@Override
	public com.nlu.entity.model.diachi toEscapedModel() {
		return new diachiWrapper(_diachi.toEscapedModel());
	}

	@Override
	public com.nlu.entity.model.diachi toUnescapedModel() {
		return new diachiWrapper(_diachi.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _diachi.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _diachi.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_diachi.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof diachiWrapper)) {
			return false;
		}

		diachiWrapper diachiWrapper = (diachiWrapper)obj;

		if (Validator.equals(_diachi, diachiWrapper._diachi)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public diachi getWrappeddiachi() {
		return _diachi;
	}

	@Override
	public diachi getWrappedModel() {
		return _diachi;
	}

	@Override
	public void resetOriginalValues() {
		_diachi.resetOriginalValues();
	}

	private diachi _diachi;
}