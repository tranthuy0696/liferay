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

package com.nlu.entity.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.nlu.entity.model.NonHeap;

/**
 * The persistence interface for the non heap service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see NonHeapPersistenceImpl
 * @see NonHeapUtil
 * @generated
 */
public interface NonHeapPersistence extends BasePersistence<NonHeap> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link NonHeapUtil} to access the non heap persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the non heap in the entity cache if it is enabled.
	*
	* @param nonHeap the non heap
	*/
	public void cacheResult(com.nlu.entity.model.NonHeap nonHeap);

	/**
	* Caches the non heaps in the entity cache if it is enabled.
	*
	* @param nonHeaps the non heaps
	*/
	public void cacheResult(
		java.util.List<com.nlu.entity.model.NonHeap> nonHeaps);

	/**
	* Creates a new non heap with the primary key. Does not add the non heap to the database.
	*
	* @param nonHeapId the primary key for the new non heap
	* @return the new non heap
	*/
	public com.nlu.entity.model.NonHeap create(long nonHeapId);

	/**
	* Removes the non heap with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param nonHeapId the primary key of the non heap
	* @return the non heap that was removed
	* @throws com.nlu.entity.NoSuchNonHeapException if a non heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.NonHeap remove(long nonHeapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchNonHeapException;

	public com.nlu.entity.model.NonHeap updateImpl(
		com.nlu.entity.model.NonHeap nonHeap)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the non heap with the primary key or throws a {@link com.nlu.entity.NoSuchNonHeapException} if it could not be found.
	*
	* @param nonHeapId the primary key of the non heap
	* @return the non heap
	* @throws com.nlu.entity.NoSuchNonHeapException if a non heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.NonHeap findByPrimaryKey(long nonHeapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchNonHeapException;

	/**
	* Returns the non heap with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param nonHeapId the primary key of the non heap
	* @return the non heap, or <code>null</code> if a non heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.NonHeap fetchByPrimaryKey(long nonHeapId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the non heaps.
	*
	* @return the non heaps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.NonHeap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the non heaps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.NonHeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of non heaps
	* @param end the upper bound of the range of non heaps (not inclusive)
	* @return the range of non heaps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.NonHeap> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the non heaps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.NonHeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of non heaps
	* @param end the upper bound of the range of non heaps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of non heaps
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.NonHeap> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the non heaps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of non heaps.
	*
	* @return the number of non heaps
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}