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

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.nlu.entity.model.AlarmInfo;
import com.nlu.entity.service.base.AlarmInfoLocalServiceBaseImpl;

/**
 * The implementation of the alarm info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.AlarmInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.AlarmInfoLocalServiceBaseImpl
 * @see com.nlu.entity.service.AlarmInfoLocalServiceUtil
 */
public class AlarmInfoLocalServiceImpl extends AlarmInfoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.AlarmInfoLocalServiceUtil} to access the alarm info local service.
	 */
	public AlarmInfo addAlarmInfo( String name, String mail,
			ServiceContext serviceContext) throws SystemException, PortalException {
			

			long alarmInfoId = counterLocalService.increment(AlarmInfo.class.getName());
			AlarmInfo alarmInfo = alarmInfoPersistence.create(alarmInfoId);

			alarmInfo.setName(name);
			alarmInfo.setMail(mail);
			alarmInfo.setExpandoBridgeAttributes(serviceContext);

			addAlarmInfo(alarmInfo);

			return alarmInfo;
		}

		public AlarmInfo updateAlarmInfo(long alarmInfoId, String name,
			String mail, ServiceContext serviceContext)
			throws SystemException, PortalException {
			AlarmInfo alarmInfo = alarmInfoPersistence.fetchByPrimaryKey(alarmInfoId);

			alarmInfo.setName(name);
			alarmInfo.setMail(mail);
			alarmInfo.setExpandoBridgeAttributes(serviceContext);

			updateAlarmInfo(alarmInfo);
			

			return alarmInfo;
		}
		public List<AlarmInfo> findName(String name){
			try {
				System.out.println(alarmInfoPersistence.findByname(name));
				return alarmInfoPersistence.findByname(name);
				
			} catch (SystemException e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
}