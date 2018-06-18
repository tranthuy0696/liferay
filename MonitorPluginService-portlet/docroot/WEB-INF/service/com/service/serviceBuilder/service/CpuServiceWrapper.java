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
 * Provides a wrapper for {@link CpuService}.
 *
 * @author NgocBao
 * @see CpuService
 * @generated
 */
public class CpuServiceWrapper implements CpuService,
	ServiceWrapper<CpuService> {
	public CpuServiceWrapper(CpuService cpuService) {
		_cpuService = cpuService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cpuService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cpuService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cpuService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.service.serviceBuilder.model.Cpu addCpu(java.util.Date time,
		double min, double max, double aver,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cpuService.addCpu(time, min, max, aver, serviceContext);
	}

	@Override
	public void deleteCpu(long cpuId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_cpuService.deleteCpu(cpuId);
	}

	@Override
	public com.service.serviceBuilder.model.Cpu getCpu(long cpuId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cpuService.getCpu(cpuId);
	}

	@Override
	public com.service.serviceBuilder.model.Cpu updateCpu(long cpuId,
		java.util.Date time, double min, double max, double aver,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cpuService.updateCpu(cpuId, time, min, max, aver, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CpuService getWrappedCpuService() {
		return _cpuService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCpuService(CpuService cpuService) {
		_cpuService = cpuService;
	}

	@Override
	public CpuService getWrappedService() {
		return _cpuService;
	}

	@Override
	public void setWrappedService(CpuService cpuService) {
		_cpuService = cpuService;
	}

	private CpuService _cpuService;
}