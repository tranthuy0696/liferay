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

import com.nlu.entity.model.AlarmInfo;

/**
 * The persistence interface for the alarm info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see AlarmInfoPersistenceImpl
 * @see AlarmInfoUtil
 * @generated
 */
public interface AlarmInfoPersistence extends BasePersistence<AlarmInfo> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AlarmInfoUtil} to access the alarm info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the alarm infos where name LIKE &#63;.
	*
	* @param name the name
	* @return the matching alarm infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.AlarmInfo> findByname(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the alarm infos where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of alarm infos
	* @param end the upper bound of the range of alarm infos (not inclusive)
	* @return the range of matching alarm infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.AlarmInfo> findByname(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the alarm infos where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of alarm infos
	* @param end the upper bound of the range of alarm infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching alarm infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.AlarmInfo> findByname(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first alarm info in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alarm info
	* @throws com.nlu.entity.NoSuchAlarmInfoException if a matching alarm info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.AlarmInfo findByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchAlarmInfoException;

	/**
	* Returns the first alarm info in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching alarm info, or <code>null</code> if a matching alarm info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.AlarmInfo fetchByname_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last alarm info in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alarm info
	* @throws com.nlu.entity.NoSuchAlarmInfoException if a matching alarm info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.AlarmInfo findByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchAlarmInfoException;

	/**
	* Returns the last alarm info in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching alarm info, or <code>null</code> if a matching alarm info could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.AlarmInfo fetchByname_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the alarm infos before and after the current alarm info in the ordered set where name LIKE &#63;.
	*
	* @param alarmInfoId the primary key of the current alarm info
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next alarm info
	* @throws com.nlu.entity.NoSuchAlarmInfoException if a alarm info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.AlarmInfo[] findByname_PrevAndNext(
		long alarmInfoId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchAlarmInfoException;

	/**
	* Removes all the alarm infos where name LIKE &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of alarm infos where name LIKE &#63;.
	*
	* @param name the name
	* @return the number of matching alarm infos
	* @throws SystemException if a system exception occurred
	*/
	public int countByname(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the alarm info in the entity cache if it is enabled.
	*
	* @param alarmInfo the alarm info
	*/
	public void cacheResult(com.nlu.entity.model.AlarmInfo alarmInfo);

	/**
	* Caches the alarm infos in the entity cache if it is enabled.
	*
	* @param alarmInfos the alarm infos
	*/
	public void cacheResult(
		java.util.List<com.nlu.entity.model.AlarmInfo> alarmInfos);

	/**
	* Creates a new alarm info with the primary key. Does not add the alarm info to the database.
	*
	* @param alarmInfoId the primary key for the new alarm info
	* @return the new alarm info
	*/
	public com.nlu.entity.model.AlarmInfo create(long alarmInfoId);

	/**
	* Removes the alarm info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param alarmInfoId the primary key of the alarm info
	* @return the alarm info that was removed
	* @throws com.nlu.entity.NoSuchAlarmInfoException if a alarm info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.AlarmInfo remove(long alarmInfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchAlarmInfoException;

	public com.nlu.entity.model.AlarmInfo updateImpl(
		com.nlu.entity.model.AlarmInfo alarmInfo)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the alarm info with the primary key or throws a {@link com.nlu.entity.NoSuchAlarmInfoException} if it could not be found.
	*
	* @param alarmInfoId the primary key of the alarm info
	* @return the alarm info
	* @throws com.nlu.entity.NoSuchAlarmInfoException if a alarm info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.AlarmInfo findByPrimaryKey(long alarmInfoId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchAlarmInfoException;

	/**
	* Returns the alarm info with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param alarmInfoId the primary key of the alarm info
	* @return the alarm info, or <code>null</code> if a alarm info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.AlarmInfo fetchByPrimaryKey(long alarmInfoId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the alarm infos.
	*
	* @return the alarm infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.AlarmInfo> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the alarm infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of alarm infos
	* @param end the upper bound of the range of alarm infos (not inclusive)
	* @return the range of alarm infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.AlarmInfo> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the alarm infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of alarm infos
	* @param end the upper bound of the range of alarm infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of alarm infos
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.AlarmInfo> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the alarm infos from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of alarm infos.
	*
	* @return the number of alarm infos
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}