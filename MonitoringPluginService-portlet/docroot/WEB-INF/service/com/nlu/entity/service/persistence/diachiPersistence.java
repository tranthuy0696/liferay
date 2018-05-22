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

import com.nlu.entity.model.diachi;

/**
 * The persistence interface for the diachi service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see diachiPersistenceImpl
 * @see diachiUtil
 * @generated
 */
public interface diachiPersistence extends BasePersistence<diachi> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link diachiUtil} to access the diachi persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the diachi where id = &#63; or throws a {@link com.nlu.entity.NoSuchdiachiException} if it could not be found.
	*
	* @param id the ID
	* @return the matching diachi
	* @throws com.nlu.entity.NoSuchdiachiException if a matching diachi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.diachi findByID(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchdiachiException;

	/**
	* Returns the diachi where id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param id the ID
	* @return the matching diachi, or <code>null</code> if a matching diachi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.diachi fetchByID(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the diachi where id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param id the ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching diachi, or <code>null</code> if a matching diachi could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.diachi fetchByID(long id,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the diachi where id = &#63; from the database.
	*
	* @param id the ID
	* @return the diachi that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.diachi removeByID(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchdiachiException;

	/**
	* Returns the number of diachis where id = &#63;.
	*
	* @param id the ID
	* @return the number of matching diachis
	* @throws SystemException if a system exception occurred
	*/
	public int countByID(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the diachi in the entity cache if it is enabled.
	*
	* @param diachi the diachi
	*/
	public void cacheResult(com.nlu.entity.model.diachi diachi);

	/**
	* Caches the diachis in the entity cache if it is enabled.
	*
	* @param diachis the diachis
	*/
	public void cacheResult(java.util.List<com.nlu.entity.model.diachi> diachis);

	/**
	* Creates a new diachi with the primary key. Does not add the diachi to the database.
	*
	* @param id the primary key for the new diachi
	* @return the new diachi
	*/
	public com.nlu.entity.model.diachi create(long id);

	/**
	* Removes the diachi with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the diachi
	* @return the diachi that was removed
	* @throws com.nlu.entity.NoSuchdiachiException if a diachi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.diachi remove(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchdiachiException;

	public com.nlu.entity.model.diachi updateImpl(
		com.nlu.entity.model.diachi diachi)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the diachi with the primary key or throws a {@link com.nlu.entity.NoSuchdiachiException} if it could not be found.
	*
	* @param id the primary key of the diachi
	* @return the diachi
	* @throws com.nlu.entity.NoSuchdiachiException if a diachi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.diachi findByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchdiachiException;

	/**
	* Returns the diachi with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the diachi
	* @return the diachi, or <code>null</code> if a diachi with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.diachi fetchByPrimaryKey(long id)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the diachis.
	*
	* @return the diachis
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.diachi> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.nlu.entity.model.diachi> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.nlu.entity.model.diachi> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the diachis from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of diachis.
	*
	* @return the number of diachis
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}