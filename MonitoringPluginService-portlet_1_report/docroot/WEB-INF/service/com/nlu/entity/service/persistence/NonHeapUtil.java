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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.nlu.entity.model.NonHeap;

import java.util.List;

/**
 * The persistence utility for the non heap service. This utility wraps {@link NonHeapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see NonHeapPersistence
 * @see NonHeapPersistenceImpl
 * @generated
 */
public class NonHeapUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(NonHeap nonHeap) {
		getPersistence().clearCache(nonHeap);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<NonHeap> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<NonHeap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<NonHeap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static NonHeap update(NonHeap nonHeap) throws SystemException {
		return getPersistence().update(nonHeap);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static NonHeap update(NonHeap nonHeap, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(nonHeap, serviceContext);
	}

	/**
	* Caches the non heap in the entity cache if it is enabled.
	*
	* @param nonHeap the non heap
	*/
	public static void cacheResult(com.nlu.entity.model.NonHeap nonHeap) {
		getPersistence().cacheResult(nonHeap);
	}

	/**
	* Caches the non heaps in the entity cache if it is enabled.
	*
	* @param nonHeaps the non heaps
	*/
	public static void cacheResult(
		java.util.List<com.nlu.entity.model.NonHeap> nonHeaps) {
		getPersistence().cacheResult(nonHeaps);
	}

	/**
	* Creates a new non heap with the primary key. Does not add the non heap to the database.
	*
	* @param nonHeapId the primary key for the new non heap
	* @return the new non heap
	*/
	public static com.nlu.entity.model.NonHeap create(long nonHeapId) {
		return getPersistence().create(nonHeapId);
	}

	/**
	* Removes the non heap with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param nonHeapId the primary key of the non heap
	* @return the non heap that was removed
	* @throws com.nlu.entity.NoSuchNonHeapException if a non heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.NonHeap remove(long nonHeapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchNonHeapException {
		return getPersistence().remove(nonHeapId);
	}

	public static com.nlu.entity.model.NonHeap updateImpl(
		com.nlu.entity.model.NonHeap nonHeap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(nonHeap);
	}

	/**
	* Returns the non heap with the primary key or throws a {@link com.nlu.entity.NoSuchNonHeapException} if it could not be found.
	*
	* @param nonHeapId the primary key of the non heap
	* @return the non heap
	* @throws com.nlu.entity.NoSuchNonHeapException if a non heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.NonHeap findByPrimaryKey(long nonHeapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchNonHeapException {
		return getPersistence().findByPrimaryKey(nonHeapId);
	}

	/**
	* Returns the non heap with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param nonHeapId the primary key of the non heap
	* @return the non heap, or <code>null</code> if a non heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.NonHeap fetchByPrimaryKey(long nonHeapId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(nonHeapId);
	}

	/**
	* Returns all the non heaps.
	*
	* @return the non heaps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.nlu.entity.model.NonHeap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.nlu.entity.model.NonHeap> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.nlu.entity.model.NonHeap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the non heaps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of non heaps.
	*
	* @return the number of non heaps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static NonHeapPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (NonHeapPersistence)PortletBeanLocatorUtil.locate(com.nlu.entity.service.ClpSerializer.getServletContextName(),
					NonHeapPersistence.class.getName());

			ReferenceRegistry.registerReference(NonHeapUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(NonHeapPersistence persistence) {
	}

	private static NonHeapPersistence _persistence;
}