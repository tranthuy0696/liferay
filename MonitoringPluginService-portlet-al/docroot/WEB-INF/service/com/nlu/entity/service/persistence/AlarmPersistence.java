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

import com.nlu.entity.model.Alarm;

/**
 * The persistence interface for the alarm service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author NgocBao
 * @see AlarmPersistenceImpl
 * @see AlarmUtil
 * @generated
 */
public interface AlarmPersistence extends BasePersistence<Alarm> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AlarmUtil} to access the alarm persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the alarm in the entity cache if it is enabled.
	*
	* @param alarm the alarm
	*/
	public void cacheResult(com.nlu.entity.model.Alarm alarm);

	/**
	* Caches the alarms in the entity cache if it is enabled.
	*
	* @param alarms the alarms
	*/
	public void cacheResult(java.util.List<com.nlu.entity.model.Alarm> alarms);

	/**
	* Creates a new alarm with the primary key. Does not add the alarm to the database.
	*
	* @param alarmId the primary key for the new alarm
	* @return the new alarm
	*/
	public com.nlu.entity.model.Alarm create(long alarmId);

	/**
	* Removes the alarm with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param alarmId the primary key of the alarm
	* @return the alarm that was removed
	* @throws com.nlu.entity.NoSuchAlarmException if a alarm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Alarm remove(long alarmId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchAlarmException;

	public com.nlu.entity.model.Alarm updateImpl(
		com.nlu.entity.model.Alarm alarm)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the alarm with the primary key or throws a {@link com.nlu.entity.NoSuchAlarmException} if it could not be found.
	*
	* @param alarmId the primary key of the alarm
	* @return the alarm
	* @throws com.nlu.entity.NoSuchAlarmException if a alarm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Alarm findByPrimaryKey(long alarmId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.nlu.entity.NoSuchAlarmException;

	/**
	* Returns the alarm with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param alarmId the primary key of the alarm
	* @return the alarm, or <code>null</code> if a alarm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.nlu.entity.model.Alarm fetchByPrimaryKey(long alarmId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the alarms.
	*
	* @return the alarms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.Alarm> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the alarms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of alarms
	* @param end the upper bound of the range of alarms (not inclusive)
	* @return the range of alarms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.Alarm> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the alarms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of alarms
	* @param end the upper bound of the range of alarms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of alarms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.nlu.entity.model.Alarm> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the alarms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of alarms.
	*
	* @return the number of alarms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}