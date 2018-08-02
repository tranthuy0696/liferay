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
 * Provides a wrapper for {@link AlarmInfoService}.
 *
 * @author NgocBao
 * @see AlarmInfoService
 * @generated
 */
public class AlarmInfoServiceWrapper implements AlarmInfoService,
	ServiceWrapper<AlarmInfoService> {
	public AlarmInfoServiceWrapper(AlarmInfoService alarmInfoService) {
		_alarmInfoService = alarmInfoService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _alarmInfoService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_alarmInfoService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _alarmInfoService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.nlu.entity.model.AlarmInfo addAlarmInfo(java.lang.String name,
		java.lang.String mail,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoService.addAlarmInfo(name, mail, serviceContext);
	}

	@Override
	public void deleteAlarmInfo(long alarmInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_alarmInfoService.deleteAlarmInfo(alarmInfoId);
	}

	@Override
	public com.nlu.entity.model.AlarmInfo getAlarmInfo(long alarmInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoService.getAlarmInfo(alarmInfoId);
	}

	@Override
	public com.nlu.entity.model.AlarmInfo updateAlarmInfo(long alarmInfoId,
		java.lang.String name, java.lang.String mail,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _alarmInfoService.updateAlarmInfo(alarmInfoId, name, mail,
			serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public AlarmInfoService getWrappedAlarmInfoService() {
		return _alarmInfoService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedAlarmInfoService(AlarmInfoService alarmInfoService) {
		_alarmInfoService = alarmInfoService;
	}

	@Override
	public AlarmInfoService getWrappedService() {
		return _alarmInfoService;
	}

	@Override
	public void setWrappedService(AlarmInfoService alarmInfoService) {
		_alarmInfoService = alarmInfoService;
	}

	private AlarmInfoService _alarmInfoService;
}