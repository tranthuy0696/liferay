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

import com.nlu.entity.model.SessionRequest;
import com.nlu.entity.service.base.SessionRequestServiceBaseImpl;

import java.util.Date;

/**
 * The implementation of the session request remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.nlu.entity.service.SessionRequestService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author NgocBao
 * @see com.nlu.entity.service.base.SessionRequestServiceBaseImpl
 * @see com.nlu.entity.service.SessionRequestServiceUtil
 */
public class SessionRequestServiceImpl extends SessionRequestServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.nlu.entity.service.SessionRequestServiceUtil} to access the session request remote service.
	 */
	public SessionRequest addSessionRequest(String sessionId, Date time,
		String ip, String browser, String os, boolean login,
		ServiceContext serviceContext) throws PortalException, SystemException {
		/*
		 *                SessionRequestPermission.check(getPermissionChecker(),
		 *                serviceContext.getScopeGroupId(), ActionKeys.ADD);
		 */
		return sessionRequestLocalService.addSessionRequest(
			sessionId, time, ip, browser, os, login, serviceContext);
	}

	public void deleteSessionRequest(long sessionRequestId)
		throws PortalException, SystemException {
		SessionRequest sessionRequest = sessionRequestLocalService.getSessionRequest(sessionRequestId);

		/*
		 *        SessionRequestPermission.check(getPermissionChecker(), sessionRequest.getGroupId(),
		 *                ActionKeys.DELETE);
		 */
		sessionRequestLocalService.deleteSessionRequest(sessionRequest);
	}

	public SessionRequest getSessionRequest(long sessionRequestId)
		throws PortalException, SystemException {
		SessionRequest sessionRequest = sessionRequestLocalService.getSessionRequest(sessionRequestId);

		/*
		 *        SessionRequestPermission.check(getPermissionChecker(), sessionRequest.getGroupId(),
		 *                ActionKeys.VIEW);
		 */
		return sessionRequest;
	}

	public SessionRequest updateSessionRequest(long sessionRequestId,
		String sessionId, Date time, String ip, String browser, String os,
		boolean login, ServiceContext serviceContext)
		throws PortalException, SystemException {
		SessionRequest sessionRequest = sessionRequestLocalService.getSessionRequest(sessionRequestId);

		/*
		 *        SessionRequestPermission.check(getPermissionChecker(), sessionRequest.getGroupId(),
		 *                ActionKeys.EDIT);
		 */
		return sessionRequestLocalService.updateSessionRequest(sessionRequestId,
			sessionId, time, ip, browser, os, login, serviceContext);
	}
}