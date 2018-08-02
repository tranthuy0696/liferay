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

package com.nlu.entity.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AlarmLocalService}.
 *
 * @author NgocBao
 * @see AlarmLocalService
 * @generated
 */
public class AlarmLocalServiceWrapper implements AlarmLocalService,
	ServiceWrapper<AlarmLocalService> {
	public AlarmLocalServiceWrapper(AlarmLocalService alarmLocalService) {
		_alarmLocalService = alarmLocalService;
	}

	/**
	* Adds the alarm to the database. Also notifies the appropriate model listeners.
	*
	* @param alarm the alarm
	* @return the alarm that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Alarm addAlarm(com.nlu.entity.model.Alarm alarm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.addAlarm(alarm);
	}

	/**
	* Creates a new alarm with the primary key. Does not add the alarm to the database.
	*
	* @param alarmId the primary key for the new alarm
	* @return the new alarm
	*/
	@Override
	public com.nlu.entity.model.Alarm createAlarm(long alarmId) {
		return _alarmLocalService.createAlarm(alarmId);
	}

	/**
	* Deletes the alarm with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param alarmId the primary key of the alarm
	* @return the alarm that was removed
	* @throws PortalException if a alarm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Alarm deleteAlarm(long alarmId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.deleteAlarm(alarmId);
	}

	/**
	* Deletes the alarm from the database. Also notifies the appropriate model listeners.
	*
	* @param alarm the alarm
	* @return the alarm that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Alarm deleteAlarm(
		com.nlu.entity.model.Alarm alarm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.deleteAlarm(alarm);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _alarmLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.nlu.entity.model.impl.AlarmModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.nlu.entity.model.Alarm fetchAlarm(long alarmId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.fetchAlarm(alarmId);
	}

	/**
	* Returns the alarm with the primary key.
	*
	* @param alarmId the primary key of the alarm
	* @return the alarm
	* @throws PortalException if a alarm with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Alarm getAlarm(long alarmId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.getAlarm(alarmId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.nlu.entity.model.Alarm> getAlarms(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.getAlarms(start, end);
	}

	/**
	* Returns the number of alarms.
	*
	* @return the number of alarms
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getAlarmsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.getAlarmsCount();
	}

	/**
	* Updates the alarm in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param alarm the alarm
	* @return the alarm that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.nlu.entity.model.Alarm updateAlarm(
		com.nlu.entity.model.Alarm alarm)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.updateAlarm(alarm);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _alarmLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_alarmLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _alarmLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.nlu.entity.model.Alarm addAlarm(java.lang.String name,
		int startTime, int endTime, double value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.addAlarm(name, startTime, endTime, value,
			serviceContext);
	}

	@Override
	public com.nlu.entity.model.Alarm updateAlarm(long alarmId,
		java.lang.String name, int startTime, int endTime, double value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmLocalService.updateAlarm(alarmId, name, startTime,
			endTime, value, serviceContext);
	}

	@Override
	public void deleteAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		_alarmLocalService.deleteAll();
	}

	@Override
	public com.nlu.entity.model.Alarm getAlarmByTime(int value,
		java.lang.String name) {
		return _alarmLocalService.getAlarmByTime(value, name);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AlarmLocalService getWrappedAlarmLocalService() {
		return _alarmLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAlarmLocalService(AlarmLocalService alarmLocalService) {
		_alarmLocalService = alarmLocalService;
	}

	@Override
	public AlarmLocalService getWrappedService() {
		return _alarmLocalService;
	}

	@Override
	public void setWrappedService(AlarmLocalService alarmLocalService) {
		_alarmLocalService = alarmLocalService;
	}

	private AlarmLocalService _alarmLocalService;
}