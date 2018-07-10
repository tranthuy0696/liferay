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
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.nlu.entity.model.Cpu;
import com.nlu.entity.model.Ram;
import com.nlu.entity.service.base.RamLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

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
public class RamLocalServiceImpl extends RamLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.RamLocalServiceUtil} to access the ram local service.
	 */
	public Ram addRam( Date time, double value,
		ServiceContext serviceContext) throws SystemException, PortalException {

		long ramId = counterLocalService.increment(Ram.class.getName());
		Ram ram = ramPersistence.create(ramId);

		ram.setTime(time);
		ram.setValue(value);
		ram.setExpandoBridgeAttributes(serviceContext);

		addRam(ram);

		return ram;
	}

	public Ram updateRam(long ramId, Date time, double value,
		ServiceContext serviceContext) throws SystemException, PortalException {
		Ram ram = ramPersistence.fetchByPrimaryKey(ramId);

		ram.setTime(time);
		ram.setValue(value);
		ram.setExpandoBridgeAttributes(serviceContext);

		updateRam(ram);

		return ram;
	}
	public List<Ram> findAll() throws SystemException{
		return ramPersistence.findAll();
	}
	public int countByDate(Date time) throws SystemException {
		return ramPersistence.countByDate(time);
	}

	public List<Ram> findByDate(Date time) throws SystemException {
		return ramPersistence.findByDate(time);
	}

	public List<Ram> findByDate(Date time, int start, int end)
		throws SystemException {
		return ramPersistence.findByDate(time, start, end);
	}

	public List<Ram> findByDate(Date time, int start, int end,
		OrderByComparator obc) throws SystemException {
		return ramPersistence.findByDate(time, start, end, obc);
	}

	public void removeByDate(Date time) throws SystemException {
		ramPersistence.removeByDate(time);
	}
	public List<Ram> getRamByDate(Date date) {
		return ramFinder.getRamByDate(date);
	}
	public void deleteRamByDate(int numberDate){
		 ramFinder.deleteRamByDate(numberDate);
	}
}