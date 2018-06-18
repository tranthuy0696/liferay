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
import com.nlu.entity.model.Cpu;
import com.nlu.entity.service.base.CpuServiceBaseImpl;

/**
 * The implementation of the cpu remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.CpuService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.CpuServiceBaseImpl
 * @see com.nlu.entity.service.CpuServiceUtil
 */
public class CpuServiceImpl extends CpuServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.CpuServiceUtil} to access the cpu remote service.
	 */
	public Cpu addCpu(Date time, double value, ServiceContext serviceContext)
		throws PortalException, SystemException {
		/*
		 *                CpuPermission.check(getPermissionChecker(),
		 *                serviceContext.getScopeGroupId(), ActionKeys.ADD);
		 */
		return cpuLocalService.addCpu( time, value, serviceContext);
	}

	public void deleteCpu(long cpuId) throws PortalException, SystemException {
		Cpu cpu = cpuLocalService.getCpu(cpuId);

		/*
		 *        CpuPermission.check(getPermissionChecker(), cpu.getGroupId(),
		 *                ActionKeys.DELETE);
		 */
		cpuLocalService.deleteCpu(cpu);
	}

	public Cpu getCpu(long cpuId) throws PortalException, SystemException {
		Cpu cpu = cpuLocalService.getCpu(cpuId);

		/*
		 *        CpuPermission.check(getPermissionChecker(), cpu.getGroupId(),
		 *                ActionKeys.VIEW);
		 */
		return cpu;
	}

	public Cpu updateCpu(long cpuId, Date time, double value,
		ServiceContext serviceContext) throws PortalException, SystemException {
		Cpu cpu = cpuLocalService.getCpu(cpuId);

		/*
		 *        CpuPermission.check(getPermissionChecker(), cpu.getGroupId(),
		 *                ActionKeys.EDIT);
		 */
		return cpuLocalService.updateCpu(cpuId, time, value, serviceContext);
	}
}