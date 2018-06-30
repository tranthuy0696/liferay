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
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.nlu.entity.model.Cpu;
import com.nlu.entity.model.NonHeap;
import com.nlu.entity.service.base.NonHeapLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the non heap local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.NonHeapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.NonHeapLocalServiceBaseImpl
 * @see com.nlu.entity.service.NonHeapLocalServiceUtil
 */
public class NonHeapLocalServiceImpl extends NonHeapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.NonHeapLocalServiceUtil} to access the non heap local service.
	 */
	public NonHeap addNonHeap( Date time, double value,
		ServiceContext serviceContext) throws SystemException, PortalException {

		long nonHeapId = counterLocalService.increment(NonHeap.class.getName());
		NonHeap nonHeap = nonHeapPersistence.create(nonHeapId);

		nonHeap.setTime(time);
		nonHeap.setValue(value);
		nonHeap.setExpandoBridgeAttributes(serviceContext);

		addNonHeap(nonHeap);

		return nonHeap;
	}

	public NonHeap updateNonHeap(long nonHeapId, Date time, double value,
		ServiceContext serviceContext) throws SystemException, PortalException {
		NonHeap nonHeap = nonHeapPersistence.fetchByPrimaryKey(nonHeapId);

		nonHeap.setTime(time);
		nonHeap.setValue(value);
		nonHeap.setExpandoBridgeAttributes(serviceContext);

		updateNonHeap(nonHeap);

		return nonHeap;
	}
	public List<NonHeap> findAll() throws SystemException{
		return nonHeapPersistence.findAll();
	}
}