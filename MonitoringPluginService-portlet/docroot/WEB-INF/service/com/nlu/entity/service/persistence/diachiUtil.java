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

import com.nlu.entity.model.diachi;

import java.util.List;

/**
 * The persistence utility for the diachi service. This utility wraps {@link diachiPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see diachiPersistence
 * @see diachiPersistenceImpl
 * @generated
 */
public class diachiUtil {
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
	public static void clearCache(diachi diachi) {
		getPersistence().clearCache(diachi);
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
	public static List<diachi> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<diachi> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<diachi> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static diachi update(diachi diachi) throws SystemException {
		return getPersistence().update(diachi);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static diachi update(diachi diachi, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(diachi, serviceContext);
	}

	/**
	* Returns the diachi where id = &#63; or throws a {@link com.nlu.entity.NoSuchdiachiException} if it could not be found.
	*
	* @param id the ID
	* @return the matching diachi
	* @throws com.nlu.entity.NoSuchdiachiException if a matching diachi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.diachi findByID(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchdiachiException {
		return getPersistence().findByID(id);
	}

	/**
	* Returns the diachi where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching diachi, or <code>null</code> if a matching diachi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.diachi fetchByID(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByID(id);
	}

	/**
	* Returns the diachi where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching diachi, or <code>null</code> if a matching diachi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.diachi fetchByID(long id,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByID(id, retrieveFromCache);
	}

	/**
	* Removes the diachi where id = &#63; from the database.
	*
	* @param id the ID
	* @return the diachi that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.diachi removeByID(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchdiachiException {
		return getPersistence().removeByID(id);
	}

	/**
	* Returns the number of diachis where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching diachis
	* @throws SystemException if a system exception occurred
	*/
	public static int countByID(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByID(id);
	}

	/**
	* Caches the diachi in the entity cache if it is enabled.
	*
	* @param diachi the diachi
	*/
	public static void cacheResult(com.nlu.entity.model.diachi diachi) {
		getPersistence().cacheResult(diachi);
	}

	/**
	* Caches the diachis in the entity cache if it is enabled.
	*
	* @param diachis the diachis
	*/
	public static void cacheResult(
		java.util.List<com.nlu.entity.model.diachi> diachis) {
		getPersistence().cacheResult(diachis);
	}

	/**
	* Creates a new diachi with the primary key. Does not add the diachi to the database.
	*
	* @param id the primary key for the new diachi
	* @return the new diachi
	*/
	public static com.nlu.entity.model.diachi create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the diachi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the diachi
	* @return the diachi that was removed
	* @throws com.nlu.entity.NoSuchdiachiException if a diachi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.diachi remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchdiachiException {
		return getPersistence().remove(id);
	}

	public static com.nlu.entity.model.diachi updateImpl(
		com.nlu.entity.model.diachi diachi)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(diachi);
	}

	/**
	* Returns the diachi with the primary key or throws a {@link com.nlu.entity.NoSuchdiachiException} if it could not be found.
	*
	* @param id the primary key of the diachi
	* @return the diachi
	* @throws com.nlu.entity.NoSuchdiachiException if a diachi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.diachi findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchdiachiException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the diachi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the diachi
	* @return the diachi, or <code>null</code> if a diachi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.nlu.entity.model.diachi fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	* Returns all the diachis.
	*
	* @return the diachis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.nlu.entity.model.diachi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the diachis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.diachiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of diachis
	* @param end the upper bound of the range of diachis (not inclusive)
	* @return the range of diachis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.nlu.entity.model.diachi> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the diachis.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.diachiModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of diachis
	* @param end the upper bound of the range of diachis (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of diachis
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.nlu.entity.model.diachi> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the diachis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of diachis.
	*
	* @return the number of diachis
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static diachiPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (diachiPersistence)PortletBeanLocatorUtil.locate(com.nlu.entity.service.ClpSerializer.getServletContextName(),
					diachiPersistence.class.getName());

			ReferenceRegistry.registerReference(diachiUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(diachiPersistence persistence) {
	}

	private static diachiPersistence _persistence;
}