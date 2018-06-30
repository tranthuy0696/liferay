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

package com.nlu.entity.service.impl;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.nlu.entity.model.Heap;
import com.nlu.entity.service.base.HeapServiceBaseImpl;

/**
 * The implementation of the heap remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.HeapService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.HeapServiceBaseImpl
 * @see com.nlu.entity.service.HeapServiceUtil
 */
public class HeapServiceImpl extends HeapServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.HeapServiceUtil} to access the heap remote service.
	 */
	public Heap addHeap(Date time, double value, ServiceContext serviceContext)
		throws PortalException, SystemException {
		/*
		 *                HeapPermission.check(getPermissionChecker(),
		 *                serviceContext.getScopeGroupId(), ActionKeys.ADD);
		 */
		return heapLocalService.addHeap( time, value, serviceContext);
	}

	public void deleteHeap(long heapId) throws PortalException, SystemException {
		Heap heap = heapLocalService.getHeap(heapId);

		/*
		 *        HeapPermission.check(getPermissionChecker(), heap.getGroupId(),
		 *                ActionKeys.DELETE);
		 */
		heapLocalService.deleteHeap(heap);
	}

	public Heap getHeap(long heapId) throws PortalException, SystemException {
		Heap heap = heapLocalService.getHeap(heapId);

		/*
		 *        HeapPermission.check(getPermissionChecker(), heap.getGroupId(),
		 *                ActionKeys.VIEW);
		 */
		return heap;
	}

	public Heap updateHeap(long heapId, Date time, double value,
		ServiceContext serviceContext) throws PortalException, SystemException {
		Heap heap = heapLocalService.getHeap(heapId);

		/*
		 *        HeapPermission.check(getPermissionChecker(), heap.getGroupId(),
		 *                ActionKeys.EDIT);
		 */
		return heapLocalService.updateHeap(heapId, time, value, serviceContext);
	}
}