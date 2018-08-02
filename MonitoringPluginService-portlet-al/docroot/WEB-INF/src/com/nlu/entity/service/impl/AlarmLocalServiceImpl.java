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
import com.nlu.entity.service.base.AlarmLocalServiceBaseImpl;
import com.nlu.entity.service.persistence.AlarmFinder;

/**
 * The implementation of the alarm local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.AlarmLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.AlarmLocalServiceBaseImpl
 * @see com.nlu.entity.service.AlarmLocalServiceUtil
 */
public class AlarmLocalServiceImpl extends AlarmLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.AlarmLocalServiceUtil} to access the alarm local service.
	 */
	public Alarm addAlarm( String name, int startTime, int endTime,
			double value, ServiceContext serviceContext)
			throws SystemException, PortalException {
			

			long alarmId = counterLocalService.increment(Alarm.class.getName());
			Alarm alarm = alarmPersistence.create(alarmId);

			alarm.setName(name);
			alarm.setStartTime(startTime);
			alarm.setEndTime(endTime);
			alarm.setValue(value);
			alarm.setExpandoBridgeAttributes(serviceContext);

			addAlarm(alarm);

			return alarm;
		}

		public Alarm updateAlarm(long alarmId, String name, int startTime,
			int endTime, double value, ServiceContext serviceContext)
			throws SystemException, PortalException {
			Alarm alarm = alarmPersistence.fetchByPrimaryKey(alarmId);

			alarm.setName(name);
			alarm.setStartTime(startTime);
			alarm.setEndTime(endTime);
			alarm.setValue(value);
			alarm.setExpandoBridgeAttributes(serviceContext);
			updateAlarm(alarm);
			return alarm;
		}
		public void deleteAll() throws SystemException{
			alarmPersistence.removeAll();
			
		}
		public Alarm getAlarmByTime(int value, String name){
			return alarmFinder.getAlarmByTime(value, name).get(0);
		}
}