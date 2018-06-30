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
 * Provides a wrapper for {@link NonHeapService}.
 *
 * @author NgocBao
 * @see NonHeapService
 * @generated
 */
public class NonHeapServiceWrapper implements NonHeapService,
	ServiceWrapper<NonHeapService> {
	public NonHeapServiceWrapper(NonHeapService nonHeapService) {
		_nonHeapService = nonHeapService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _nonHeapService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_nonHeapService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _nonHeapService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.nlu.entity.model.NonHeap addNonHeap(java.util.Date time,
		double value, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapService.addNonHeap(time, value, serviceContext);
	}

	@Override
	public void deleteNonHeap(long nonHeapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_nonHeapService.deleteNonHeap(nonHeapId);
	}

	@Override
	public com.nlu.entity.model.NonHeap getNonHeap(long nonHeapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapService.getNonHeap(nonHeapId);
	}

	@Override
	public com.nlu.entity.model.NonHeap updateNonHeap(long nonHeapId,
		java.util.Date time, double value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _nonHeapService.updateNonHeap(nonHeapId, time, value,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public NonHeapService getWrappedNonHeapService() {
		return _nonHeapService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedNonHeapService(NonHeapService nonHeapService) {
		_nonHeapService = nonHeapService;
	}

	@Override
	public NonHeapService getWrappedService() {
		return _nonHeapService;
	}

	@Override
	public void setWrappedService(NonHeapService nonHeapService) {
		_nonHeapService = nonHeapService;
	}

	private NonHeapService _nonHeapService;
}