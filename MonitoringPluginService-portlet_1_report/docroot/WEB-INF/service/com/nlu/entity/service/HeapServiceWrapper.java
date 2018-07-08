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
 * Provides a wrapper for {@link HeapService}.
 *
 * @author NgocBao
 * @see HeapService
 * @generated
 */
public class HeapServiceWrapper implements HeapService,
	ServiceWrapper<HeapService> {
	public HeapServiceWrapper(HeapService heapService) {
		_heapService = heapService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _heapService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_heapService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _heapService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.nlu.entity.model.Heap addHeap(java.util.Date time, double value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _heapService.addHeap(time, value, serviceContext);
	}

	@Override
	public void deleteHeap(long heapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_heapService.deleteHeap(heapId);
	}

	@Override
	public com.nlu.entity.model.Heap getHeap(long heapId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _heapService.getHeap(heapId);
	}

	@Override
	public com.nlu.entity.model.Heap updateHeap(long heapId,
		java.util.Date time, double value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _heapService.updateHeap(heapId, time, value, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public HeapService getWrappedHeapService() {
		return _heapService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedHeapService(HeapService heapService) {
		_heapService = heapService;
	}

	@Override
	public HeapService getWrappedService() {
		return _heapService;
	}

	@Override
	public void setWrappedService(HeapService heapService) {
		_heapService = heapService;
	}

	private HeapService _heapService;
}