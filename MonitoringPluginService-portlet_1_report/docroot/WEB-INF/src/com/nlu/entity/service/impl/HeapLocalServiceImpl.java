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
import com.nlu.entity.model.Heap;
import com.nlu.entity.service.base.HeapLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the heap local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.HeapLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.HeapLocalServiceBaseImpl
 * @see com.nlu.entity.service.HeapLocalServiceUtil
 */
public class HeapLocalServiceImpl extends HeapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.HeapLocalServiceUtil} to access the heap local service.
	 */
	public Heap addHeap( Date time, double value,
		ServiceContext serviceContext) throws SystemException, PortalException {

		long heapId = counterLocalService.increment(Heap.class.getName());
		Heap heap = heapPersistence.create(heapId);

		heap.setTime(time);
		heap.setValue(value);
		heap.setExpandoBridgeAttributes(serviceContext);

		addHeap(heap);

		return heap;
	}

	public Heap updateHeap(long heapId, Date time, double value,
		ServiceContext serviceContext) throws SystemException, PortalException {
		Heap heap = heapPersistence.fetchByPrimaryKey(heapId);

		heap.setTime(time);
		heap.setValue(value);
		heap.setExpandoBridgeAttributes(serviceContext);

		updateHeap(heap);

		return heap;
	}
	public List<Heap> findAll() throws SystemException{
		return heapPersistence.findAll();
	}
	public void deleteHeapByDate(int numberDate){
		heapFinder.deleteHeapByDate(numberDate);
	}
}