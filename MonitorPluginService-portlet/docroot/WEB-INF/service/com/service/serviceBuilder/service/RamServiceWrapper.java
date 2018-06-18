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

package com.service.serviceBuilder.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RamService}.
 *
 * @author NgocBao
 * @see RamService
 * @generated
 */
public class RamServiceWrapper implements RamService,
	ServiceWrapper<RamService> {
	public RamServiceWrapper(RamService ramService) {
		_ramService = ramService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _ramService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_ramService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _ramService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.service.serviceBuilder.model.Ram addRam(java.util.Date time,
		double min, double max, double aver,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ramService.addRam(time, min, max, aver, serviceContext);
	}

	@Override
	public void deleteRam(long ramId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_ramService.deleteRam(ramId);
	}

	@Override
	public com.service.serviceBuilder.model.Ram getRam(long ramId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ramService.getRam(ramId);
	}

	@Override
	public com.service.serviceBuilder.model.Ram updateRam(long ramId,
		java.util.Date time, double min, double max, double aver,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _ramService.updateRam(ramId, time, min, max, aver, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public RamService getWrappedRamService() {
		return _ramService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedRamService(RamService ramService) {
		_ramService = ramService;
	}

	@Override
	public RamService getWrappedService() {
		return _ramService;
	}

	@Override
	public void setWrappedService(RamService ramService) {
		_ramService = ramService;
	}

	private RamService _ramService;
}