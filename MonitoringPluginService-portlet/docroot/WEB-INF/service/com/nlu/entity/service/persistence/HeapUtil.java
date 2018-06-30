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

import com.nlu.entity.model.Heap;

import java.util.List;

/**
 * The persistence utility for the heap service. This utility wraps {@link HeapPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see HeapPersistence
 * @see HeapPersistenceImpl
 * @generated
 */
public class HeapUtil {
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
	public static void clearCache(Heap heap) {
		getPersistence().clearCache(heap);
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
	public static List<Heap> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Heap> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Heap> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Heap update(Heap heap) throws SystemException {
		return getPersistence().update(heap);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Heap update(Heap heap, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(heap, serviceContext);
	}

	/**
	* Caches the heap in the entity cache if it is enabled.
	*
	* @param heap the heap
	*/
	public static void cacheResult(com.nlu.entity.model.Heap heap) {
		getPersistence().cacheResult(heap);
	}

	/**
	* Caches the heaps in the entity cache if it is enabled.
	*
	* @param heaps the heaps
	*/
	public static void cacheResult(
		java.util.List<com.nlu.entity.model.Heap> heaps) {
		getPersistence().cacheResult(heaps);
	}

	/**
	* Creates a new heap with the primary key. Does not add the heap to the database.
	*
	* @param heapId the primary key for the new heap
	* @return the new heap
	*/
	public static com.nlu.entity.model.Heap create(long heapId) {
		return getPersistence().create(heapId);
	}

	/**
	* Removes the heap with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param heapId the primary key of the heap
	* @return the heap that was removed
	* @throws com.nlu.entity.NoSuchHeapException if a heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.Heap remove(long heapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchHeapException {
		return getPersistence().remove(heapId);
	}

	public static com.nlu.entity.model.Heap updateImpl(
		com.nlu.entity.model.Heap heap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(heap);
	}

	/**
	* Returns the heap with the primary key or throws a {@link com.nlu.entity.NoSuchHeapException} if it could not be found.
	*
	* @param heapId the primary key of the heap
	* @return the heap
	* @throws com.nlu.entity.NoSuchHeapException if a heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.Heap findByPrimaryKey(long heapId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchHeapException {
		return getPersistence().findByPrimaryKey(heapId);
	}

	/**
	* Returns the heap with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param heapId the primary key of the heap
	* @return the heap, or <code>null</code> if a heap with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.Heap fetchByPrimaryKey(long heapId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(heapId);
	}

	/**
	* Returns all the heaps.
	*
	* @return the heaps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.nlu.entity.model.Heap> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the heaps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.HeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of heaps
	* @param end the upper bound of the range of heaps (not inclusive)
	* @return the range of heaps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.nlu.entity.model.Heap> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the heaps.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.HeapModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of heaps
	* @param end the upper bound of the range of heaps (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of heaps
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.nlu.entity.model.Heap> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the heaps from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of heaps.
	*
	* @return the number of heaps
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static HeapPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (HeapPersistence)PortletBeanLocatorUtil.locate(com.nlu.entity.service.ClpSerializer.getServletContextName(),
					HeapPersistence.class.getName());

			ReferenceRegistry.registerReference(HeapUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(HeapPersistence persistence) {
	}

	private static HeapPersistence _persistence;
}