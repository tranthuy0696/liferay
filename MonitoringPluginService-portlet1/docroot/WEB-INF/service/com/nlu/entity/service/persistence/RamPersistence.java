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

import com.nlu.entity.model.Ram;

/**
 * The persistence interface for the ram service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see RamPersistenceImpl
 * @see RamUtil
 * @generated
 */
public interface RamPersistence extends BasePersistence<Ram> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RamUtil} to access the ram persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the rams where time LIKE &#63;.
	*
	* @param time the time
	* @return the matching rams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.Ram> findByDate(
		java.util.Date time)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rams where time LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.RamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param time the time
	* @param start the lower bound of the range of rams
	* @param end the upper bound of the range of rams (not inclusive)
	* @return the range of matching rams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.Ram> findByDate(
		java.util.Date time, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rams where time LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.RamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param time the time
	* @param start the lower bound of the range of rams
	* @param end the upper bound of the range of rams (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.Ram> findByDate(
		java.util.Date time, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ram in the ordered set where time LIKE &#63;.
	*
	* @param time the time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ram
	* @throws com.nlu.entity.NoSuchRamException if a matching ram could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Ram findByDate_First(java.util.Date time,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchRamException;

	/**
	* Returns the first ram in the ordered set where time LIKE &#63;.
	*
	* @param time the time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ram, or <code>null</code> if a matching ram could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Ram fetchByDate_First(java.util.Date time,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ram in the ordered set where time LIKE &#63;.
	*
	* @param time the time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ram
	* @throws com.nlu.entity.NoSuchRamException if a matching ram could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Ram findByDate_Last(java.util.Date time,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchRamException;

	/**
	* Returns the last ram in the ordered set where time LIKE &#63;.
	*
	* @param time the time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ram, or <code>null</code> if a matching ram could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Ram fetchByDate_Last(java.util.Date time,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the rams before and after the current ram in the ordered set where time LIKE &#63;.
	*
	* @param ramId the primary key of the current ram
	* @param time the time
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ram
	* @throws com.nlu.entity.NoSuchRamException if a ram with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Ram[] findByDate_PrevAndNext(long ramId,
		java.util.Date time,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchRamException;

	/**
	* Removes all the rams where time LIKE &#63; from the database.
	*
	* @param time the time
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDate(java.util.Date time)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rams where time LIKE &#63;.
	*
	* @param time the time
	* @return the number of matching rams
	* @throws SystemException if a system exception occurred
	*/
	public int countByDate(java.util.Date time)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the ram in the entity cache if it is enabled.
	*
	* @param ram the ram
	*/
	public void cacheResult(com.nlu.entity.model.Ram ram);

	/**
	* Caches the rams in the entity cache if it is enabled.
	*
	* @param rams the rams
	*/
	public void cacheResult(java.util.List<com.nlu.entity.model.Ram> rams);

	/**
	* Creates a new ram with the primary key. Does not add the ram to the database.
	*
	* @param ramId the primary key for the new ram
	* @return the new ram
	*/
	public com.nlu.entity.model.Ram create(long ramId);

	/**
	* Removes the ram with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ramId the primary key of the ram
	* @return the ram that was removed
	* @throws com.nlu.entity.NoSuchRamException if a ram with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Ram remove(long ramId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchRamException;

	public com.nlu.entity.model.Ram updateImpl(com.nlu.entity.model.Ram ram)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ram with the primary key or throws a {@link com.nlu.entity.NoSuchRamException} if it could not be found.
	*
	* @param ramId the primary key of the ram
	* @return the ram
	* @throws com.nlu.entity.NoSuchRamException if a ram with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Ram findByPrimaryKey(long ramId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchRamException;

	/**
	* Returns the ram with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ramId the primary key of the ram
	* @return the ram, or <code>null</code> if a ram with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Ram fetchByPrimaryKey(long ramId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the rams.
	*
	* @return the rams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.Ram> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the rams.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.RamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rams
	* @param end the upper bound of the range of rams (not inclusive)
	* @return the range of rams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.Ram> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the rams.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.RamModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of rams
	* @param end the upper bound of the range of rams (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of rams
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.Ram> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the rams from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rams.
	*
	* @return the number of rams
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}