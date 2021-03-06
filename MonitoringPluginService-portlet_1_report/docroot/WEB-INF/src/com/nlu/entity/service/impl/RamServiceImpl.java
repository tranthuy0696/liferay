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

import com.nlu.entity.model.Ram;
import com.nlu.entity.service.base.RamServiceBaseImpl;

import java.util.Date;

/**
 * The implementation of the ram remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.RamService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.RamServiceBaseImpl
 * @see com.nlu.entity.service.RamServiceUtil
 */
public class RamServiceImpl extends RamServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.RamServiceUtil} to access the ram remote service.
	 */
	public Ram addRam(Date time, double value, ServiceContext serviceContext)
		throws PortalException, SystemException {
		/*
		 *                RamPermission.check(getPermissionChecker(),
		 *                serviceContext.getScopeGroupId(), ActionKeys.ADD);
		 */
		return ramLocalService.addRam( time, value, serviceContext);
	}

	public void deleteRam(long ramId) throws PortalException, SystemException {
		Ram ram = ramLocalService.getRam(ramId);

		/*
		 *        RamPermission.check(getPermissionChecker(), ram.getGroupId(),
		 *                ActionKeys.DELETE);
		 */
		ramLocalService.deleteRam(ram);
	}

	public Ram getRam(long ramId) throws PortalException, SystemException {
		Ram ram = ramLocalService.getRam(ramId);

		/*
		 *        RamPermission.check(getPermissionChecker(), ram.getGroupId(),
		 *                ActionKeys.VIEW);
		 */
		return ram;
	}

	public Ram updateRam(long ramId, Date time, double value,
		ServiceContext serviceContext) throws PortalException, SystemException {

		/*
		 *        RamPermission.check(getPermissionChecker(), ram.getGroupId(),
		 *                ActionKeys.EDIT);
		 */
		return ramLocalService.updateRam(ramId, time, value, serviceContext);
	}
}