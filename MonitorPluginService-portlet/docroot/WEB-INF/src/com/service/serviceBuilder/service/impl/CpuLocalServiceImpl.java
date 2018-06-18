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

package com.service.serviceBuilder.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import com.service.serviceBuilder.model.Cpu;
import com.service.serviceBuilder.model.Ram;
import com.service.serviceBuilder.service.base.CpuLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the cpu local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.service.serviceBuilder.service.CpuLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author NgocBao
 * @see com.service.serviceBuilder.service.base.CpuLocalServiceBaseImpl
 * @see com.service.serviceBuilder.service.CpuLocalServiceUtil
 */
public class CpuLocalServiceImpl extends CpuLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.service.serviceBuilder.service.CpuLocalServiceUtil} to access the cpu
	 * local service.
	 */
	public Cpu addCpu( Date time, double min, double max, double aver, ServiceContext serviceContext)
			throws SystemException, PortalException {
		User user = userPersistence.findByPrimaryKey(userId);
		long groupId = serviceContext.getScopeGroupId();
		Date now = new Date();

		long cpuId = counterLocalService.increment(Cpu.class.getName());
		Cpu cpu = cpuPersistence.create(cpuId);

		cpu.setTime(time);
		cpu.setMin(min);
		cpu.setMax(max);
		cpu.setAver(aver);
		cpu.setExpandoBridgeAttributes(serviceContext);

		addCpu(cpu);

		return cpu;
	}

	public Cpu updateCpu(long cpuId, Date time, double min, double max, double aver, ServiceContext serviceContext)
			throws SystemException, PortalException {
		Cpu cpu = cpuPersistence.fetchByPrimaryKey(cpuId);

		cpu.setTime(time);
		cpu.setMin(min);
		cpu.setMax(max);
		cpu.setAver(aver);
		cpu.setExpandoBridgeAttributes(serviceContext);

		updateCpu(cpu);

		return cpu;
	}

	public List<Cpu> findAll() throws SystemException {

		return cpuPersistence.findAll();
	}

	@Override
	public Cpu addCpu(long arg0, Date arg1, double arg2, double arg3, double arg4, ServiceContext arg5)
			throws PortalException, SystemException {
		// TODO Auto-generated method stub
		return null;
	}
}