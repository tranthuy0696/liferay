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
 * Provides a wrapper for {@link AlarmService}.
 *
 * @author NgocBao
 * @see AlarmService
 * @generated
 */
public class AlarmServiceWrapper implements AlarmService,
	ServiceWrapper<AlarmService> {
	public AlarmServiceWrapper(AlarmService alarmService) {
		_alarmService = alarmService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _alarmService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_alarmService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _alarmService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.nlu.entity.model.Alarm addAlarm(java.lang.String name,
		int startTime, int endTime, double value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmService.addAlarm(name, startTime, endTime, value,
			serviceContext);
	}

	@Override
	public void deleteAlarm(long alarmId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_alarmService.deleteAlarm(alarmId);
	}

	@Override
	public com.nlu.entity.model.Alarm getAlarm(long alarmId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmService.getAlarm(alarmId);
	}

	@Override
	public com.nlu.entity.model.Alarm updateAlarm(long alarmId,
		java.lang.String name, int startTime, int endTime, double value,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmService.updateAlarm(alarmId, name, startTime, endTime,
			value, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AlarmService getWrappedAlarmService() {
		return _alarmService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAlarmService(AlarmService alarmService) {
		_alarmService = alarmService;
	}

	@Override
	public AlarmService getWrappedService() {
		return _alarmService;
	}

	@Override
	public void setWrappedService(AlarmService alarmService) {
		_alarmService = alarmService;
	}

	private AlarmService _alarmService;
}