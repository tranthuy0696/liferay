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

package com.nlu.entity.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.nlu.entity.model.Alarm;
import com.nlu.entity.service.base.AlarmServiceBaseImpl;

/**
 * The implementation of the alarm remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.AlarmService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.AlarmServiceBaseImpl
 * @see com.nlu.entity.service.AlarmServiceUtil
 */
public class AlarmServiceImpl extends AlarmServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.AlarmServiceUtil} to access the alarm remote service.
	 */
	public Alarm addAlarm(String name, int startTime, int endTime,
			double value, ServiceContext serviceContext)
			throws PortalException, SystemException {
			/*
			 *                AlarmPermission.check(getPermissionChecker(),
			 *                serviceContext.getScopeGroupId(), ActionKeys.ADD);
			 */
			return alarmLocalService.addAlarm( name, startTime,
				endTime, value, serviceContext);
		}

		public void deleteAlarm(long alarmId)
			throws PortalException, SystemException {
			Alarm alarm = alarmLocalService.getAlarm(alarmId);

			/*
			 *        AlarmPermission.check(getPermissionChecker(), alarm.getGroupId(),
			 *                ActionKeys.DELETE);
			 */
			alarmLocalService.deleteAlarm(alarm);
		}

		public Alarm getAlarm(long alarmId) throws PortalException, SystemException {
			Alarm alarm = alarmLocalService.getAlarm(alarmId);

			/*
			 *        AlarmPermission.check(getPermissionChecker(), alarm.getGroupId(),
			 *                ActionKeys.VIEW);
			 */
			return alarm;
		}

		public Alarm updateAlarm(long alarmId, String name, int startTime,
			int endTime, double value, ServiceContext serviceContext)
			throws PortalException, SystemException {
			Alarm alarm = alarmLocalService.getAlarm(alarmId);

			/*
			 *        AlarmPermission.check(getPermissionChecker(), alarm.getGroupId(),
			 *                ActionKeys.EDIT);
			 */
			return alarmLocalService.updateAlarm(alarmId, name, startTime, endTime,
				value, serviceContext);
		}
	
}