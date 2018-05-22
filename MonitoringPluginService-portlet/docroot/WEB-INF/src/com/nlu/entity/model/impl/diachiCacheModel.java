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

package com.nlu.entity.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.nlu.entity.model.diachi;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing diachi in entity cache.
 *
 * @author NgocBao
 * @see diachi
 * @generated
 */
public class diachiCacheModel implements CacheModel<diachi>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{id=");
		sb.append(id);
		sb.append(", tinh=");
		sb.append(tinh);
		sb.append(", huyen=");
		sb.append(huyen);
		sb.append(", xa=");
		sb.append(xa);
		sb.append(", duong=");
		sb.append(duong);
		sb.append(", duongKhac=");
		sb.append(duongKhac);
		sb.append(", khuPho=");
		sb.append(khuPho);
		sb.append(", soNha=");
		sb.append(soNha);
		sb.append(", quocGia=");
		sb.append(quocGia);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public diachi toEntityModel() {
		diachiImpl diachiImpl = new diachiImpl();

		diachiImpl.setId(id);

		if (tinh == null) {
			diachiImpl.setTinh(StringPool.BLANK);
		}
		else {
			diachiImpl.setTinh(tinh);
		}

		if (huyen == null) {
			diachiImpl.setHuyen(StringPool.BLANK);
		}
		else {
			diachiImpl.setHuyen(huyen);
		}

		if (xa == null) {
			diachiImpl.setXa(StringPool.BLANK);
		}
		else {
			diachiImpl.setXa(xa);
		}

		if (duong == null) {
			diachiImpl.setDuong(StringPool.BLANK);
		}
		else {
			diachiImpl.setDuong(duong);
		}

		if (duongKhac == null) {
			diachiImpl.setDuongKhac(StringPool.BLANK);
		}
		else {
			diachiImpl.setDuongKhac(duongKhac);
		}

		if (khuPho == null) {
			diachiImpl.setKhuPho(StringPool.BLANK);
		}
		else {
			diachiImpl.setKhuPho(khuPho);
		}

		if (soNha == null) {
			diachiImpl.setSoNha(StringPool.BLANK);
		}
		else {
			diachiImpl.setSoNha(soNha);
		}

		if (quocGia == null) {
			diachiImpl.setQuocGia(StringPool.BLANK);
		}
		else {
			diachiImpl.setQuocGia(quocGia);
		}

		diachiImpl.resetOriginalValues();

		return diachiImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		tinh = objectInput.readUTF();
		huyen = objectInput.readUTF();
		xa = objectInput.readUTF();
		duong = objectInput.readUTF();
		duongKhac = objectInput.readUTF();
		khuPho = objectInput.readUTF();
		soNha = objectInput.readUTF();
		quocGia = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		if (tinh == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tinh);
		}

		if (huyen == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(huyen);
		}

		if (xa == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(xa);
		}

		if (duong == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(duong);
		}

		if (duongKhac == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(duongKhac);
		}

		if (khuPho == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(khuPho);
		}

		if (soNha == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(soNha);
		}

		if (quocGia == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(quocGia);
		}
	}

	public long id;
	public String tinh;
	public String huyen;
	public String xa;
	public String duong;
	public String duongKhac;
	public String khuPho;
	public String soNha;
	public String quocGia;
}