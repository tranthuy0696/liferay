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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import com.nlu.entity.model.NonHeap;
import com.nlu.entity.service.base.NonHeapServiceBaseImpl;

import java.util.Date;

/**
 * The implementation of the non heap remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.NonHeapService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.NonHeapServiceBaseImpl
 * @see com.nlu.entity.service.NonHeapServiceUtil
 */
public class NonHeapServiceImpl extends NonHeapServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.NonHeapServiceUtil} to access the non heap remote service.
	 */
	public NonHeap addNonHeap(Date time, double value,
		ServiceContext serviceContext) throws PortalException, SystemException {
		/*
		 *                NonHeapPermission.check(getPermissionChecker(),
		 *                serviceContext.getScopeGroupId(), ActionKeys.ADD);
		 */
		return nonHeapLocalService.addNonHeap( time, value,
			serviceContext);
	}

	public void deleteNonHeap(long nonHeapId)
		throws PortalException, SystemException {
		NonHeap nonHeap = nonHeapLocalService.getNonHeap(nonHeapId);

		/*
		 *        NonHeapPermission.check(getPermissionChecker(), nonHeap.getGroupId(),
		 *                ActionKeys.DELETE);
		 */
		nonHeapLocalService.deleteNonHeap(nonHeap);
	}

	public NonHeap getNonHeap(long nonHeapId)
		throws PortalException, SystemException {
		NonHeap nonHeap = nonHeapLocalService.getNonHeap(nonHeapId);

		/*
		 *        NonHeapPermission.check(getPermissionChecker(), nonHeap.getGroupId(),
		 *                ActionKeys.VIEW);
		 */
		return nonHeap;
	}

	public NonHeap updateNonHeap(long nonHeapId, Date time, double value,
		ServiceContext serviceContext) throws PortalException, SystemException {
		NonHeap nonHeap = nonHeapLocalService.getNonHeap(nonHeapId);

		/*
		 *        NonHeapPermission.check(getPermissionChecker(), nonHeap.getGroupId(),
		 *                ActionKeys.EDIT);
		 */
		return nonHeapLocalService.updateNonHeap(nonHeapId, time, value,
			serviceContext);
	}
}