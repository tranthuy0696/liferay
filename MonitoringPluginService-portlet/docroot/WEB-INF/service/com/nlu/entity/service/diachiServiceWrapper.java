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

package com.nlu.entity.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link diachiService}.
 *
 * @author NgocBao
 * @see diachiService
 * @generated
 */
public class diachiServiceWrapper implements diachiService,
	ServiceWrapper<diachiService> {
	public diachiServiceWrapper(diachiService diachiService) {
		_diachiService = diachiService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _diachiService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_diachiService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _diachiService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.nlu.entity.model.diachi adddiachi(long id,
		java.lang.String tinh, java.lang.String huyen, java.lang.String xa,
		java.lang.String duong, java.lang.String duongKhac,
		java.lang.String khuPho, java.lang.String soNha,
		java.lang.String quocGia,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _diachiService.adddiachi(id, tinh, huyen, xa, duong, duongKhac,
			khuPho, soNha, quocGia, serviceContext);
	}

	@Override
	public void deletediachi(long diachiId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_diachiService.deletediachi(diachiId);
	}

	@Override
	public com.nlu.entity.model.diachi getdiachi(long diachiId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _diachiService.getdiachi(diachiId);
	}

	@Override
	public com.nlu.entity.model.diachi updatediachi(long diachiId, long id,
		java.lang.String tinh, java.lang.String huyen, java.lang.String xa,
		java.lang.String duong, java.lang.String duongKhac,
		java.lang.String khuPho, java.lang.String soNha,
		java.lang.String quocGia,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _diachiService.updatediachi(diachiId, id, tinh, huyen, xa,
			duong, duongKhac, khuPho, soNha, quocGia, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public diachiService getWrappeddiachiService() {
		return _diachiService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappeddiachiService(diachiService diachiService) {
		_diachiService = diachiService;
	}

	@Override
	public diachiService getWrappedService() {
		return _diachiService;
	}

	@Override
	public void setWrappedService(diachiService diachiService) {
		_diachiService = diachiService;
	}

	private diachiService _diachiService;
}