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
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.nlu.entity.model.Ram;
import com.nlu.entity.service.base.RamLocalServiceBaseImpl;

/**
 * The implementation of the ram local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.RamLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.RamLocalServiceBaseImpl
 * @see com.nlu.entity.service.RamLocalServiceUtil
 */
public  class RamLocalServiceImpl extends RamLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.RamLocalServiceUtil} to access the ram local service.
	 */
	public Ram addRam( Date time, double min, double max,
		double aver, ServiceContext serviceContext)
		throws SystemException, PortalException {
		

		long ramId = counterLocalService.increment(Ram.class.getName());
		Ram ram = ramPersistence.create(ramId);

		ram.setTime(time);
		ram.setMin(min);
		ram.setMax(max);
		ram.setAver(aver);
		ram.setExpandoBridgeAttributes(serviceContext);

		addRam(ram);

		return ram;
	}

	public Ram updateRam(long ramId, Date time, double min, double max,
		double aver, ServiceContext serviceContext)
		throws SystemException, PortalException {
		Ram ram = ramPersistence.fetchByPrimaryKey(ramId);

		ram.setTime(time);
		ram.setMin(min);
		ram.setMax(max);
		ram.setAver(aver);
		ram.setExpandoBridgeAttributes(serviceContext);

		updateRam(ram);

		return ram;
	}
	public List<Ram> findAll() throws SystemException{
		return ramPersistence.findAll();
	}
	public List<Ram> findDate() throws SystemException{
		return ramPersistence.findByDate(new Date());
	}
	public void deleteAll() throws SystemException{
		ramPersistence.removeAll();
		
	}
	
}