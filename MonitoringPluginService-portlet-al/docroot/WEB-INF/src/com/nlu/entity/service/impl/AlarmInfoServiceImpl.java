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
import com.nlu.entity.model.AlarmInfo;
import com.nlu.entity.service.base.AlarmInfoServiceBaseImpl;

/**
 * The implementation of the alarm info remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.AlarmInfoService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.AlarmInfoServiceBaseImpl
 * @see com.nlu.entity.service.AlarmInfoServiceUtil
 */
public class AlarmInfoServiceImpl extends AlarmInfoServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.AlarmInfoServiceUtil} to access the alarm info remote service.
	 */
	public AlarmInfo addAlarmInfo(String name, String mail,
			ServiceContext serviceContext) throws PortalException, SystemException {
			/*
			 *                AlarmInfoPermission.check(getPermissionChecker(),
			 *                serviceContext.getScopeGroupId(), ActionKeys.ADD);
			 */
			return alarmInfoLocalService.addAlarmInfo( name, mail,
				serviceContext);
		}

		public void deleteAlarmInfo(long alarmInfoId)
			throws PortalException, SystemException {
			AlarmInfo alarmInfo = alarmInfoLocalService.getAlarmInfo(alarmInfoId);

			/*
			 *        AlarmInfoPermission.check(getPermissionChecker(), alarmInfo.getGroupId(),
			 *                ActionKeys.DELETE);
			 */
			alarmInfoLocalService.deleteAlarmInfo(alarmInfo);
		}

		public AlarmInfo getAlarmInfo(long alarmInfoId)
			throws PortalException, SystemException {
			AlarmInfo alarmInfo = alarmInfoLocalService.getAlarmInfo(alarmInfoId);

			/*
			 *        AlarmInfoPermission.check(getPermissionChecker(), alarmInfo.getGroupId(),
			 *                ActionKeys.VIEW);
			 */
			return alarmInfo;
		}

		public AlarmInfo updateAlarmInfo(long alarmInfoId, String name,
			String mail, ServiceContext serviceContext)
			throws PortalException, SystemException {
			AlarmInfo alarmInfo = alarmInfoLocalService.getAlarmInfo(alarmInfoId);

			/*
			 *        AlarmInfoPermission.check(getPermissionChecker(), alarmInfo.getGroupId(),
			 *                ActionKeys.EDIT);
			 */
			return alarmInfoLocalService.updateAlarmInfo(alarmInfoId, name, mail,
				serviceContext);
		}
}